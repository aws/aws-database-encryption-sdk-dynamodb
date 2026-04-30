// Class __default
// Dafny class __default compiled into Java
package BatchWriteItemTransform_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> Input(DdbMiddlewareConfig_Compile.Config config, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
    dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _0_tableNames;
    _0_tableNames = (((input).dtor_sdkInput()).dtor_RequestItems()).keySet();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>> _1_result;
    _1_result = dafny.DafnyMap.fromElements();
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _2_tableNamesSeq;
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _out0;
    _out0 = SortedSets.__default.<dafny.DafnySequence<? extends Character>>SetToSequence(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableArn._typeDescriptor(), _0_tableNames);
    _2_tableNamesSeq = _out0;
    java.math.BigInteger _3_i = java.math.BigInteger.ZERO;
    _3_i = java.math.BigInteger.ZERO;
    while ((_3_i).compareTo(java.math.BigInteger.valueOf((_2_tableNamesSeq).length())) < 0) {
      dafny.DafnySequence<? extends Character> _4_tableName;
      _4_tableName = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_2_tableNamesSeq).select(dafny.Helpers.toInt((_3_i)))));
      dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest> _5_writeRequests;
      _5_writeRequests = ((dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>)(java.lang.Object)((((input).dtor_sdkInput()).dtor_RequestItems()).get(_4_tableName)));
      if (!(DdbMiddlewareConfig_Compile.__default.IsPlainWrite(config, _4_tableName))) {
        DdbMiddlewareConfig_Compile.TableConfig _6_tableConfig;
        _6_tableConfig = ((DdbMiddlewareConfig_Compile.TableConfig)(java.lang.Object)(((config).dtor_tableEncryptionConfigs()).get(_4_tableName)));
        dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest> _7_encryptedItems;
        _7_encryptedItems = dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest> empty(software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest._typeDescriptor());
        java.math.BigInteger _hi0 = java.math.BigInteger.valueOf((_5_writeRequests).length());
        for (java.math.BigInteger _8_x = java.math.BigInteger.ZERO; _8_x.compareTo(_hi0) < 0; _8_x = _8_x.add(java.math.BigInteger.ONE)) {
          software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest _9_req;
          _9_req = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest)(java.lang.Object)((_5_writeRequests).select(dafny.Helpers.toInt((_8_x)))));
          if (((_9_req).dtor_PutRequest()).is_None()) {
            _7_encryptedItems = dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>concatenate(_7_encryptedItems, dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest._typeDescriptor(), _9_req));
          } else {
            Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _10_valueOrError0 = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), false);
            Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out1;
            _out1 = DynamoDbMiddlewareSupport_Compile.__default.IsWriteable(_6_tableConfig, (((_9_req).dtor_PutRequest()).dtor_value()).dtor_Item());
            _10_valueOrError0 = _out1;
            if ((_10_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor())) {
              output = (_10_valueOrError0).<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput._typeDescriptor());
              return output;
            }
            boolean _11___v0;
            _11___v0 = (_10_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor());
            Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _12_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
            Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out2;
            _out2 = DynamoDbMiddlewareSupport_Compile.__default.AddSignedBeacons(_6_tableConfig, (((_9_req).dtor_PutRequest()).dtor_value()).dtor_Item());
            _12_valueOrError1 = _out2;
            if ((_12_valueOrError1).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor())) {
              output = (_12_valueOrError1).<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput._typeDescriptor());
              return output;
            }
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _13_item;
            _13_item = (_12_valueOrError1).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor());
            Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _14_encryptRes;
            Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out3;
            _out3 = ((_6_tableConfig).dtor_itemEncryptor()).EncryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput.create(_13_item));
            _14_encryptRes = _out3;
            Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _15_valueOrError2 = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput.Default());
            _15_valueOrError2 = DdbMiddlewareConfig_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput>MapError(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput._typeDescriptor(), _14_encryptRes);
            if ((_15_valueOrError2).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor())) {
              output = (_15_valueOrError2).<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput._typeDescriptor());
              return output;
            }
            software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput _16_encrypted;
            _16_encrypted = (_15_valueOrError2).Extract(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor());
            Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _17_valueOrError3 = Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
            _17_valueOrError3 = DynamoDbMiddlewareSupport_Compile.__default.GetKeyIdFromHeader(_6_tableConfig, _16_encrypted);
            if ((_17_valueOrError3).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor())) {
              output = (_17_valueOrError3).<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput._typeDescriptor());
              return output;
            }
            Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _18_keyId;
            _18_keyId = (_17_valueOrError3).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor());
            Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _19_valueOrError4 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
            Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out4;
            _out4 = DynamoDbMiddlewareSupport_Compile.__default.GetEncryptedBeacons(_6_tableConfig, (((_9_req).dtor_PutRequest()).dtor_value()).dtor_Item(), DynamoDbEncryptionUtil_Compile.__default.MaybeFromOptionKeyId(_18_keyId));
            _19_valueOrError4 = _out4;
            if ((_19_valueOrError4).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor())) {
              output = (_19_valueOrError4).<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput._typeDescriptor());
              return output;
            }
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _20_beaconAttrs;
            _20_beaconAttrs = (_19_valueOrError4).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor());
            software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput _pat_let_tv0 = _16_encrypted;
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _pat_let_tv1 = _20_beaconAttrs;
            _7_encryptedItems = dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>concatenate(_7_encryptedItems, dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest._typeDescriptor(), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest)(java.lang.Object)(dafny.Helpers.<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest, software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>Let(_9_req, boxed60 -> {
              software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest _pat_let31_0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest)(java.lang.Object)(boxed60));
              return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest)(java.lang.Object)(dafny.Helpers.<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest, software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>Let(_pat_let31_0, boxed61 -> {
                software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest _21_dt__update__tmp_h0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest)(java.lang.Object)(boxed61));
                return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.PutRequest>, software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>Let(Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.PutRequest>create_Some(software.amazon.cryptography.services.dynamodb.internaldafny.types.PutRequest._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.PutRequest.create(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>merge((_pat_let_tv0).dtor_encryptedItem(), _pat_let_tv1))), boxed62 -> {
                  Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.PutRequest> _pat_let32_0 = ((Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.PutRequest>)(java.lang.Object)(boxed62));
                  return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.PutRequest>, software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>Let(_pat_let32_0, boxed63 -> {
                    Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.PutRequest> _22_dt__update_hPutRequest_h0 = ((Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.PutRequest>)(java.lang.Object)(boxed63));
                    return software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest.create(_22_dt__update_hPutRequest_h0, (_21_dt__update__tmp_h0).dtor_DeleteRequest());
                  }
                  )));
                }
                )));
              }
              )));
            }
            )))));
          }
        }
        _5_writeRequests = _7_encryptedItems;
      }
      _3_i = (_3_i).add(java.math.BigInteger.ONE);
      _1_result = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>>update(_1_result, _4_tableName, _5_writeRequests);
    }
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _23_valueOrError5 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor());
    _23_valueOrError5 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), java.util.Objects.equals(java.math.BigInteger.valueOf((_1_result).size()), java.math.BigInteger.valueOf((((input).dtor_sdkInput()).dtor_RequestItems()).size())), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Internal Error")));
    if ((_23_valueOrError5).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor())) {
      output = (_23_valueOrError5).<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput._typeDescriptor());
      return output;
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>> _pat_let_tv2 = _1_result;
    output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>create_Success(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput.create(((software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput)(java.lang.Object)(dafny.Helpers.<software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput, software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput>Let((input).dtor_sdkInput(), boxed64 -> {
  software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput _pat_let33_0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput)(java.lang.Object)(boxed64));
  return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput)(java.lang.Object)(dafny.Helpers.<software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput, software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput>Let(_pat_let33_0, boxed65 -> {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput _24_dt__update__tmp_h1 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput)(java.lang.Object)(boxed65));
    return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput)(java.lang.Object)(dafny.Helpers.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput>Let(_pat_let_tv2, boxed66 -> {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>> _pat_let34_0 = ((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>>)(java.lang.Object)(boxed66));
      return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput)(java.lang.Object)(dafny.Helpers.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput>Let(_pat_let34_0, boxed67 -> {
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>> _25_dt__update_hRequestItems_h0 = ((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>>)(java.lang.Object)(boxed67));
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput.create(_25_dt__update_hRequestItems_h0, (_24_dt__update__tmp_h1).dtor_ReturnConsumedCapacity(), (_24_dt__update__tmp_h1).dtor_ReturnItemCollectionMetrics());
      }
      )));
    }
    )));
  }
  )));
}
)))));
    return output;
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> GetOrigItem(DdbMiddlewareConfig_Compile.TableConfig tableConfig, dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest> srcRequests, software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest itemReq)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> ret = Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest.Default());
    dafny.DafnySequence<? extends Character> _0_partKey;
    _0_partKey = (tableConfig).dtor_partitionKeyName();
    Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1_sortKey;
    _1_sortKey = (tableConfig).dtor_sortKeyName();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _2_item;
    _2_item = (((itemReq).dtor_PutRequest()).dtor_value()).dtor_Item();
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _3_valueOrError0 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor());
    _3_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), (_2_item).<dafny.DafnySequence<? extends Character>>contains(_0_partKey), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Required partition key not in unprocessed item")));
    if ((_3_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor())) {
      ret = (_3_valueOrError0).<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest._typeDescriptor());
      return ret;
    }
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _4_valueOrError1 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor());
    _4_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), ((_1_sortKey).is_None()) || ((_2_item).<dafny.DafnySequence<? extends Character>>contains((_1_sortKey).dtor_value())), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Required sort key not in unprocessed item")));
    if ((_4_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor())) {
      ret = (_4_valueOrError1).<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest._typeDescriptor());
      return ret;
    }
    java.math.BigInteger _hi0 = java.math.BigInteger.valueOf((srcRequests).length());
    for (java.math.BigInteger _5_i = java.math.BigInteger.ZERO; _5_i.compareTo(_hi0) < 0; _5_i = _5_i.add(java.math.BigInteger.ONE)) {
      if (((((software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest)(java.lang.Object)((srcRequests).select(dafny.Helpers.toInt((_5_i)))))).dtor_PutRequest()).is_Some()) {
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _6_req;
        _6_req = (((((software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest)(java.lang.Object)((srcRequests).select(dafny.Helpers.toInt((_5_i)))))).dtor_PutRequest()).dtor_value()).dtor_Item();
        if (((_6_req).<dafny.DafnySequence<? extends Character>>contains(_0_partKey)) && (java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_6_req).get(_0_partKey))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_2_item).get(_0_partKey)))))) {
          if (((_1_sortKey).is_None()) || (((_6_req).<dafny.DafnySequence<? extends Character>>contains((_1_sortKey).dtor_value())) && (java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_6_req).get((_1_sortKey).dtor_value()))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_2_item).get((_1_sortKey).dtor_value()))))))) {
            ret = Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest)(java.lang.Object)((srcRequests).select(dafny.Helpers.toInt((_5_i))))));
            return ret;
          }
        }
      }
    }
    ret = Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>create_Failure(software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Item in UnprocessedItems not found in original request.")));
    return ret;
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> Output(DdbMiddlewareConfig_Compile.Config config, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput.Default());
    if ((((input).dtor_sdkOutput()).dtor_UnprocessedItems()).is_None()) {
      output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>create_Success(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput.create((input).dtor_sdkOutput()));
      return output;
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>> _0_srcItems;
    _0_srcItems = ((input).dtor_originalInput()).dtor_RequestItems();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>> _1_unprocessed;
    _1_unprocessed = (((input).dtor_sdkOutput()).dtor_UnprocessedItems()).dtor_value();
    dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _2_tableNames;
    _2_tableNames = (_1_unprocessed).keySet();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>> _3_result;
    _3_result = dafny.DafnyMap.fromElements();
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _4_tableNamesSeq;
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _out0;
    _out0 = SortedSets.__default.<dafny.DafnySequence<? extends Character>>SetToSequence(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableArn._typeDescriptor(), _2_tableNames);
    _4_tableNamesSeq = _out0;
    java.math.BigInteger _5_i = java.math.BigInteger.ZERO;
    _5_i = java.math.BigInteger.ZERO;
    while ((_5_i).compareTo(java.math.BigInteger.valueOf((_4_tableNamesSeq).length())) < 0) {
      dafny.DafnySequence<? extends Character> _6_tableName;
      _6_tableName = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_4_tableNamesSeq).select(dafny.Helpers.toInt((_5_i)))));
      dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest> _7_writeRequests;
      _7_writeRequests = ((dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>)(java.lang.Object)((_1_unprocessed).get(_6_tableName)));
      if (!(DdbMiddlewareConfig_Compile.__default.IsPlainWrite(config, _6_tableName))) {
        if (!(_0_srcItems).<dafny.DafnySequence<? extends Character>>contains(_6_tableName)) {
          output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>create_Failure(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(_6_tableName, dafny.DafnySequence.asString(" in UnprocessedItems for BatchWriteItem response, but not in original request."))));
          return output;
        }
        dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest> _8_srcRequests;
        _8_srcRequests = ((dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>)(java.lang.Object)((_0_srcItems).get(_6_tableName)));
        DdbMiddlewareConfig_Compile.TableConfig _9_tableConfig;
        _9_tableConfig = ((DdbMiddlewareConfig_Compile.TableConfig)(java.lang.Object)(((config).dtor_tableEncryptionConfigs()).get(_6_tableName)));
        dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest> _10_origItems;
        _10_origItems = dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest> empty(software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest._typeDescriptor());
        java.math.BigInteger _hi0 = java.math.BigInteger.valueOf((_7_writeRequests).length());
        for (java.math.BigInteger _11_x = java.math.BigInteger.ZERO; _11_x.compareTo(_hi0) < 0; _11_x = _11_x.add(java.math.BigInteger.ONE)) {
          software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest _12_req;
          _12_req = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest)(java.lang.Object)((_7_writeRequests).select(dafny.Helpers.toInt((_11_x)))));
          if (((_12_req).dtor_PutRequest()).is_None()) {
            _10_origItems = dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>concatenate(_10_origItems, dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest._typeDescriptor(), _12_req));
          } else {
            Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _13_valueOrError0 = Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest.Default());
            Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out1;
            _out1 = __default.GetOrigItem(_9_tableConfig, _8_srcRequests, _12_req);
            _13_valueOrError0 = _out1;
            if ((_13_valueOrError0).IsFailure(software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor())) {
              output = (_13_valueOrError0).<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput>PropagateFailure(software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput._typeDescriptor());
              return output;
            }
            software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest _14_orig__item;
            _14_orig__item = (_13_valueOrError0).Extract(software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor());
            _10_origItems = dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>concatenate(_10_origItems, dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest._typeDescriptor(), _14_orig__item));
          }
        }
        _7_writeRequests = _10_origItems;
      }
      _5_i = (_5_i).add(java.math.BigInteger.ONE);
      _3_result = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>>update(_3_result, _6_tableName, _7_writeRequests);
    }
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _15_valueOrError1 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor());
    _15_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), java.util.Objects.equals(java.math.BigInteger.valueOf((_3_result).size()), java.math.BigInteger.valueOf((_1_unprocessed).size())), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Internal Error")));
    if ((_15_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor())) {
      output = (_15_valueOrError1).<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput._typeDescriptor());
      return output;
    }
    software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemOutput _16_new__output;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemOutput _17_dt__update__tmp_h0 = (input).dtor_sdkOutput();
    Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>>> _18_dt__update_hUnprocessedItems_h0 = Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>>>create_Some(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableArn._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequests._typeDescriptor()), _3_result);
    _16_new__output = software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemOutput.create(_18_dt__update_hUnprocessedItems_h0, (_17_dt__update__tmp_h0).dtor_ItemCollectionMetrics(), (_17_dt__update__tmp_h0).dtor_ConsumedCapacity());
    output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>create_Success(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput.create(_16_new__output));
    return output;
  }
  @Override
  public java.lang.String toString() {
    return "BatchWriteItemTransform._default";
  }
}
