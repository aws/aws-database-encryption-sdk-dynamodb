# Manual Modifications to Generated Code

## Smithy->Java

The DDB imported Inputs and Outputs use the wrong name and package.
- Input/Output -> Request/Response
- com.amazonaws.dynamodb -> software.amazon.awssdk.services.dynamodb

## Smithy->Dafny

The generated Dafny does not appropriately use the correct ensures/modifies around the created client.
See the Dafny Types file for the modifications.


## Errors from dependencies

The current codegen does not properly wrap errors coming from dependencies,
and thus all such errors bubble up as Opaque.
To fix this, manual updates were made to the generated error types such that:
- They extended RuntimeException instead of a generated NativeError type
- ToNative/ToDafny Error was updated to correctly detect and wrap dependencies
  errors

## Resource handling

Resources were not modelled correctly in generated code. They were manually updated
such that the right type was being inputted/outputted by our conversions.
For example, we should directly return AWS SDK clients instead of our wrapper around them.
Similarly, when returning Keyring/CMM types we need to return/accept their interfaces.

## Legacy Config missing from Smithy model

The Legacy Config on the TableEncryptionConfig was manually added, and needs to be
modeled in smithy and generated from there.
