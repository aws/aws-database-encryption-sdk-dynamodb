package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import software.amazon.awssdk.enhanced.dynamodb.mapper.StaticAttributeTag;

public final class EncryptionAttributeTags {

  private EncryptionAttributeTags() {}

  public static StaticAttributeTag attributeTagFor(
    DynamoDbEncryptionSignOnly annotation
  ) {
    return new SignOnlyTag();
  }

  public static StaticAttributeTag attributeTagFor(
    DynamoDbEncryptionSignAndIncludeInEncryptionContext annotation
  ) {
    return new SignAndIncludeInEncryptionContextTag();
  }

  public static StaticAttributeTag attributeTagFor(
    DynamoDbEncryptionDoNothing annotation
  ) {
    return new DoNothingTag();
  }
}
