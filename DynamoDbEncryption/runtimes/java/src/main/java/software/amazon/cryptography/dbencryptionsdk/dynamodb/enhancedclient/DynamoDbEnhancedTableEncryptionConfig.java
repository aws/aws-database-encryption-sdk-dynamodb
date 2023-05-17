package software.aws.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import java.util.List;
import java.util.Objects;

import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PlaintextPolicy;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.cryptography.materialproviders.CryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.Keyring;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;

public class DynamoDbEnhancedTableEncryptionConfig {
    private final String logicalTableName;
    private final TableSchema tableSchema;
    private final List<String> allowedUnauthenticatedAttributes;
    private final String allowedUnauthenticatedAttributePrefix;
    private final Keyring keyring;
    private final CryptographicMaterialsManager cmm;
    private final LegacyConfig legacyConfig;
    private final PlaintextPolicy plaintextPolicy;
    private final DBEAlgorithmSuiteId algorithmSuiteId;


    protected DynamoDbEnhancedTableEncryptionConfig(BuilderImpl builder) {
        this.logicalTableName = builder.logicalTableName();
        this.tableSchema = builder.tableSchema();
        this.allowedUnauthenticatedAttributes = builder.allowedUnauthenticatedAttributes();
        this.allowedUnauthenticatedAttributePrefix = builder.allowedUnauthenticatedAttributePrefix();
        this.keyring = builder.keyring();
        this.cmm = builder.cmm();
        this.legacyConfig = builder.legacyConfig();
        this.plaintextPolicy = builder.plaintextPolicy();
        this.algorithmSuiteId = builder.algorithmSuiteId();

    }

    public String logicalTableName() { return this.logicalTableName; }

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

    public PlaintextPolicy plaintextPolicy() {
        return this.plaintextPolicy;
    }

    public DBEAlgorithmSuiteId algorithmSuiteId() {
        return this.algorithmSuiteId;
    }

    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public interface Builder {
        String logicalTableName();
        Builder logicalTableName(String logicalTableName);
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
        Builder plaintextPolicy(PlaintextPolicy plaintextPolicy);
        PlaintextPolicy plaintextPolicy();
        Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId);
        DBEAlgorithmSuiteId algorithmSuiteId();
        DynamoDbEnhancedTableEncryptionConfig build();
    }

    protected static class BuilderImpl implements Builder {
        protected String logicalTableName;
        protected TableSchema tableSchema;
        protected List<String> allowedUnauthenticatedAttributes;
        protected String allowedUnauthenticatedAttributePrefix;
        protected Keyring keyring;
        protected CryptographicMaterialsManager cmm;
        protected LegacyConfig legacyConfig;
        protected PlaintextPolicy plaintextPolicy;
        protected DBEAlgorithmSuiteId algorithmSuiteId;
        protected BuilderImpl() {
        }

        protected BuilderImpl(DynamoDbEnhancedTableEncryptionConfig model) {
            this.logicalTableName = model.logicalTableName();
            this.tableSchema = model.tableSchema();
            this.allowedUnauthenticatedAttributes = model.allowedUnauthenticatedAttributes();
            this.allowedUnauthenticatedAttributePrefix = model.allowedUnauthenticatedAttributePrefix();
            this.keyring = model.keyring();
            this.cmm = model.cmm();
            this.legacyConfig = model.legacyConfig();
            this.plaintextPolicy  = model.plaintextPolicy();
            this.algorithmSuiteId = model.algorithmSuiteId();
        }

        public Builder logicalTableName(String logicalTableName) {
            this.logicalTableName = logicalTableName;
            return this;
        }

        public String logicalTableName() { return this.logicalTableName; }

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
            this.keyring = Keyring.wrap(keyring);
            return this;
        }

        public Keyring keyring() {
            return this.keyring;
        }

        public <I extends ICryptographicMaterialsManager> Builder cmm(I cmm) {
            this.cmm = CryptographicMaterialsManager.wrap(cmm);
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

        public Builder plaintextPolicy(PlaintextPolicy plaintextPolicy) {
            this.plaintextPolicy = plaintextPolicy;
            return this;
        }

        public PlaintextPolicy plaintextPolicy() {
            return this.plaintextPolicy;
        }

        public Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId) {
            this.algorithmSuiteId = algorithmSuiteId;
            return this;
        }

        public DBEAlgorithmSuiteId algorithmSuiteId() {
            return this.algorithmSuiteId;
        }

        public DynamoDbEnhancedTableEncryptionConfig build() {
            if (Objects.isNull(this.tableSchema())) {
                throw new IllegalArgumentException("Missing value for required field `tableSchema`");
            }
            return new DynamoDbEnhancedTableEncryptionConfig(this);
        }
    }
}
