package software.aws.cryptography.dynamoDbEncryption.enhancedclient;

import java.util.List;
import java.util.Objects;

import software.amazon.cryptography.dynamoDbEncryption.model.LegacyConfig;
import software.amazon.cryptography.materialProviders.IKeyring;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.cryptography.materialProviders.CryptographicMaterialsManager;
import software.amazon.cryptography.materialProviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialProviders.Keyring;

public class DynamoDbEnhancedTableEncryptionConfig {
    private final TableSchema tableSchema;
    private final List<String> allowedUnauthenticatedAttributes;
    private final String allowedUnauthenticatedAttributePrefix;
    private final Keyring keyring;
    private final CryptographicMaterialsManager cmm;
    private final LegacyConfig legacyConfig;


    protected DynamoDbEnhancedTableEncryptionConfig(BuilderImpl builder) {
        this.tableSchema = builder.tableSchema();
        this.allowedUnauthenticatedAttributes = builder.allowedUnauthenticatedAttributes();
        this.allowedUnauthenticatedAttributePrefix = builder.allowedUnauthenticatedAttributePrefix();
        this.keyring = builder.keyring();
        this.cmm = builder.cmm();
        this.legacyConfig = builder.legacyConfig();

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

    public LegacyConfig legacyConfig() {
        return this.legacyConfig;
    }

    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public interface Builder {
        Builder tableSchema(TableSchema tableSchema);
        TableSchema tableSchema();
        Builder allowedUnauthenticatedAttributes(List<String> allowedUnauthenticatedAttributes);
        List<String> allowedUnauthenticatedAttributes();
        Builder allowedUnauthenticatedAttributePrefix(String allowedUnauthenticatedAttributePrefix);
        String allowedUnauthenticatedAttributePrefix();
        <I extends IKeyring> Builder keyring(I keyring);
        <I extends ICryptographicMaterialsManager> Builder cmm(I cmm);
        Builder legacyConfig(LegacyConfig legacyConfig);
        LegacyConfig legacyConfig();
        DynamoDbEnhancedTableEncryptionConfig build();
    }

    protected static class BuilderImpl implements Builder {
        protected TableSchema tableSchema;
        protected List<String> allowedUnauthenticatedAttributes;
        protected String allowedUnauthenticatedAttributePrefix;
        protected Keyring keyring;
        protected CryptographicMaterialsManager cmm;
        protected LegacyConfig legacyConfig;
        protected BuilderImpl() {
        }

        protected BuilderImpl(DynamoDbEnhancedTableEncryptionConfig model) {
            this.tableSchema = model.tableSchema();
            this.allowedUnauthenticatedAttributes = model.allowedUnauthenticatedAttributes();
            this.allowedUnauthenticatedAttributePrefix = model.allowedUnauthenticatedAttributePrefix();
            this.keyring = model.keyring();
            this.cmm = model.cmm();
            this.legacyConfig = model.legacyConfig();
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

        public <I extends IKeyring> Builder keyring(I keyring) {
            this.keyring = Keyring.create(keyring);
            return this;
        }

        public Keyring keyring() {
            return this.keyring;
        }

        public <I extends ICryptographicMaterialsManager> Builder cmm(I cmm) {
            this.cmm = CryptographicMaterialsManager.create(cmm);
            return this;
        }

        public CryptographicMaterialsManager cmm() {
            return this.cmm;
        }

        public Builder legacyConfig(LegacyConfig legacyConfig) {
            this.legacyConfig = legacyConfig;
            return this;
        }

        public LegacyConfig legacyConfig() {
            return this.legacyConfig;
        }

        public DynamoDbEnhancedTableEncryptionConfig build() {
            if (Objects.isNull(this.tableSchema())) {
                throw new IllegalArgumentException("Missing value for required field `tableSchema`");
            }
            return new DynamoDbEnhancedTableEncryptionConfig(this);
        }
    }
}
