package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import java.util.Map;
import java.util.Objects;

public class CreateDynamoDbEncryptionInterceptorInput {

  private final Map<
    String,
    DynamoDbEnhancedTableEncryptionConfig
  > tableEncryptionConfigs;

  protected CreateDynamoDbEncryptionInterceptorInput(BuilderImpl builder) {
    this.tableEncryptionConfigs = builder.tableEncryptionConfigs();
  }

  public Map<
    String,
    DynamoDbEnhancedTableEncryptionConfig
  > tableEncryptionConfigs() {
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
      Map<String, DynamoDbEnhancedTableEncryptionConfig> tableEncryptionConfigs
    );

    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableEncryptionConfigs();

    CreateDynamoDbEncryptionInterceptorInput build();
  }

  static class BuilderImpl implements Builder {

    protected Map<
      String,
      DynamoDbEnhancedTableEncryptionConfig
    > tableEncryptionConfigs;

    protected BuilderImpl() {}

    protected BuilderImpl(CreateDynamoDbEncryptionInterceptorInput model) {
      this.tableEncryptionConfigs = model.tableEncryptionConfigs();
    }

    public Builder tableEncryptionConfigs(
      Map<String, DynamoDbEnhancedTableEncryptionConfig> tableEncryptionConfigs
    ) {
      this.tableEncryptionConfigs = tableEncryptionConfigs;
      return this;
    }

    public Map<
      String,
      DynamoDbEnhancedTableEncryptionConfig
    > tableEncryptionConfigs() {
      return this.tableEncryptionConfigs;
    }

    public CreateDynamoDbEncryptionInterceptorInput build() {
      if (Objects.isNull(this.tableEncryptionConfigs())) {
        throw new IllegalArgumentException(
          "Missing value for required field `tableEncryptionConfigs`"
        );
      }
      return new CreateDynamoDbEncryptionInterceptorInput(this);
    }
  }
}
