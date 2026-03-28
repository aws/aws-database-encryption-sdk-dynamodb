/*
 * Copyright 2014-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package software.amazon.cryptools.dynamodbencryptionclientsdk2.interceptor;

import java.util.Map;
import java.util.Set;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionFlags;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.EncryptionMaterialsProvider;

/**
 * Configuration for DDBECInterceptor.
 */
public class DDBECInterceptorConfig {

    private final String tableName;
    private final String partitionKeyName;
    private final String sortKeyName;
    private final EncryptionMaterialsProvider materialProvider;
    private final Map<String, Set<EncryptionFlags>> attributeFlags;

    private DDBECInterceptorConfig(Builder builder) {
        this.tableName = builder.tableName;
        this.partitionKeyName = builder.partitionKeyName;
        this.sortKeyName = builder.sortKeyName;
        this.materialProvider = builder.materialProvider;
        this.attributeFlags = builder.attributeFlags;
    }

    public String tableName() {
        return tableName;
    }

    public String partitionKeyName() {
        return partitionKeyName;
    }

    public String sortKeyName() {
        return sortKeyName;
    }

    public EncryptionMaterialsProvider materialProvider() {
        return materialProvider;
    }

    public Map<String, Set<EncryptionFlags>> attributeFlags() {
        return attributeFlags;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String tableName;
        private String partitionKeyName;
        private String sortKeyName;
        private EncryptionMaterialsProvider materialProvider;
        private Map<String, Set<EncryptionFlags>> attributeFlags;

        public Builder tableName(String tableName) {
            this.tableName = tableName;
            return this;
        }

        public Builder partitionKeyName(String partitionKeyName) {
            this.partitionKeyName = partitionKeyName;
            return this;
        }

        public Builder sortKeyName(String sortKeyName) {
            this.sortKeyName = sortKeyName;
            return this;
        }

        public Builder materialProvider(EncryptionMaterialsProvider materialProvider) {
            this.materialProvider = materialProvider;
            return this;
        }

        public Builder attributeFlags(Map<String, Set<EncryptionFlags>> attributeFlags) {
            this.attributeFlags = attributeFlags;
            return this;
        }

        public DDBECInterceptorConfig build() {
            if (tableName == null || tableName.isEmpty()) {
                throw new IllegalArgumentException("tableName is required");
            }
            if (partitionKeyName == null || partitionKeyName.isEmpty()) {
                throw new IllegalArgumentException("partitionKeyName is required");
            }
            if (materialProvider == null) {
                throw new IllegalArgumentException("materialProvider is required");
            }
            if (attributeFlags == null || attributeFlags.isEmpty()) {
                throw new IllegalArgumentException("attributeFlags is required");
            }
            
            return new DDBECInterceptorConfig(this);
        }
    }
}
