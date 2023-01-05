package software.amazon.cryptography.dynamoDbEncryption.model;

import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionFlags;

import java.util.Map;
import java.util.Set;

public class LegacyDynamoDbItemEncryptor {
    private final DynamoDBEncryptor encryptor;
    private final Map<String, Set<EncryptionFlags>> attributeFlags;
    private final Set<EncryptionFlags> defaultAttributeFlags;

    protected LegacyDynamoDbItemEncryptor(BuilderImpl builder) {
        this.encryptor = builder.encryptor();
        this.attributeFlags = builder.attributeFlags();
        this.defaultAttributeFlags = builder.defaultAttributeFlags();
    }

    public DynamoDBEncryptor encryptor() {
        return this.encryptor;
    }

    public Map<String, Set<EncryptionFlags>> attributeFlags() {
        return this.attributeFlags;
    }

    public Set<EncryptionFlags> defaultAttributeFlags() {
        return this.defaultAttributeFlags;
    }

    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public interface Builder {
        Builder encryptor(DynamoDBEncryptor encryptor);
        DynamoDBEncryptor encryptor();
        Builder attributeFlags(Map<String, Set<EncryptionFlags>> attributeFlags);
        Map<String, Set<EncryptionFlags>> attributeFlags();
        Builder defaultAttributeFlags(Set<EncryptionFlags> defaultAttributeFlags);
        Set<EncryptionFlags> defaultAttributeFlags();
        LegacyDynamoDbItemEncryptor build();
    }

    protected static class BuilderImpl implements Builder {
        protected DynamoDBEncryptor encryptor;
        protected Map<String, Set<EncryptionFlags>> attributeFlags;
        protected Set<EncryptionFlags> defaultAttributeFlags;

        protected BuilderImpl() {
        }

        protected BuilderImpl(LegacyDynamoDbItemEncryptor model) {
            this.encryptor = model.encryptor();
            this.attributeFlags = model.attributeFlags();
            this.defaultAttributeFlags = model.defaultAttributeFlags();
        }

        public Builder encryptor(DynamoDBEncryptor encryptor) {
            this.encryptor = encryptor;
            return this;
        }

        public DynamoDBEncryptor encryptor() {
            return this.encryptor;
        }

        public Builder attributeFlags(Map<String, Set<EncryptionFlags>> attributeFlags) {
            this.attributeFlags = attributeFlags;
            return this;
        }

        public Map<String, Set<EncryptionFlags>> attributeFlags() {
            return this.attributeFlags;
        }

        public Builder defaultAttributeFlags(Set<EncryptionFlags> defaultAttributeFlags) {
            this.defaultAttributeFlags = defaultAttributeFlags;
            return this;
        }

        public Set<EncryptionFlags> defaultAttributeFlags() {
            return this.defaultAttributeFlags;
        }

        public LegacyDynamoDbItemEncryptor build() {
            return new LegacyDynamoDbItemEncryptor(this);
        }
    }
}
