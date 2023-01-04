package software.amazon.cryptography.dynamoDbEncryption.model;

public class LegacyConfig {
    private final LegacyDynamoDbItemEncryptor legacyEncryptor;
    private final LegacyPolicy legacyPolicy;

    protected LegacyConfig(BuilderImpl builder) {
        this.legacyEncryptor = builder.legacyEncryptor();
        this.legacyPolicy = builder.legacyPolicy();
    }

    public LegacyDynamoDbItemEncryptor legacyEncryptor() {
        return this.legacyEncryptor;
    }

    public LegacyPolicy legacyPolicy() {
        return this.legacyPolicy;
    }

    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public interface Builder {
        Builder legacyEncryptor(LegacyDynamoDbItemEncryptor legacyEncryptor);
        LegacyDynamoDbItemEncryptor legacyEncryptor();
        Builder legacyPolicy(LegacyPolicy legacyPolicy);
        LegacyPolicy legacyPolicy();
        LegacyConfig build();
    }

    protected static class BuilderImpl implements Builder {
        protected LegacyDynamoDbItemEncryptor legacyEncryptor;
        protected LegacyPolicy legacyPolicy;

        protected BuilderImpl() {
        }

        protected BuilderImpl(LegacyConfig model) {
            this.legacyEncryptor = model.legacyEncryptor();
            this.legacyPolicy = model.legacyPolicy();
        }

        public Builder legacyEncryptor(LegacyDynamoDbItemEncryptor legacyEncryptor) {
            this.legacyEncryptor = legacyEncryptor;
            return this;
        }

        public LegacyDynamoDbItemEncryptor legacyEncryptor() {
            return this.legacyEncryptor;
        }

        public Builder legacyPolicy(LegacyPolicy legacyPolicy) {
            this.legacyPolicy = legacyPolicy;
            return this;
        }

        public LegacyPolicy legacyPolicy() {
            return this.legacyPolicy;
        }

        public LegacyConfig build() {
            return new LegacyConfig(this);
        }
    }
}
