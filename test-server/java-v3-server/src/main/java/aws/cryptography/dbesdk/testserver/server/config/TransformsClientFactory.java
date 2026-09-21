package aws.cryptography.dbesdk.testserver.server.config;

import aws.cryptography.dbesdk.testserver.server.model.DBEClientConfig;
import aws.cryptography.dbesdk.testserver.server.registry.RealTransformsClient;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.AsSet;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconKeySource;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconStyle;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconVersion;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CompoundBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Constructor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.ConstructorPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.EncryptedPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetPrefix;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSegment;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSegments;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSubstring;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetSuffix;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Insert;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Lower;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PartOnly;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SearchConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Shared;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SharedSet;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SignedPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SingleKeyStore;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.StandardBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Upper;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualField;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualTransform;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.DynamoDbEncryptionTransforms;
import software.amazon.cryptography.keystore.KeyStore;
import software.amazon.cryptography.keystore.model.KMSConfiguration;
import software.amazon.cryptography.keystore.model.KeyStoreConfig;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;

/**
 * Translates a validated {@link DBEClientConfig} plus a physical table name
 * into a {@link RealTransformsClient} backed by a real
 * {@link DynamoDbEncryptionTransforms}. The transforms client is built from a
 * {@link DynamoDbTablesEncryptionConfig} with a single entry keyed by the
 * physical table name, whose per-table crypto config carries the same fields as
 * the item encryptor's config.
 *
 * <p>The keyring / CMM and Crypto Action mapping are reused verbatim from
 * {@link ItemEncryptorFactory}, so a transforms client and an item encryptor
 * built from the same {@code DBEClientConfig} share identical materials. Only
 * the target config type differs ({@code DynamoDbTableEncryptionConfig} rather
 * than {@code DynamoDbItemEncryptorConfig}), which is why the scalar fields are
 * copied here rather than shared.
 */
public final class TransformsClientFactory {

  private final ItemEncryptorFactory materials;

  public TransformsClientFactory(ItemEncryptorFactory materials) {
    this.materials = materials;
  }

  /**
   * Build a transforms client bound to one or more tables. The
   * {@code tables} map is (physical table name → its crypto config); each
   * entry becomes an independent {@link DynamoDbTableEncryptionConfig} in the
   * {@link DynamoDbTablesEncryptionConfig}, so per-table settings (notably
   * {@code algorithmSuiteId}) do not leak across tables.
   *
   * @throws RuntimeException if a real client cannot be constructed; the caller
   *     maps this to a {@code GenericServerError}.
   */
  public TransformsClient create(Map<String, DBEClientConfig> tables) {
    Map<String, DynamoDbTableEncryptionConfig> tableConfigs =
      new LinkedHashMap<>();
    for (Map.Entry<String, DBEClientConfig> entry : tables.entrySet()) {
      tableConfigs.put(entry.getKey(), buildTableConfig(entry.getValue()));
    }

    DynamoDbTablesEncryptionConfig tablesConfig = DynamoDbTablesEncryptionConfig
      .builder()
      .tableEncryptionConfigs(tableConfigs)
      .build();

    DynamoDbEncryptionTransforms transforms = DynamoDbEncryptionTransforms
      .builder()
      .DynamoDbTablesEncryptionConfig(tablesConfig)
      .build();
    return new RealTransformsClient(transforms);
  }

  /** Build one table's {@link DynamoDbTableEncryptionConfig} from its config. */
  private DynamoDbTableEncryptionConfig buildTableConfig(
    DBEClientConfig config
  ) {
    DynamoDbTableEncryptionConfig.Builder table = DynamoDbTableEncryptionConfig
      .builder()
      .logicalTableName(config.getLogicalTableName())
      .partitionKeyName(config.getPartitionKeyName())
      .attributeActionsOnEncrypt(
        ItemEncryptorFactory.toCryptoActions(
          config.getAttributeActionsOnEncrypt()
        )
      );

    if (config.getSortKeyName() != null) {
      table.sortKeyName(config.getSortKeyName());
    }
    if (config.getAllowedUnsignedAttributePrefix() != null) {
      table.allowedUnsignedAttributePrefix(
        config.getAllowedUnsignedAttributePrefix()
      );
    }
    if (
      config.hasAllowedUnsignedAttributes() &&
      !config.getAllowedUnsignedAttributes().isEmpty()
    ) {
      table.allowedUnsignedAttributes(
        new ArrayList<>(config.getAllowedUnsignedAttributes())
      );
    }
    if (config.getAlgorithmSuiteId() != null) {
      table.algorithmSuiteId(
        DBEAlgorithmSuiteId.valueOf(config.getAlgorithmSuiteId().getValue())
      );
    }

    // Exactly one of keyring / cmm is set (validated upstream), reusing the
    // item encryptor's recursive materials construction.
    if (config.getKeyring() != null) {
      table.keyring(materials.buildKeyring(config.getKeyring()));
    } else {
      table.cmm(materials.buildCmm(config.getCmm()));
    }

    if (config.getSearch() != null) {
      table.search(buildSearchConfig(config.getSearch()));
    }

    return table.build();
  }

  /**
   * Build a DBE {@link SearchConfig} (beacons) from the modeled config. The
   * beacon key store's DynamoDB and KMS clients are derived from the KMS key
   * ARN's region (no explicit clients), so the key store reaches
   * {@code KeyStoreDdbTable} with the ambient credentials.
   */
  private static SearchConfig buildSearchConfig(
    aws.cryptography.dbesdk.testserver.server.model.SearchConfig search
  ) {
    List<BeaconVersion> versions = new ArrayList<>();
    for (aws.cryptography.dbesdk.testserver.server.model.BeaconVersion v : search.getVersions()) {
      aws.cryptography.dbesdk.testserver.server.model.BeaconKeyStore ks =
        v.getKeyStore();
      KeyStore keyStore = KeyStore
        .builder()
        .KeyStoreConfig(
          KeyStoreConfig
            .builder()
            .ddbTableName(ks.getDdbTableName())
            .logicalKeyStoreName(ks.getLogicalKeyStoreName())
            .kmsConfiguration(
              KMSConfiguration.builder().kmsKeyArn(ks.getKmsKeyArn()).build()
            )
            .build()
        )
        .build();

      aws.cryptography.dbesdk.testserver.server.model.SingleKeyStore single = v
        .getKeySource()
        .getSingle();
      if (single == null) {
        throw new IllegalArgumentException(
          "BeaconKeySource requires a single key store"
        );
      }
      BeaconKeySource keySource = BeaconKeySource
        .builder()
        .single(
          SingleKeyStore
            .builder()
            .keyId(single.getKeyId())
            .cacheTTL(single.getCacheTtlSeconds())
            .build()
        )
        .build();

      BeaconVersion.Builder bv = BeaconVersion
        .builder()
        .version(v.getVersion())
        .keyStore(keyStore)
        .keySource(keySource);
      if (v.getStandardBeacons() != null && !v.getStandardBeacons().isEmpty()) {
        List<StandardBeacon> beacons = new ArrayList<>();
        for (aws.cryptography.dbesdk.testserver.server.model.StandardBeacon b : v.getStandardBeacons()) {
          StandardBeacon.Builder sb = StandardBeacon
            .builder()
            .name(b.getName())
            .length(b.getLength());
          if (b.getLoc() != null) {
            sb.loc(b.getLoc());
          }
          if (b.getStyle() != null) {
            sb.style(mapBeaconStyle(b.getStyle()));
          }
          beacons.add(sb.build());
        }
        bv.standardBeacons(beacons);
      }
      if (v.getVirtualFields() != null && !v.getVirtualFields().isEmpty()) {
        bv.virtualFields(mapVirtualFields(v.getVirtualFields()));
      }
      if (v.getEncryptedParts() != null && !v.getEncryptedParts().isEmpty()) {
        bv.encryptedParts(mapEncryptedParts(v.getEncryptedParts()));
      }
      if (v.getSignedParts() != null && !v.getSignedParts().isEmpty()) {
        bv.signedParts(mapSignedParts(v.getSignedParts()));
      }
      if (v.getCompoundBeacons() != null && !v.getCompoundBeacons().isEmpty()) {
        bv.compoundBeacons(mapCompoundBeacons(v.getCompoundBeacons()));
      }
      versions.add(bv.build());
    }
    return SearchConfig
      .builder()
      .versions(versions)
      .writeVersion(
        search.getWriteVersion() != null ? search.getWriteVersion() : 1
      )
      .build();
  }

  private static BeaconStyle mapBeaconStyle(
    aws.cryptography.dbesdk.testserver.server.model.BeaconStyle wire
  ) {
    if (wire.getPartOnly() != null) {
      return BeaconStyle.builder().partOnly(PartOnly.builder().build()).build();
    } else if (wire.getAsSet() != null) {
      return BeaconStyle.builder().asSet(AsSet.builder().build()).build();
    } else if (wire.getShared() != null) {
      return BeaconStyle
        .builder()
        .shared(Shared.builder().other(wire.getShared().getOther()).build())
        .build();
    } else if (wire.getSharedSet() != null) {
      return BeaconStyle
        .builder()
        .sharedSet(
          SharedSet.builder().other(wire.getSharedSet().getOther()).build()
        )
        .build();
    }
    throw new IllegalArgumentException("BeaconStyle had no member set");
  }

  private static List<VirtualField> mapVirtualFields(
    List<aws.cryptography.dbesdk.testserver.server.model.VirtualField> wire
  ) {
    List<VirtualField> out = new ArrayList<>();
    for (aws.cryptography.dbesdk.testserver.server.model.VirtualField f : wire) {
      List<VirtualPart> parts = new ArrayList<>();
      for (aws.cryptography.dbesdk.testserver.server.model.VirtualPart p : f.getParts()) {
        VirtualPart.Builder pb = VirtualPart.builder().loc(p.getLoc());
        if (p.getTrans() != null && !p.getTrans().isEmpty()) {
          pb.trans(mapVirtualTransforms(p.getTrans()));
        }
        parts.add(pb.build());
      }
      out.add(VirtualField.builder().name(f.getName()).parts(parts).build());
    }
    return out;
  }

  private static List<VirtualTransform> mapVirtualTransforms(
    List<aws.cryptography.dbesdk.testserver.server.model.VirtualTransform> wire
  ) {
    List<VirtualTransform> out = new ArrayList<>();
    for (aws.cryptography.dbesdk.testserver.server.model.VirtualTransform t : wire) {
      if (t.getUpper() != null) {
        out.add(
          VirtualTransform.builder().upper(Upper.builder().build()).build()
        );
      } else if (t.getLower() != null) {
        out.add(
          VirtualTransform.builder().lower(Lower.builder().build()).build()
        );
      } else if (t.getInsert() != null) {
        out.add(
          VirtualTransform
            .builder()
            .insert(
              Insert.builder().literal(t.getInsert().getLiteral()).build()
            )
            .build()
        );
      } else if (t.getPrefix() != null) {
        out.add(
          VirtualTransform
            .builder()
            .prefix(
              GetPrefix.builder().length(t.getPrefix().getLength()).build()
            )
            .build()
        );
      } else if (t.getSuffix() != null) {
        out.add(
          VirtualTransform
            .builder()
            .suffix(
              GetSuffix.builder().length(t.getSuffix().getLength()).build()
            )
            .build()
        );
      } else if (t.getSubstring() != null) {
        out.add(
          VirtualTransform
            .builder()
            .substring(
              GetSubstring
                .builder()
                .low(t.getSubstring().getLow())
                .high(t.getSubstring().getHigh())
                .build()
            )
            .build()
        );
      } else if (t.getSegment() != null) {
        out.add(
          VirtualTransform
            .builder()
            .segment(
              GetSegment
                .builder()
                .split(t.getSegment().getSplit())
                .index(t.getSegment().getIndex())
                .build()
            )
            .build()
        );
      } else if (t.getSegments() != null) {
        out.add(
          VirtualTransform
            .builder()
            .segments(
              GetSegments
                .builder()
                .split(t.getSegments().getSplit())
                .low(t.getSegments().getLow())
                .high(t.getSegments().getHigh())
                .build()
            )
            .build()
        );
      } else {
        throw new IllegalArgumentException(
          "VirtualTransform had no member set"
        );
      }
    }
    return out;
  }

  private static List<EncryptedPart> mapEncryptedParts(
    List<aws.cryptography.dbesdk.testserver.server.model.EncryptedPart> wire
  ) {
    List<EncryptedPart> out = new ArrayList<>();
    for (aws.cryptography.dbesdk.testserver.server.model.EncryptedPart p : wire) {
      out.add(
        EncryptedPart.builder().name(p.getName()).prefix(p.getPrefix()).build()
      );
    }
    return out;
  }

  private static List<SignedPart> mapSignedParts(
    List<aws.cryptography.dbesdk.testserver.server.model.SignedPart> wire
  ) {
    List<SignedPart> out = new ArrayList<>();
    for (aws.cryptography.dbesdk.testserver.server.model.SignedPart p : wire) {
      SignedPart.Builder sp = SignedPart
        .builder()
        .name(p.getName())
        .prefix(p.getPrefix());
      if (p.getLoc() != null) {
        sp.loc(p.getLoc());
      }
      out.add(sp.build());
    }
    return out;
  }

  private static List<CompoundBeacon> mapCompoundBeacons(
    List<aws.cryptography.dbesdk.testserver.server.model.CompoundBeacon> wire
  ) {
    List<CompoundBeacon> out = new ArrayList<>();
    for (aws.cryptography.dbesdk.testserver.server.model.CompoundBeacon c : wire) {
      CompoundBeacon.Builder cb = CompoundBeacon
        .builder()
        .name(c.getName())
        .split(c.getSplit());
      if (c.getEncrypted() != null && !c.getEncrypted().isEmpty()) {
        cb.encrypted(mapEncryptedParts(c.getEncrypted()));
      }
      if (c.getSigned() != null && !c.getSigned().isEmpty()) {
        cb.signed(mapSignedParts(c.getSigned()));
      }
      if (c.getConstructors() != null && !c.getConstructors().isEmpty()) {
        List<Constructor> constructors = new ArrayList<>();
        for (aws.cryptography.dbesdk.testserver.server.model.Constructor ctor : c.getConstructors()) {
          List<ConstructorPart> parts = new ArrayList<>();
          for (aws.cryptography.dbesdk.testserver.server.model.ConstructorPart part : ctor.getParts()) {
            parts.add(
              ConstructorPart
                .builder()
                .name(part.getName())
                .required(part.isRequired())
                .build()
            );
          }
          constructors.add(Constructor.builder().parts(parts).build());
        }
        cb.constructors(constructors);
      }
      out.add(cb.build());
    }
    return out;
  }
}
