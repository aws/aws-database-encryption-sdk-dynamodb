// Class __default
// Dafny class __default compiled into Java
package AwsCryptographyDbEncryptionSdkDynamoDbOperations_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> CreateDynamoDbEncryptionBranchKeyIdSupplier(Config config, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    DynamoDbEncryptionBranchKeyIdSupplier_Compile.DynamoDbEncryptionBranchKeyIdSupplier _0_supplier;
    DynamoDbEncryptionBranchKeyIdSupplier_Compile.DynamoDbEncryptionBranchKeyIdSupplier _nw0 = new DynamoDbEncryptionBranchKeyIdSupplier_Compile.DynamoDbEncryptionBranchKeyIdSupplier();
    _nw0.__ctor((input).dtor_ddbKeyBranchKeyIdSupplier());
    _0_supplier = _nw0;
    output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput.create(_0_supplier));
    return output;
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetEncryptedDataKeyDescription(Config config, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput.Default());
    if(true) {
      dafny.DafnySequence<? extends java.lang.Byte> _0_header = dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor());
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion _source0 = (input).dtor_input();
      if (_source0.is_header()) {
        dafny.DafnySequence<? extends java.lang.Byte> _1___mcc_h0 = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion_header)_source0)._header;
        dafny.DafnySequence<? extends java.lang.Byte> _2_headerItem = _1___mcc_h0;
        _0_header = _2_headerItem;
      } else {
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _3___mcc_h1 = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion_item)_source0)._item;
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _4_item = _3___mcc_h1;
        {
          Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError0 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          _5_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((_4_item).<dafny.DafnySequence<? extends Character>>contains(dafny.DafnySequence.asString("aws_dbe_head"))) && ((((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_4_item).get(dafny.DafnySequence.asString("aws_dbe_head"))))).is_B()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Header not found in the DynamoDB item.")));
          if ((_5_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            output = (_5_valueOrError0).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor());
            return output;
          }
          _0_header = (((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_4_item).get(dafny.DafnySequence.asString("aws_dbe_head"))))).dtor_B();
        }
      }
      Wrappers_Compile.Result<StructuredEncryptionHeader_Compile.PartialHeader, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_valueOrError1 = (Wrappers_Compile.Result<StructuredEncryptionHeader_Compile.PartialHeader, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
      _6_valueOrError1 = (StructuredEncryptionHeader_Compile.__default.PartialDeserialize(_0_header)).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(StructuredEncryptionHeader_Compile.PartialHeader._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_7_e_boxed0) -> {
        software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error _7_e = ((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error)(java.lang.Object)(_7_e_boxed0));
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_AwsCryptographyDbEncryptionSdkStructuredEncryption(_7_e);
      }));
      if ((_6_valueOrError1).IsFailure(StructuredEncryptionHeader_Compile.PartialHeader._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_6_valueOrError1).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput>PropagateFailure(StructuredEncryptionHeader_Compile.PartialHeader._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor());
        return output;
      }
      StructuredEncryptionHeader_Compile.PartialHeader _8_deserializedHeader;
      _8_deserializedHeader = (_6_valueOrError1).Extract(StructuredEncryptionHeader_Compile.PartialHeader._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> _9_datakeys;
      _9_datakeys = (_8_deserializedHeader).dtor_dataKeys();
      dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription> _10_list;
      _10_list = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription> empty(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription._typeDescriptor());
      long _hi0 = (long) (_9_datakeys).cardinalityInt();
      for (long _11_i = (long) 0L; java.lang.Long.compareUnsigned(_11_i, _hi0) < 0; _11_i++) {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _12_valueOrError2 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
        _12_valueOrError2 = (UTF8.__default.Decode((((software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey)(java.lang.Object)((_9_datakeys).select(dafny.Helpers.unsignedToInt(_11_i))))).dtor_keyProviderId())).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_13_e_boxed0) -> {
          dafny.DafnySequence<? extends Character> _13_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_13_e_boxed0));
          return DynamoDbEncryptionUtil_Compile.__default.E(_13_e);
        }));
        if ((_12_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_12_valueOrError2).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor());
          return output;
        }
        dafny.DafnySequence<? extends Character> _14_extractedKeyProviderId;
        _14_extractedKeyProviderId = (_12_valueOrError2).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _15_extractedKeyProviderIdInfo;
        _15_extractedKeyProviderIdInfo = Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _16_expectedBranchKeyVersion;
        _16_expectedBranchKeyVersion = Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        if ((dafny.DafnySequence.asString("aws-kms")).isPrefixOf(_14_extractedKeyProviderId)) {
          Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _17_valueOrError3 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          _17_valueOrError3 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((((_8_deserializedHeader).dtor_flavor()) == 0 ? 0 : 1) == 0) || (((_8_deserializedHeader).dtor_flavor()) == ((byte) 1)), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid format flavor.")));
          if ((_17_valueOrError3).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            output = (_17_valueOrError3).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor());
            return output;
          }
          software.amazon.cryptography.materialproviders.internaldafny.types.AlgorithmSuiteInfo _18_algorithmSuite = (software.amazon.cryptography.materialproviders.internaldafny.types.AlgorithmSuiteInfo)null;
          if ((((_8_deserializedHeader).dtor_flavor()) == 0 ? 0 : 1) == 0) {
            _18_algorithmSuite = AlgorithmSuites_Compile.__default.DBE__ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384();
          } else {
            _18_algorithmSuite = AlgorithmSuites_Compile.__default.DBE__ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384();
          }
          Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _19_valueOrError4 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
          _19_valueOrError4 = (UTF8.__default.Decode((((software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey)(java.lang.Object)((_9_datakeys).select(dafny.Helpers.unsignedToInt(_11_i))))).dtor_keyProviderInfo())).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_20_e_boxed0) -> {
            dafny.DafnySequence<? extends Character> _20_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_20_e_boxed0));
            return DynamoDbEncryptionUtil_Compile.__default.E(_20_e);
          }));
          if ((_19_valueOrError4).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            output = (_19_valueOrError4).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor());
            return output;
          }
          dafny.DafnySequence<? extends Character> _21_maybeKeyProviderIdInfo;
          _21_maybeKeyProviderIdInfo = (_19_valueOrError4).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          _15_extractedKeyProviderIdInfo = Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _21_maybeKeyProviderIdInfo);
          if ((_14_extractedKeyProviderId).equals(dafny.DafnySequence.asString("aws-kms-hierarchy"))) {
            Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _22_valueOrError5 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
            _22_valueOrError5 = (EdkWrapping_Compile.__default.GetProviderWrappedMaterial((((software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey)(java.lang.Object)((_9_datakeys).select(dafny.Helpers.unsignedToInt(_11_i))))).dtor_ciphertext(), _18_algorithmSuite)).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.materialproviders.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_23_e_boxed0) -> {
              software.amazon.cryptography.materialproviders.internaldafny.types.Error _23_e = ((software.amazon.cryptography.materialproviders.internaldafny.types.Error)(java.lang.Object)(_23_e_boxed0));
              return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_AwsCryptographyMaterialProviders(_23_e);
            }));
            if ((_22_valueOrError5).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
              output = (_22_valueOrError5).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor());
              return output;
            }
            dafny.DafnySequence<? extends java.lang.Byte> _24_providerWrappedMaterial;
            _24_providerWrappedMaterial = (_22_valueOrError5).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            long _25_EDK__CIPHERTEXT__BRANCH__KEY__VERSION__INDEX;
            _25_EDK__CIPHERTEXT__BRANCH__KEY__VERSION__INDEX = (long) (long) ((__default.SALT__LENGTH()) + (__default.IV__LENGTH()));
            long _26_EDK__CIPHERTEXT__VERSION__INDEX;
            _26_EDK__CIPHERTEXT__VERSION__INDEX = (long) (long) ((_25_EDK__CIPHERTEXT__BRANCH__KEY__VERSION__INDEX) + (__default.VERSION__LENGTH()));
            Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _27_valueOrError6 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            _27_valueOrError6 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned(_25_EDK__CIPHERTEXT__BRANCH__KEY__VERSION__INDEX, _26_EDK__CIPHERTEXT__VERSION__INDEX) < 0, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Wrong branch key version index.")));
            if ((_27_valueOrError6).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
              output = (_27_valueOrError6).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor());
              return output;
            }
            Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _28_valueOrError7 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            _28_valueOrError7 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned((long) (_24_providerWrappedMaterial).cardinalityInt(), _26_EDK__CIPHERTEXT__VERSION__INDEX) >= 0, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Incorrect ciphertext structure length.")));
            if ((_28_valueOrError7).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
              output = (_28_valueOrError7).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor());
              return output;
            }
            dafny.DafnySequence<? extends java.lang.Byte> _29_branchKeyVersionUuid;
            _29_branchKeyVersionUuid = (_24_providerWrappedMaterial).subsequence(dafny.Helpers.unsignedToInt(_25_EDK__CIPHERTEXT__BRANCH__KEY__VERSION__INDEX), dafny.Helpers.unsignedToInt(_26_EDK__CIPHERTEXT__VERSION__INDEX));
            Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _30_valueOrError8 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
            _30_valueOrError8 = (UUID.__default.FromByteArray(_29_branchKeyVersionUuid)).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_31_e_boxed0) -> {
              dafny.DafnySequence<? extends Character> _31_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_31_e_boxed0));
              return DynamoDbEncryptionUtil_Compile.__default.E(_31_e);
            }));
            if ((_30_valueOrError8).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
              output = (_30_valueOrError8).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor());
              return output;
            }
            dafny.DafnySequence<? extends Character> _32_maybeBranchKeyVersion;
            _32_maybeBranchKeyVersion = (_30_valueOrError8).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            _16_expectedBranchKeyVersion = Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _32_maybeBranchKeyVersion);
          }
        }
        software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription _33_singleDataKeyOutput;
        _33_singleDataKeyOutput = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription.create(_14_extractedKeyProviderId, _15_extractedKeyProviderIdInfo, _15_extractedKeyProviderIdInfo, _16_expectedBranchKeyVersion);
        _10_list = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription>concatenate(_10_list, dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription._typeDescriptor(), _33_singleDataKeyOutput));
      }
      output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput.create(_10_list));
    }
    return output;
  }
  public static long SALT__LENGTH()
  {
    return (long) 16L;
  }
  public static long IV__LENGTH()
  {
    return (long) 12L;
  }
  public static long VERSION__LENGTH()
  {
    return (long) 16L;
  }
  @Override
  public java.lang.String toString() {
    return "AwsCryptographyDbEncryptionSdkDynamoDbOperations._default";
  }
}
