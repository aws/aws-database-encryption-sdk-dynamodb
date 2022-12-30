package software.aws.cryptography.dynamoDbEncryption.enhancedclient;

import java.util.Map;
import java.util.Objects;

public class CreateDynamoDbEncryptionInterceptorWithTableSchemasInput {
    private final Map<String, DynamoDbEncryptionWithTableSchemaConfig> tableEncryptionConfigs;

    protected CreateDynamoDbEncryptionInterceptorWithTableSchemasInput(BuilderImpl builder) {
        this.tableEncryptionConfigs = builder.tableEncryptionConfigs();
    }

    public Map<String, DynamoDbEncryptionWithTableSchemaConfig> tableEncryptionConfigs() {
        return this.tableEncryptionConfigs;
    }

    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public interface Builder {
        Builder tableEncryptionConfigs(
                Map<String, DynamoDbEncryptionWithTableSchemaConfig> tableEncryptionConfigs);

        Map<String, DynamoDbEncryptionWithTableSchemaConfig> tableEncryptionConfigs();

        CreateDynamoDbEncryptionInterceptorWithTableSchemasInput build();
    }

    static class BuilderImpl implements Builder {
        protected Map<String, DynamoDbEncryptionWithTableSchemaConfig> tableEncryptionConfigs;

        protected BuilderImpl() {
        }

        protected BuilderImpl(CreateDynamoDbEncryptionInterceptorWithTableSchemasInput model) {
            this.tableEncryptionConfigs = model.tableEncryptionConfigs();
        }

        public Builder tableEncryptionConfigs(
                Map<String, DynamoDbEncryptionWithTableSchemaConfig> tableEncryptionConfigs) {
            this.tableEncryptionConfigs = tableEncryptionConfigs;
            return this;
        }

        public Map<String, DynamoDbEncryptionWithTableSchemaConfig> tableEncryptionConfigs() {
            return this.tableEncryptionConfigs;
        }

        public CreateDynamoDbEncryptionInterceptorWithTableSchemasInput build() {
            if (Objects.isNull(this.tableEncryptionConfigs())) {
                throw new IllegalArgumentException("Missing value for required field `tableEncryptionConfigs`");
            }
            return new CreateDynamoDbEncryptionInterceptorWithTableSchemasInput(this);
        }
    }
}