// Class Error
// Dafny class Error compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types;

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
import SearchableEncryptionInfo_Compile.*;
import SearchConfigToInfo_Compile.*;
import DynamoDbUpdateExpr_Compile.*;
import DynamoDBFilterExpr_Compile.*;
import DynamoDBIndexSupport_Compile.*;
import DynamoDBSupport_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class Error {
  public Error() { }

  private static final Error theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error.create_DynamoDbEncryptionTransformsException(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
  public static Error Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<Error> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Error.class, () -> Default());
  public static dafny.TypeDescriptor<Error> _typeDescriptor() {
    return (dafny.TypeDescriptor<Error>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static Error create_DynamoDbEncryptionTransformsException(dafny.DafnySequence<? extends Character> message) {
    return new Error_DynamoDbEncryptionTransformsException(message);
  }
  public static Error create_AwsCryptographyDynamoDbEncryption(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error AwsCryptographyDynamoDbEncryption) {
    return new Error_AwsCryptographyDynamoDbEncryption(AwsCryptographyDynamoDbEncryption);
  }
  public static Error create_AwsCryptographyDynamoDbEncryptionItemEncryptor(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error AwsCryptographyDynamoDbEncryptionItemEncryptor) {
    return new Error_AwsCryptographyDynamoDbEncryptionItemEncryptor(AwsCryptographyDynamoDbEncryptionItemEncryptor);
  }
  public static Error create_ComAmazonawsDynamodb(Dafny.Com.Amazonaws.Dynamodb.Types.Error ComAmazonawsDynamodb) {
    return new Error_ComAmazonawsDynamodb(ComAmazonawsDynamodb);
  }
  public static Error create_CollectionOfErrors(dafny.DafnySequence<? extends Error> list) {
    return new Error_CollectionOfErrors(list);
  }
  public static Error create_Opaque(Object obj) {
    return new Error_Opaque(obj);
  }
  public boolean is_DynamoDbEncryptionTransformsException() { return this instanceof Error_DynamoDbEncryptionTransformsException; }
  public boolean is_AwsCryptographyDynamoDbEncryption() { return this instanceof Error_AwsCryptographyDynamoDbEncryption; }
  public boolean is_AwsCryptographyDynamoDbEncryptionItemEncryptor() { return this instanceof Error_AwsCryptographyDynamoDbEncryptionItemEncryptor; }
  public boolean is_ComAmazonawsDynamodb() { return this instanceof Error_ComAmazonawsDynamodb; }
  public boolean is_CollectionOfErrors() { return this instanceof Error_CollectionOfErrors; }
  public boolean is_Opaque() { return this instanceof Error_Opaque; }
  public dafny.DafnySequence<? extends Character> dtor_message() {
    Error d = this;
    return ((Error_DynamoDbEncryptionTransformsException)d)._message;
  }
  public Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error dtor_AwsCryptographyDynamoDbEncryption() {
    Error d = this;
    return ((Error_AwsCryptographyDynamoDbEncryption)d)._AwsCryptographyDynamoDbEncryption;
  }
  public Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error dtor_AwsCryptographyDynamoDbEncryptionItemEncryptor() {
    Error d = this;
    return ((Error_AwsCryptographyDynamoDbEncryptionItemEncryptor)d)._AwsCryptographyDynamoDbEncryptionItemEncryptor;
  }
  public Dafny.Com.Amazonaws.Dynamodb.Types.Error dtor_ComAmazonawsDynamodb() {
    Error d = this;
    return ((Error_ComAmazonawsDynamodb)d)._ComAmazonawsDynamodb;
  }
  public dafny.DafnySequence<? extends Error> dtor_list() {
    Error d = this;
    return ((Error_CollectionOfErrors)d)._list;
  }
  public Object dtor_obj() {
    Error d = this;
    return ((Error_Opaque)d)._obj;
  }
}
