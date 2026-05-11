package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.BeanTableSchemaAttributeTag;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@BeanTableSchemaAttributeTag(EncryptionAttributeTags.class)
public @interface DynamoDbEncryptionSignAndIncludeInEncryptionContext {
}
