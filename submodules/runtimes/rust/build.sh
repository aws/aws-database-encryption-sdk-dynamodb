#!/bin/sh

# If DAFNY is not defined, use ~/Documents/dafny/Binaries/Dafny.exe

if [ -z "$DAFNY" ]; then
  DAFNY=~/Documents/dafny/Binaries/Dafny.exe
fi

(cd ../../../submodules;
$DAFNY translate rs --no-verify --emit-uncompilable-code:true \
--allow-warnings --optimize-erasable-datatype-wrapper:false \
--quantifier-syntax:3 --unicode-char:false --function-syntax:3 \
--include-runtime:true --output runtimes/rust/ImplementationFromDafny \
C:/Users/mimayere/Documents/aws-database-encryption-sdk-dynamodb-java/submodules/MaterialProviders/StandardLibrary/src/Index.dfy \
C:/Users/mimayere/Documents/aws-database-encryption-sdk-dynamodb-java/submodules/MaterialProviders/AwsCryptographyPrimitives/src/Index.dfy \
C:/Users/mimayere/Documents/aws-database-encryption-sdk-dynamodb-java/submodules/MaterialProviders/ComAmazonawsKms/src/Index.dfy \
C:/Users/mimayere/Documents/aws-database-encryption-sdk-dynamodb-java/submodules/MaterialProviders/ComAmazonawsDynamodb/src/Index.dfy \
C:/Users/mimayere/Documents/aws-database-encryption-sdk-dynamodb-java/submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographicMaterialProviders/src/Index.dfy \
C:/Users/mimayere/Documents/aws-database-encryption-sdk-dynamodb-java/submodules/MaterialProviders/AwsCryptographicMaterialProviders/dafny/AwsCryptographyKeyStore/src/Index.dfy \
MaterialProvidersIndex.dfy
)