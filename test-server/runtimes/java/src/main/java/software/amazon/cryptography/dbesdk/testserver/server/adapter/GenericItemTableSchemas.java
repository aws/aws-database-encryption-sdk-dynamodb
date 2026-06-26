// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.server.adapter;

import java.util.Map;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverterProvider;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.enhanced.dynamodb.mapper.StaticAttributeTag;
import software.amazon.awssdk.enhanced.dynamodb.mapper.StaticAttributeTags;
import software.amazon.awssdk.enhanced.dynamodb.mapper.StaticTableSchema;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DoNothingTag;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.SignAndIncludeInEncryptionContextTag;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.SignOnlyTag;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;

/**
 * Builds a server-controlled {@code TableSchema} that lets the Enhanced Client round-trip arbitrary
 * modeled items (attribute maps) without a per-test annotated Java class.
 *
 * <h2>Why this is needed</h2>
 *
 * <p>The DynamoDB Enhanced Client derives the per-attribute cryptographic actions from a {@code
 * TableSchema}, not from an explicit action map: {@code
 * DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor} walks {@code
 * schema.attributeNames()} and reads the DB-ESDK custom metadata tags (SIGN_ONLY,
 * SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT, DO_NOTHING) off each attribute, defaulting untagged
 * non-key attributes to ENCRYPT_AND_SIGN and forcing primary-key attributes to SIGN_ONLY.
 *
 * <p>The TestServer model instead carries the actions explicitly as {@code
 * attributeActionsOnEncrypt}. To honor those exact actions through the Enhanced Client, this
 * factory builds a {@link StaticTableSchema} over {@link AttributeMapItem} in which:
 *
 * <ul>
 *   <li>the partition key (and sort key, if any) are declared with the {@code primaryPartitionKey}
 *       / {@code primarySortKey} tags, so the DB-ESDK forces them to SIGN_ONLY;
 *   <li>every other configured attribute is registered and tagged with the {@link
 *       StaticAttributeTag} corresponding to its requested {@link CryptoAction} — except
 *       ENCRYPT_AND_SIGN, which is the untagged default.
 * </ul>
 *
 * The actions the DB-ESDK derives from the resulting schema therefore equal the model's {@code
 * attributeActionsOnEncrypt}.
 *
 * <h2>Generic value handling</h2>
 *
 * <p>Each attribute is typed as the AWS SDK v2 {@link AttributeValue} and converted with {@link
 * IdentityAttributeConverter}, an identity (pass-through) converter. This lets any DynamoDB value
 * shape (S, N, B, BOOL, NULL, M, L, SS, NS, BS) flow through unchanged, so the schema does not need
 * to know attribute value types ahead of time.
 *
 * <h2>Known limitation</h2>
 *
 * <p>The model's {@code TableEncryptionConfig} does not carry key attribute <i>types</i>, so key
 * attributes are reported to the schema metadata as {@code AttributeValueType.S}. The actual value
 * type written/read is whatever {@link AttributeValue} the caller supplies (the physical table in
 * DynamoDB Local is created out of band with its real key schema), so this only affects the
 * enhanced client's in-memory metadata, not the wire value. Non-string primary keys are a possible
 * future enhancement once the model conveys key types.
 */
final class GenericItemTableSchemas {

  private GenericItemTableSchemas() {}

  /**
   * Builds the {@link StaticTableSchema} for one table from its encryption configuration.
   *
   * @param config the per-table configuration (key names + attribute actions)
   * @return a schema whose DB-ESDK-derived crypto actions equal {@code
   *     config.attributeActionsOnEncrypt()}
   */
  static StaticTableSchema<AttributeMapItem> buildSchema(final TableEncryptionConfigValue config) {
    final String partitionKeyName = config.partitionKeyName();
    final String sortKeyName = config.sortKeyName();

    final StaticTableSchema.Builder<AttributeMapItem> builder =
        StaticTableSchema.builder(AttributeMapItem.class)
            .newItemSupplier(AttributeMapItem::new)
            .attributeConverterProviders(new AttributeValueConverterProvider());

    // Partition key: declared as the primary partition key, which the DB-ESDK forces to SIGN_ONLY.
    builder.addAttribute(
        AttributeValue.class,
        a ->
            a.name(partitionKeyName)
                .getter(item -> item.get(partitionKeyName))
                .setter((item, value) -> putIfPresent(item, partitionKeyName, value))
                .tags(StaticAttributeTags.primaryPartitionKey()));

    // Optional sort key: declared as the primary sort key (also SIGN_ONLY).
    if (sortKeyName != null && !sortKeyName.isEmpty()) {
      builder.addAttribute(
          AttributeValue.class,
          a ->
              a.name(sortKeyName)
                  .getter(item -> item.get(sortKeyName))
                  .setter((item, value) -> putIfPresent(item, sortKeyName, value))
                  .tags(StaticAttributeTags.primarySortKey()));
    }

    // Every other configured attribute, tagged to match its requested CryptoAction.
    for (final Map.Entry<String, CryptoAction> entry :
        config.attributeActionsOnEncrypt().entrySet()) {
      final String attributeName = entry.getKey();
      if (attributeName.equals(partitionKeyName) || attributeName.equals(sortKeyName)) {
        // Key attributes are handled above; the DB-ESDK forces them to SIGN_ONLY and would reject
        // an additional conflicting crypto tag.
        continue;
      }
      final StaticAttributeTag cryptoTag = tagForAction(entry.getValue());
      builder.addAttribute(
          AttributeValue.class,
          a -> {
            a.name(attributeName)
                .getter(item -> item.get(attributeName))
                .setter((item, value) -> putIfPresent(item, attributeName, value));
            if (cryptoTag != null) {
              a.tags(cryptoTag);
            }
          });
    }

    return builder.build();
  }

  /**
   * Maps a model {@link CryptoAction} to the DB-ESDK {@link StaticAttributeTag} that produces it.
   *
   * <p>{@code ENCRYPT_AND_SIGN} returns {@code null} because it is the untagged default that the
   * DB-ESDK assigns to any non-key attribute without an encryption tag.
   *
   * @param action the requested crypto action
   * @return the corresponding attribute tag, or {@code null} for the ENCRYPT_AND_SIGN default
   * @throws IllegalArgumentException if {@code action} is not a recognized value
   */
  private static StaticAttributeTag tagForAction(final CryptoAction action) {
    switch (action) {
      case ENCRYPT_AND_SIGN:
        return null;
      case SIGN_ONLY:
        return new SignOnlyTag();
      case SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT:
        return new SignAndIncludeInEncryptionContextTag();
      case DO_NOTHING:
        return new DoNothingTag();
      default:
        throw new IllegalArgumentException("Unsupported CryptoAction: " + action);
    }
  }

  // The enhanced client invokes setters with a null value for attributes absent from a read item;
  // keep the backing map free of null entries so reads reflect exactly the stored attributes.
  private static void putIfPresent(
      final AttributeMapItem item, final String name, final AttributeValue value) {
    if (value != null) {
      item.put(name, value);
    }
  }

  /**
   * Identity {@link AttributeConverter} for AWS SDK v2 {@link AttributeValue}: the value passes
   * through unchanged in both directions, so any DynamoDB value shape round-trips losslessly.
   */
  static final class IdentityAttributeConverter implements AttributeConverter<AttributeValue> {

    @Override
    public AttributeValue transformFrom(final AttributeValue input) {
      return input;
    }

    @Override
    public AttributeValue transformTo(final AttributeValue input) {
      return input;
    }

    @Override
    public EnhancedType<AttributeValue> type() {
      return EnhancedType.of(AttributeValue.class);
    }

    @Override
    public AttributeValueType attributeValueType() {
      // Informational for the enhanced client's metadata only; the real value type is carried by
      // the AttributeValue itself. See the class-level "Known limitation" note.
      return AttributeValueType.S;
    }
  }

  /**
   * Supplies the {@link IdentityAttributeConverter} for {@link AttributeValue} attributes. Every
   * attribute in a {@link AttributeMapItem} schema is an {@code AttributeValue}, so this is the only
   * conversion the schema needs.
   */
  static final class AttributeValueConverterProvider implements AttributeConverterProvider {

    private final IdentityAttributeConverter converter = new IdentityAttributeConverter();

    @Override
    @SuppressWarnings("unchecked")
    public <T> AttributeConverter<T> converterFor(final EnhancedType<T> enhancedType) {
      if (AttributeValue.class.equals(enhancedType.rawClass())) {
        return (AttributeConverter<T>) converter;
      }
      return null;
    }
  }
}
