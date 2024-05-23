#!/bin/sh

# If DAFNY is not defined, use ~/Documents/dafny/Binaries/Dafny.exe

if [ -z "$DAFNY" ]; then
  DAFNY=~/Documents/dafny/Binaries/Dafny.exe
fi

(cd ../../../DynamoDbEncryption;
$DAFNY -noVerify -compileTarget:rs -spillTargetCode:3 -compile:0 -optimizeErasableDatatypeWrapper:0 -quantifierSyntax:3 -unicodeChar:0 -functionSyntax:3 -useRuntimeLib -emitUncompilableCode -out runtimes/rust/ImplementationFromDafny UniqueToBuildInRust.dfy