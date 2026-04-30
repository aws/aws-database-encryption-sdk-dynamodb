// Class __default
// Dafny class __default compiled into Java
package DynamoDbEncryptionBranchKeyIdSupplier_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static software.amazon.cryptography.materialproviders.internaldafny.types.Error ConvertToMplError(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error err) {
    if ((err).is_Opaque()) {
      return software.amazon.cryptography.materialproviders.internaldafny.types.Error.create_Opaque((err).dtor_obj());
    } else {
      return software.amazon.cryptography.materialproviders.internaldafny.types.Error.create_AwsCryptographicMaterialProvidersException(dafny.DafnySequence.asString("Unexpected error while getting Branch Key ID."));
    }
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbEncryptionBranchKeyIdSupplier._default";
  }
}
