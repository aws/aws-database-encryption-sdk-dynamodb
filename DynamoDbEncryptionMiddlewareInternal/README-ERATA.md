# Manual Modifications to Generated Code

## Smithy->Java

The DDB imported Inputs and Outputs use the wrong name and package.
- Input/Output -> Request/Response
- com.amazonaws.dynamodb -> software.amazon.awssdk.services.dynamodb

## Smithy->Dafny

The generated Dafny does not appropriately use the correct ensures/modifies around the created client.
See the Dafny Types file for the modifications.
