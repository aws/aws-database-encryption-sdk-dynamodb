package software.aws.cryptography.dynamoDbEncryption.enhancedclient;

import java.util.List;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.cryptography.materialProviders.CryptographicMaterialsManager;
import software.amazon.cryptography.materialProviders.Keyring;

public class CreateDynamoDbEncryptionInterceptorWithTableSchemaInput {
    private final String tableName;
    private final TableSchema tableSchema;
    private final List<String> allowedUnauthenticatedAttributes;
    private final String allowedUnauthenticatedAttributePrefix;
    private final Keyring keyring;
    private final CryptographicMaterialsManager cmm;

    protected CreateDynamoDbEncryptionInterceptorWithTableSchemaInput(BuilderImpl builder) {
        this.tableName = builder.tableName();
        this.tableSchema = builder.tableSchema();
        this.allowedUnauthenticatedAttributes = builder.allowedUnauthenticatedAttributes();
        this.allowedUnauthenticatedAttributePrefix = builder.allowedUnauthenticatedAttributePrefix();
        this.keyring = builder.keyring();
        this.cmm = builder.cmm();
    }
    public String tableName() {
        return this.tableName;
    }

    public TableSchema tableSchema() {
        return this.tableSchema;
    }

    public List<String> allowedUnauthenticatedAttributes() {
        return this.allowedUnauthenticatedAttributes;
    }

    public String allowedUnauthenticatedAttributePrefix() {
        return this.allowedUnauthenticatedAttributePrefix;
    }

    public Keyring keyring() {
        return this.keyring;
    }

    public CryptographicMaterialsManager cmm() {
        return this.cmm;
    }

    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public interface Builder {
        Builder tableName(String tableName);
        String tableName();
        Builder tableSchema(TableSchema tableSchema);
        TableSchema tableSchema();
        Builder allowedUnauthenticatedAttributes(List<String> allowedUnauthenticatedAttributes);
        List<String> allowedUnauthenticatedAttributes();
        Builder allowedUnauthenticatedAttributePrefix(String allowedUnauthenticatedAttributePrefix);
        String allowedUnauthenticatedAttributePrefix();
        Builder keyring(Keyring keyring);
        Keyring keyring();
        CryptographicMaterialsManager cmm();
        CreateDynamoDbEncryptionInterceptorWithTableSchemaInput build();
    }

    protected static class BuilderImpl implements Builder {
        protected String tableName;
        protected TableSchema tableSchema;
        protected List<String> allowedUnauthenticatedAttributes;
        protected String allowedUnauthenticatedAttributePrefix;
        protected Keyring keyring;
        protected CryptographicMaterialsManager cmm;
        protected BuilderImpl() {
        }

        protected BuilderImpl(CreateDynamoDbEncryptionInterceptorWithTableSchemaInput model) {
            this.tableName = model.tableName();
            this.tableSchema = model.tableSchema();
            this.allowedUnauthenticatedAttributes = model.allowedUnauthenticatedAttributes();
            this.allowedUnauthenticatedAttributePrefix = model.allowedUnauthenticatedAttributePrefix();
            this.keyring = model.keyring();
            this.cmm = model.cmm();
        }

        public Builder tableName(
                String tableName) {
            this.tableName = tableName;
            return this;
        }

        public String tableName() {
            return this.tableName;
        }

        public Builder tableSchema(TableSchema tableSchema) {
            this.tableSchema = tableSchema;
            return this;
        }

        public TableSchema tableSchema() {
            return this.tableSchema;
        }

        public Builder allowedUnauthenticatedAttributes(List<String> allowedUnauthenticatedAttributes) {
            this.allowedUnauthenticatedAttributes = allowedUnauthenticatedAttributes;
            return this;
        }

        public List<String> allowedUnauthenticatedAttributes() {
            return this.allowedUnauthenticatedAttributes;
        }

        public Builder allowedUnauthenticatedAttributePrefix(
                String allowedUnauthenticatedAttributePrefix) {
            this.allowedUnauthenticatedAttributePrefix = allowedUnauthenticatedAttributePrefix;
            return this;
        }

        public String allowedUnauthenticatedAttributePrefix() {
            return this.allowedUnauthenticatedAttributePrefix;
        }

        public Builder keyring(Keyring keyring) {
            this.keyring = keyring;
            return this;
        }

        public Keyring keyring() {
            return this.keyring;
        }

        public Builder cmm(CryptographicMaterialsManager cmm) {
            this.cmm = cmm;
            return this;
        }

        public CryptographicMaterialsManager cmm() {
            return this.cmm;
        }

        public CreateDynamoDbEncryptionInterceptorWithTableSchemaInput build() {
            return new CreateDynamoDbEncryptionInterceptorWithTableSchemaInput(this);
        }
    }
}
