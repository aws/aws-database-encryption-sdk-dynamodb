// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using System.IO;
 using System.Collections.Generic;
 using AWS.Cryptography.StructuredEncryption;
 using Dafny.Aws.Cryptography.StructuredEncryption.Types; namespace AWS.Cryptography.StructuredEncryption {
 public class StructuredEncryption {
 private readonly IStructuredEncryptionClient _impl;
 public StructuredEncryption(AWS.Cryptography.StructuredEncryption.StructuredEncryptionConfig input)
 {
 Dafny.Aws.Cryptography.StructuredEncryption.Types._IStructuredEncryptionConfig internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S26_StructuredEncryptionConfig(input);
 var result = Dafny.Aws.Cryptography.StructuredEncryption.__default.StructuredEncryption(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 this._impl = result.dtor_value;
}
 public AWS.Cryptography.StructuredEncryption.EncryptStructureOutput EncryptStructure(AWS.Cryptography.StructuredEncryption.EncryptStructureInput input) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types._IEncryptStructureInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_EncryptStructureInput(input);
 Wrappers_Compile._IResult<Dafny.Aws.Cryptography.StructuredEncryption.Types._IEncryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types._IError> result = _impl.EncryptStructure(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 return TypeConversion.FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_EncryptStructureOutput(result.dtor_value);
}
 public AWS.Cryptography.StructuredEncryption.DecryptStructureOutput DecryptStructure(AWS.Cryptography.StructuredEncryption.DecryptStructureInput input) {
 Dafny.Aws.Cryptography.StructuredEncryption.Types._IDecryptStructureInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S21_DecryptStructureInput(input);
 Wrappers_Compile._IResult<Dafny.Aws.Cryptography.StructuredEncryption.Types._IDecryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types._IError> result = _impl.DecryptStructure(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 return TypeConversion.FromDafny_N3_aws__N12_cryptography__N20_structuredEncryption__S22_DecryptStructureOutput(result.dtor_value);
}
}
}
