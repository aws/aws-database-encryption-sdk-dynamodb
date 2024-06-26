/*
 * Copyright 2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except
 * in compliance with the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.amazonaws.services.dynamodbv2.mapper.integration;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBVersionAttribute;
import com.amazonaws.services.dynamodbv2.mapper.encryption.TestDynamoDBMapperFactory;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;

/** Tests of exception handling */
public class ExceptionHandlingITCase
  extends DynamoDBMapperCryptoIntegrationTestBase {

  public static class NoTableAnnotation {

    private String key;

    @DynamoDBHashKey
    public String getKey() {
      return key;
    }

    public void setKey(String key) {
      this.key = key;
    }
  }

  @Test(expectedExceptions = DynamoDBMappingException.class)
  public void testNoTableAnnotation() throws Exception {
    DynamoDBMapper util = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    util.save(new NoTableAnnotation());
  }

  @Test(expectedExceptions = DynamoDBMappingException.class)
  public void testNoTableAnnotationLoad() throws Exception {
    DynamoDBMapper util = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    util.load(NoTableAnnotation.class, "abc");
  }

  @DynamoDBTable(tableName = TABLE_NAME)
  public static class NoDefaultConstructor {

    private String key;
    private String attribute;

    @DynamoDBHashKey
    public String getKey() {
      return key;
    }

    public void setKey(String key) {
      this.key = key;
    }

    public String getAttribute() {
      return attribute;
    }

    public void setAttribute(String attribute) {
      this.attribute = attribute;
    }

    public NoDefaultConstructor(String key, String attribute) {
      super();
      this.key = key;
      this.attribute = attribute;
    }
  }

  @Test(expectedExceptions = DynamoDBMappingException.class)
  public void testNoDefaultConstructor() {
    DynamoDBMapper util = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    NoDefaultConstructor obj = new NoDefaultConstructor("" + startKey++, "abc");
    util.save(obj);
    util.load(NoDefaultConstructor.class, obj.getKey());
  }

  @DynamoDBTable(tableName = TABLE_NAME)
  public static class NoKeyGetterDefined {

    @SuppressWarnings("unused")
    private String key;
  }

  @Test(expectedExceptions = DynamoDBMappingException.class)
  public void testNoHashKeyGetter() throws Exception {
    DynamoDBMapper util = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    util.save(new NoKeyGetterDefined());
  }

  @Test(expectedExceptions = DynamoDBMappingException.class)
  public void testNoHashKeyGetterLoad() throws Exception {
    DynamoDBMapper util = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    util.load(NoKeyGetterDefined.class, "abc");
  }

  @DynamoDBTable(tableName = TABLE_NAME)
  public static class PrivateKeyGetter {

    private String key;

    @SuppressWarnings("unused")
    @DynamoDBHashKey
    public String getKey() {
      return key;
    }

    @SuppressWarnings("unused")
    private void setKey(String key) {
      this.key = key;
    }
  }

  @Test(expectedExceptions = DynamoDBMappingException.class)
  public void testPrivateKeyGetter() throws Exception {
    DynamoDBMapper util = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    util.save(new PrivateKeyGetter());
  }

  @Test(expectedExceptions = DynamoDBMappingException.class)
  public void testPrivateKeyGetterLoad() throws Exception {
    DynamoDBMapper util = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    util.load(PrivateKeyGetter.class, "abc");
  }

  @DynamoDBTable(tableName = TABLE_NAME)
  public static class PrivateKeySetter {

    private String key;

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String getKey() {
      return key;
    }

    @SuppressWarnings("unused")
    private void setKey(String key) {
      this.key = key;
    }
  }

  @Test(expectedExceptions = DynamoDBMappingException.class)
  public void testPrivateKeySetter() throws Exception {
    DynamoDBMapper util = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    util.save(new PrivateKeySetter());
  }

  /*
   * To trigger this error, we need for a service object to be present, so
   * we'll insert one manually.
   */
  @Test(expectedExceptions = DynamoDBMappingException.class)
  public void testPrivateKeySetterLoad() throws Exception {
    Map<String, AttributeValue> attr = new HashMap<String, AttributeValue>();
    attr.put(KEY_NAME, new AttributeValue().withS("abc"));
    dynamo.putItem(
      new PutItemRequest().withTableName(TABLE_NAME).withItem(attr)
    );
    DynamoDBMapper util = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    util.load(PrivateKeySetter.class, "abc");
  }

  @DynamoDBTable(tableName = TABLE_NAME)
  public static class PrivateSetter {

    private String key;
    private String StringProperty;

    @DynamoDBHashKey
    public String getKey() {
      return key;
    }

    public void setKey(String key) {
      this.key = key;
    }

    public String getStringProperty() {
      return StringProperty;
    }

    private void setStringProperty(String stringProperty) {
      StringProperty = stringProperty;
    }
  }

  @Test(expectedExceptions = DynamoDBMappingException.class)
  public void testPrivateSetterLoad() throws Exception {
    DynamoDBMapper util = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    PrivateSetter object = new PrivateSetter();
    object.setStringProperty("value");
    util.save(object);
    util.load(PrivateSetter.class, object.getKey());
  }

  @DynamoDBTable(tableName = TABLE_NAME)
  public static class OverloadedSetter {

    private String key;
    private String attribute;

    @DynamoDBHashKey
    public String getKey() {
      return key;
    }

    public void setKey(String key) {
      this.key = key;
    }

    public String getAttribute() {
      return attribute;
    }

    public void setAttribute(String attribute, String unused) {
      this.attribute = attribute;
    }
  }

  @Test(expectedExceptions = DynamoDBMappingException.class)
  public void testOverloadedSetter() {
    OverloadedSetter obj = new OverloadedSetter();
    obj.setKey("" + startKey++);
    obj.setAttribute("abc", "123");
    DynamoDBMapper mapper = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    mapper.save(obj);

    mapper.load(OverloadedSetter.class, obj.getKey());
  }

  @DynamoDBTable(tableName = TABLE_NAME)
  public static class WrongTypeForSetter {

    private String key;
    private String attribute;

    @DynamoDBHashKey
    public String getKey() {
      return key;
    }

    public void setKey(String key) {
      this.key = key;
    }

    public String getAttribute() {
      return attribute;
    }

    public void setAttribute(Integer attribute) {
      this.attribute = String.valueOf(attribute);
    }
  }

  @Test(expectedExceptions = DynamoDBMappingException.class)
  public void testWrongTypeForSetter() {
    WrongTypeForSetter obj = new WrongTypeForSetter();
    obj.setKey("" + startKey++);
    obj.setAttribute(123);
    DynamoDBMapper mapper = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    mapper.save(obj);

    mapper.load(WrongTypeForSetter.class, obj.getKey());
  }

  @DynamoDBTable(tableName = TABLE_NAME)
  public static class NumericFields {

    private String key;
    private Integer integerProperty;

    @DynamoDBHashKey
    public String getKey() {
      return key;
    }

    public void setKey(String key) {
      this.key = key;
    }

    public Integer getIntegerProperty() {
      return integerProperty;
    }

    public void setIntegerProperty(Integer integerProperty) {
      this.integerProperty = integerProperty;
    }
  }

  @Test(expectedExceptions = DynamoDBMappingException.class)
  public void testWrongDataType() {
    Map<String, AttributeValue> attr = new HashMap<String, AttributeValue>();
    attr.put("integerProperty", new AttributeValue().withS("abc"));
    attr.put(KEY_NAME, new AttributeValue().withS("" + startKey++));
    dynamo.putItem(
      new PutItemRequest().withTableName(TABLE_NAME).withItem(attr)
    );
    DynamoDBMapper util = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    util.load(NumericFields.class, attr.get(KEY_NAME).getS());
  }

  @Test(expectedExceptions = DynamoDBMappingException.class)
  public void testWrongDataType2() {
    Map<String, AttributeValue> attr = new HashMap<String, AttributeValue>();
    attr.put("integerProperty", new AttributeValue().withNS("1", "2", "3"));
    attr.put(KEY_NAME, new AttributeValue().withS("" + startKey++));
    dynamo.putItem(
      new PutItemRequest().withTableName(TABLE_NAME).withItem(attr)
    );
    DynamoDBMapper util = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    util.load(NumericFields.class, attr.get(KEY_NAME).getS());
  }

  @DynamoDBTable(tableName = TABLE_NAME)
  public static class ComplexType {

    public String key;
    public ComplexType type;

    public ComplexType(String key, ComplexType type) {
      super();
      this.key = key;
      this.type = type;
    }

    @DynamoDBHashKey
    public String getKey() {
      return key;
    }

    public void setKey(String key) {
      this.key = key;
    }

    public ComplexType getType() {
      return type;
    }

    public void setType(ComplexType type) {
      this.type = type;
    }
  }

  @Test(expectedExceptions = DynamoDBMappingException.class)
  public void testComplexTypeFailure() {
    ComplexType complexType = new ComplexType(
      "" + startKey++,
      new ComplexType("" + startKey++, null)
    );
    DynamoDBMapper util = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    util.save(complexType);
  }

  @DynamoDBTable(tableName = TABLE_NAME)
  public static class ComplexHashKeyType {

    private ComplexType key;
    private String attribute;

    @DynamoDBHashKey
    public ComplexType getKey() {
      return key;
    }

    public void setKey(ComplexType key) {
      this.key = key;
    }

    public String getAttribute() {
      return attribute;
    }

    public void setAttribute(String attribute) {
      this.attribute = attribute;
    }
  }

  @Test(expectedExceptions = DynamoDBMappingException.class)
  public void testUnsupportedHashKeyType() {
    ComplexType complexType = new ComplexType(
      "" + startKey++,
      new ComplexType("" + startKey++, null)
    );
    ComplexHashKeyType obj = new ComplexHashKeyType();
    obj.setKey(complexType);
    obj.setAttribute("abc");
    DynamoDBMapper util = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    util.save(obj);
  }

  @DynamoDBTable(tableName = TABLE_NAME)
  public static class NonSetCollectionType {

    private String key;
    private List<String> badlyMapped;

    @DynamoDBHashKey
    public String getKey() {
      return key;
    }

    public void setKey(String key) {
      this.key = key;
    }

    public List<String> getBadlyMapped() {
      return badlyMapped;
    }

    public void setBadlyMapped(List<String> badlyMapped) {
      this.badlyMapped = badlyMapped;
    }
  }

  @Test
  public void testNonSetCollection() {
    NonSetCollectionType obj = new NonSetCollectionType();
    obj.setKey("" + startKey++);
    obj.setBadlyMapped(new ArrayList<String>());
    obj.getBadlyMapped().add("abc");
    DynamoDBMapper mapper = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    mapper.save(obj);
  }

  @DynamoDBTable(tableName = TABLE_NAME)
  public static class FractionalVersionAttribute {

    private String key;
    private Double version;

    @DynamoDBHashKey
    public String getKey() {
      return key;
    }

    public void setKey(String key) {
      this.key = key;
    }

    @DynamoDBVersionAttribute
    public Double getVersion() {
      return version;
    }

    public void setVersion(Double version) {
      this.version = version;
    }
  }

  @Test(expectedExceptions = DynamoDBMappingException.class)
  public void testFractionalVersionAttribute() {
    FractionalVersionAttribute obj = new FractionalVersionAttribute();
    obj.setKey("" + startKey++);
    obj.setVersion(0d);
    DynamoDBMapper mapper = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    mapper.save(obj);
  }

  @DynamoDBTable(tableName = TABLE_NAME)
  public static class AutoGeneratedIntegerKey {

    private Integer key;
    private String value;

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public Integer getKey() {
      return key;
    }

    public void setKey(Integer key) {
      this.key = key;
    }

    public String getValue() {
      return value;
    }

    public void setValue(String value) {
      this.value = value;
    }
  }

  @Test(expectedExceptions = DynamoDBMappingException.class)
  public void testAutoGeneratedIntegerHashKey() {
    AutoGeneratedIntegerKey obj = new AutoGeneratedIntegerKey();
    obj.setValue("fdgfdsgf");
    DynamoDBMapper mapper = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    mapper.save(obj);
  }

  @DynamoDBTable(tableName = TABLE_NAME)
  public static class AutoGeneratedIntegerRangeKey {

    private String key;
    private Integer rangekey;
    private String value;

    @DynamoDBHashKey
    public String getKey() {
      return key;
    }

    public void setKey(String key) {
      this.key = key;
    }

    @DynamoDBAutoGeneratedKey
    @DynamoDBRangeKey
    public Integer getRangekey() {
      return rangekey;
    }

    public void setRangekey(Integer rangekey) {
      this.rangekey = rangekey;
    }

    public String getValue() {
      return value;
    }

    public void setValue(String value) {
      this.value = value;
    }
  }

  @Test(expectedExceptions = DynamoDBMappingException.class)
  public void testAutoGeneratedIntegerRangeKey() {
    AutoGeneratedIntegerRangeKey obj = new AutoGeneratedIntegerRangeKey();
    obj.setKey("Bldadsfa");
    obj.setValue("fdgfdsgf");
    DynamoDBMapper mapper = TestDynamoDBMapperFactory.createDynamoDBMapper(
      dynamo
    );
    mapper.save(obj);
  }
}
