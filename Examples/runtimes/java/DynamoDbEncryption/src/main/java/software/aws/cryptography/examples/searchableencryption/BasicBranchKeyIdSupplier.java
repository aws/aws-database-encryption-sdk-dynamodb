package software.aws.cryptography.examples.searchableencryption;

import software.amazon.cryptography.dynamoDbEncryption.IDynamoDbKeyBranchKeyIdSupplier;
import software.amazon.cryptography.dynamoDbEncryption.model.GetBranchKeyIdFromDdbKeyInput;
import software.amazon.cryptography.dynamoDbEncryption.model.GetBranchKeyIdFromDdbKeyOutput;

public class BasicBranchKeyIdSupplier implements IDynamoDbKeyBranchKeyIdSupplier {

  String branchKeyId;

  public BasicBranchKeyIdSupplier(String _branchKeyId) {
    branchKeyId = _branchKeyId;
  }

  @Override
  public GetBranchKeyIdFromDdbKeyOutput GetBranchKeyIdFromDdbKey(
      GetBranchKeyIdFromDdbKeyInput getBranchKeyIdFromDdbKeyInput) {
    return GetBranchKeyIdFromDdbKeyOutput.builder().branchKeyId(branchKeyId).build();
  }
}
