// Class SearchInfo
// Dafny class SearchInfo compiled into Java
package SearchableEncryptionInfo_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;
import DynamoToStruct_Compile.*;
import DynamoDbEncryptionBranchKeyIdSupplier_Compile.*;
import AwsCryptographyDynamoDbEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.*;
import StructuredEncryptionUtil_Compile.*;
import Sets_Compile.*;
import StructuredEncryptionPaths_Compile.*;
import StructuredEncryptionHeader_Compile.*;
import StructuredEncryptionFooter_Compile.*;
import StructuredEncryptionCrypt_Compile.*;
import Maps_Compile.*;
import AwsCryptographyStructuredEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.StructuredEncryption.*;
import TermLoc_Compile.*;
import DdbVirtualFields_Compile.*;
import BaseBeacon_Compile.*;
import CompoundBeacon_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class SearchInfo {
  public dafny.DafnySequence<? extends BeaconVersion> _versions;
  public java.math.BigInteger _currWrite;
  public SearchInfo (dafny.DafnySequence<? extends BeaconVersion> versions, java.math.BigInteger currWrite) {
    this._versions = versions;
    this._currWrite = currWrite;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    SearchInfo o = (SearchInfo)other;
    return true && java.util.Objects.equals(this._versions, o._versions) && java.util.Objects.equals(this._currWrite, o._currWrite);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._versions);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._currWrite);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("SearchableEncryptionInfo_Compile.SearchInfo.SearchInfo");
    s.append("(");
    s.append(dafny.Helpers.toString(this._versions));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._currWrite));
    s.append(")");
    return s.toString();
  }

  private static final SearchInfo theDefault = SearchableEncryptionInfo_Compile.SearchInfo.create(dafny.DafnySequence.<BeaconVersion> empty(BeaconVersion._typeDescriptor()), java.math.BigInteger.ZERO);
  public static SearchInfo Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<SearchInfo> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(SearchInfo.class, () -> Default());
  public static dafny.TypeDescriptor<SearchInfo> _typeDescriptor() {
    return (dafny.TypeDescriptor<SearchInfo>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static SearchInfo create(dafny.DafnySequence<? extends BeaconVersion> versions, java.math.BigInteger currWrite) {
    return new SearchInfo(versions, currWrite);
  }
  public static SearchInfo create_SearchInfo(dafny.DafnySequence<? extends BeaconVersion> versions, java.math.BigInteger currWrite) {
    return create(versions, currWrite);
  }
  public boolean is_SearchInfo() { return true; }
  public dafny.DafnySequence<? extends BeaconVersion> dtor_versions() {
    return this._versions;
  }
  public java.math.BigInteger dtor_currWrite() {
    return this._currWrite;
  }
  public BeaconVersion curr() {
    return ((BeaconVersion)(java.lang.Object)(((this).dtor_versions()).select(dafny.Helpers.toInt(((this).dtor_currWrite())))));
  }
  public boolean IsBeacon(dafny.DafnySequence<? extends Character> field) {
    return (((BeaconVersion)(java.lang.Object)(((this).dtor_versions()).select(dafny.Helpers.toInt(((this).dtor_currWrite())))))).IsBeacon(field);
  }
  public boolean IsVirtualField(dafny.DafnySequence<? extends Character> field) {
    return (((BeaconVersion)(java.lang.Object)(((this).dtor_versions()).select(dafny.Helpers.toInt(((this).dtor_currWrite())))))).IsVirtualField(field);
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> GenerateClosure(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> fields) {
    return (((BeaconVersion)(java.lang.Object)(((this).dtor_versions()).select(dafny.Helpers.toInt(((this).dtor_currWrite())))))).GenerateClosure(fields);
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GeneratePlainBeacons(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
    if(true) {
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out44;
      _out44 = (((BeaconVersion)(java.lang.Object)(((this).dtor_versions()).select(dafny.Helpers.toInt(((this).dtor_currWrite())))))).GeneratePlainBeacons(item);
      output = _out44;
    }
    return output;
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GenerateSignedBeacons(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
    if(true) {
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out45;
      _out45 = (((BeaconVersion)(java.lang.Object)(((this).dtor_versions()).select(dafny.Helpers.toInt(((this).dtor_currWrite())))))).GenerateSignedBeacons(item);
      output = _out45;
    }
    return output;
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GenerateEncryptedBeacons(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, DynamoDbEncryptionUtil_Compile.MaybeKeyId keyId)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
    if(true) {
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out46;
      _out46 = (((BeaconVersion)(java.lang.Object)(((this).dtor_versions()).select(dafny.Helpers.toInt(((this).dtor_currWrite())))))).GenerateEncryptedBeacons(item, keyId);
      output = _out46;
    }
    return output;
  }
}
