// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;

/**
 * Enhanced Client integration: build encryption config from annotated bean classes.
 *
 * <p>Usage:
 * <pre>
 * {@literal @}DynamoDbBean
 * public class MyItem {
 *     {@literal @}DynamoDbPartitionKey
 *     public String getPk() { ... }
 *
 *     {@literal @}DynamoDbEncryptionSignOnly
 *     public String getStatus() { ... }
 *
 *     {@literal @}DynamoDbEncryptionEncryptAndSign
 *     public String getSecret() { ... }
 *
 *     {@literal @}DynamoDbEncryptionDoNothing
 *     public String getMeta() { ... }
 * }
 *
 * DynamoDbItemEncryptorConfig config = DynamoDbEnhancedClientEncryption
 *     .configFromAnnotatedClass(MyItem.class, "MyTable", "pk", null, cmm);
 * </pre>
 */
public final class DynamoDbEnhancedClientEncryption {

    /** Mark a getter as ENCRYPT_AND_SIGN. */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface DynamoDbEncryptionEncryptAndSign {}

    /** Mark a getter as SIGN_ONLY. */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface DynamoDbEncryptionSignOnly {}

    /** Mark a getter as SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT. */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface DynamoDbEncryptionSignAndIncludeInEncryptionContext {}

    /** Mark a getter as DO_NOTHING. */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface DynamoDbEncryptionDoNothing {}

    private DynamoDbEnhancedClientEncryption() {}

    /**
     * Build a DynamoDbItemEncryptorConfig from an annotated bean class.
     * Scans getter methods for encryption annotations.
     * Unannotated fields default to ENCRYPT_AND_SIGN.
     */
    public static DynamoDbItemEncryptorConfig configFromAnnotatedClass(
            Class<?> beanClass,
            String logicalTableName,
            String partitionKeyName,
            String sortKeyName,
            ICryptographicMaterialsManager cmm) {

        Map<String, CryptoAction> actions = new LinkedHashMap<>();

        for (Method method : beanClass.getMethods()) {
            if (!isGetter(method)) continue;
            String attrName = getterToAttributeName(method);

            CryptoAction action;
            if (method.isAnnotationPresent(DynamoDbEncryptionEncryptAndSign.class)) {
                action = CryptoAction.ENCRYPT_AND_SIGN;
            } else if (method.isAnnotationPresent(DynamoDbEncryptionSignOnly.class)) {
                action = CryptoAction.SIGN_ONLY;
            } else if (method.isAnnotationPresent(DynamoDbEncryptionSignAndIncludeInEncryptionContext.class)) {
                action = CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT;
            } else if (method.isAnnotationPresent(DynamoDbEncryptionDoNothing.class)) {
                action = CryptoAction.DO_NOTHING;
            } else {
                action = CryptoAction.ENCRYPT_AND_SIGN; // default
            }

            actions.put(attrName, action);
        }

        // Ensure partition key has correct action
        if (!actions.containsKey(partitionKeyName)) {
            boolean hasContextAction = actions.values().contains(CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT);
            actions.put(partitionKeyName, hasContextAction
                ? CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT
                : CryptoAction.SIGN_ONLY);
        }
        if (sortKeyName != null && !actions.containsKey(sortKeyName)) {
            boolean hasContextAction = actions.values().contains(CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT);
            actions.put(sortKeyName, hasContextAction
                ? CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT
                : CryptoAction.SIGN_ONLY);
        }

        return DynamoDbItemEncryptorConfig.builder()
            .logicalTableName(logicalTableName)
            .partitionKeyName(partitionKeyName)
            .sortKeyName(sortKeyName)
            .attributeActionsOnEncrypt(actions)
            .cmm(cmm)
            .build();
    }

    private static boolean isGetter(Method m) {
        return m.getName().startsWith("get")
            && m.getName().length() > 3
            && m.getParameterCount() == 0
            && m.getReturnType() != void.class
            && !m.getDeclaringClass().equals(Object.class);
    }

    private static String getterToAttributeName(Method m) {
        String name = m.getName().substring(3);
        return Character.toLowerCase(name.charAt(0)) + name.substring(1);
    }
}
