package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyOverride;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PlaintextOverride;
import software.amazon.cryptography.materialproviders.CryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.Keyring;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;

public class DynamoDbEnhancedTableEncryptionConfig {

  private final String logicalTableName;
  private final List<TableSchema<?>> schemaOnEncrypt;
  private final List<String> allowedUnsignedAttributes;
  private final String allowedUnsignedAttributePrefix;
  private final Keyring keyring;
  private final CryptographicMaterialsManager cmm;
  private final LegacyOverride legacyOverride;
  private final PlaintextOverride plaintextOverride;
  private final DBEAlgorithmSuiteId algorithmSuiteId;

  protected DynamoDbEnhancedTableEncryptionConfig(BuilderImpl builder) {
    this.logicalTableName = builder.logicalTableName();
    this.schemaOnEncrypt = builder.schemaOnEncrypt();
    this.allowedUnsignedAttributes = builder.allowedUnsignedAttributes();
    this.allowedUnsignedAttributePrefix =
      builder.allowedUnsignedAttributePrefix();
    this.keyring = builder.keyring();
    this.cmm = builder.cmm();
    this.legacyOverride = builder.legacyOverride();
    this.plaintextOverride = builder.plaintextOverride();
    this.algorithmSuiteId = builder.algorithmSuiteId();
  }

  public String logicalTableName() {
    return this.logicalTableName;
  }

  public List<TableSchema<?>> schemaOnEncrypt() {
    return this.schemaOnEncrypt;
  }

  public List<String> allowedUnsignedAttributes() {
    return this.allowedUnsignedAttributes;
  }

  public String allowedUnsignedAttributePrefix() {
    return this.allowedUnsignedAttributePrefix;
  }

  public Keyring keyring() {
    return this.keyring;
  }

  public CryptographicMaterialsManager cmm() {
    return this.cmm;
  }

  public LegacyOverride legacyOverride() {
    return this.legacyOverride;
  }

  public PlaintextOverride plaintextOverride() {
    return this.plaintextOverride;
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
    Builder schemaOnEncrypt(TableSchema<?> schemaOnEncrypt);
    List<TableSchema<?>> schemaOnEncrypt();
    Builder allowedUnsignedAttributes(List<String> allowedUnsignedAttributes);
    List<String> allowedUnsignedAttributes();
    Builder allowedUnsignedAttributePrefix(
      String allowedUnsignedAttributePrefix
    );
    String allowedUnsignedAttributePrefix();
    <I extends IKeyring> Builder keyring(I keyring);
    <I extends ICryptographicMaterialsManager> Builder cmm(I cmm);
    Builder legacyOverride(LegacyOverride legacyOverride);
    LegacyOverride legacyOverride();
    Builder plaintextOverride(PlaintextOverride plaintextOverride);
    PlaintextOverride plaintextOverride();
    Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId);
    DBEAlgorithmSuiteId algorithmSuiteId();
    DynamoDbEnhancedTableEncryptionConfig build();
  }

  protected static class BuilderImpl implements Builder {

    protected String logicalTableName;
    protected List<TableSchema<?>> schemaOnEncrypt;
    protected List<String> allowedUnsignedAttributes;
    protected String allowedUnsignedAttributePrefix;
    protected Keyring keyring;
    protected CryptographicMaterialsManager cmm;
    protected LegacyOverride legacyOverride;
    protected PlaintextOverride plaintextOverride;
    protected DBEAlgorithmSuiteId algorithmSuiteId;

    protected BuilderImpl() {}

    protected BuilderImpl(DynamoDbEnhancedTableEncryptionConfig model) {
      this.logicalTableName = model.logicalTableName();
      this.schemaOnEncrypt = model.schemaOnEncrypt();
      this.allowedUnsignedAttributes = model.allowedUnsignedAttributes();
      this.allowedUnsignedAttributePrefix =
        model.allowedUnsignedAttributePrefix();
      this.keyring = model.keyring();
      this.cmm = model.cmm();
      this.legacyOverride = model.legacyOverride();
      this.plaintextOverride = model.plaintextOverride();
      this.algorithmSuiteId = model.algorithmSuiteId();
    }

    public Builder logicalTableName(String logicalTableName) {
      this.logicalTableName = logicalTableName;
      return this;
    }

    public String logicalTableName() {
      return this.logicalTableName;
    }

    public Builder schemaOnEncrypt(TableSchema<?> schemaOnEncrypt) {
      if (Objects.isNull(this.schemaOnEncrypt())) {
        this.schemaOnEncrypt = new ArrayList();
      }
      this.schemaOnEncrypt.add(schemaOnEncrypt);
      return this;
    }

    public List<TableSchema<?>> schemaOnEncrypt() {
      return this.schemaOnEncrypt;
    }

    public Builder allowedUnsignedAttributes(
      List<String> allowedUnsignedAttributes
    ) {
      this.allowedUnsignedAttributes = allowedUnsignedAttributes;
      return this;
    }

    public List<String> allowedUnsignedAttributes() {
      return this.allowedUnsignedAttributes;
    }

    public Builder allowedUnsignedAttributePrefix(
      String allowedUnsignedAttributePrefix
    ) {
      this.allowedUnsignedAttributePrefix = allowedUnsignedAttributePrefix;
      return this;
    }

    public String allowedUnsignedAttributePrefix() {
      return this.allowedUnsignedAttributePrefix;
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

    public Builder legacyOverride(LegacyOverride legacyOverride) {
      this.legacyOverride = legacyOverride;
      return this;
    }

    public LegacyOverride legacyOverride() {
      return this.legacyOverride;
    }

    public Builder plaintextOverride(PlaintextOverride plaintextOverride) {
      this.plaintextOverride = plaintextOverride;
      return this;
    }

    public PlaintextOverride plaintextOverride() {
      return this.plaintextOverride;
    }

    public Builder algorithmSuiteId(DBEAlgorithmSuiteId algorithmSuiteId) {
      this.algorithmSuiteId = algorithmSuiteId;
      return this;
    }

    public DBEAlgorithmSuiteId algorithmSuiteId() {
      return this.algorithmSuiteId;
    }

    public DynamoDbEnhancedTableEncryptionConfig build() {
      if (Objects.isNull(this.schemaOnEncrypt())) {
        throw new IllegalArgumentException(
          "Missing value for required field `schemaOnEncrypt`"
        );
      }
      return new DynamoDbEnhancedTableEncryptionConfig(this);
    }
  }
}
