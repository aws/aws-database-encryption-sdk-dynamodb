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
package com.amazonaws.services.dynamodbv2.mapper.encryption;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

/** Simple domain class with numeric attributes */
@DynamoDBTable(tableName = "aws-java-sdk-util-crypto")
public class NumberSetAttributeTestClass {

  private String key;
  private Set<Integer> integerAttribute;
  private Set<Double> doubleObjectAttribute;
  private Set<Float> floatObjectAttribute;
  private Set<BigDecimal> bigDecimalAttribute;
  private Set<BigInteger> bigIntegerAttribute;
  private Set<Long> longObjectAttribute;
  private Set<Byte> byteObjectAttribute;
  private Set<Date> dateAttribute;
  private Set<Calendar> calendarAttribute;
  private Set<Boolean> booleanAttribute;

  @DynamoDBHashKey
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  @DynamoDBAttribute
  public Set<Integer> getIntegerAttribute() {
    return integerAttribute;
  }

  public void setIntegerAttribute(Set<Integer> integerAttribute) {
    this.integerAttribute = integerAttribute;
  }

  @DynamoDBAttribute
  public Set<Double> getDoubleObjectAttribute() {
    return doubleObjectAttribute;
  }

  public void setDoubleObjectAttribute(Set<Double> doubleObjectAttribute) {
    this.doubleObjectAttribute = doubleObjectAttribute;
  }

  @DynamoDBAttribute
  public Set<Float> getFloatObjectAttribute() {
    return floatObjectAttribute;
  }

  public void setFloatObjectAttribute(Set<Float> floatObjectAttribute) {
    this.floatObjectAttribute = floatObjectAttribute;
  }

  @DynamoDBAttribute
  public Set<BigDecimal> getBigDecimalAttribute() {
    return bigDecimalAttribute;
  }

  public void setBigDecimalAttribute(Set<BigDecimal> bigDecimalAttribute) {
    this.bigDecimalAttribute = bigDecimalAttribute;
  }

  @DynamoDBAttribute
  public Set<BigInteger> getBigIntegerAttribute() {
    return bigIntegerAttribute;
  }

  public void setBigIntegerAttribute(Set<BigInteger> bigIntegerAttribute) {
    this.bigIntegerAttribute = bigIntegerAttribute;
  }

  @DynamoDBAttribute
  public Set<Long> getLongObjectAttribute() {
    return longObjectAttribute;
  }

  public void setLongObjectAttribute(Set<Long> longObjectAttribute) {
    this.longObjectAttribute = longObjectAttribute;
  }

  @DynamoDBAttribute
  public Set<Byte> getByteObjectAttribute() {
    return byteObjectAttribute;
  }

  public void setByteObjectAttribute(Set<Byte> byteObjectAttribute) {
    this.byteObjectAttribute = byteObjectAttribute;
  }

  @DynamoDBAttribute
  public Set<Date> getDateAttribute() {
    return dateAttribute;
  }

  public void setDateAttribute(Set<Date> dateAttribute) {
    this.dateAttribute = dateAttribute;
  }

  @DynamoDBAttribute
  public Set<Calendar> getCalendarAttribute() {
    return calendarAttribute;
  }

  public void setCalendarAttribute(Set<Calendar> calendarAttribute) {
    this.calendarAttribute = calendarAttribute;
  }

  @DynamoDBAttribute
  public Set<Boolean> getBooleanAttribute() {
    return booleanAttribute;
  }

  public void setBooleanAttribute(Set<Boolean> booleanAttribute) {
    this.booleanAttribute = booleanAttribute;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result =
      prime * result +
      ((bigDecimalAttribute == null) ? 0 : bigDecimalAttribute.hashCode());
    result =
      prime * result +
      ((bigIntegerAttribute == null) ? 0 : bigIntegerAttribute.hashCode());
    result =
      prime * result +
      ((booleanAttribute == null) ? 0 : booleanAttribute.hashCode());
    result =
      prime * result +
      ((byteObjectAttribute == null) ? 0 : byteObjectAttribute.hashCode());
    result =
      prime * result +
      ((calendarAttribute == null) ? 0 : calendarAttribute.hashCode());
    result =
      prime * result + ((dateAttribute == null) ? 0 : dateAttribute.hashCode());
    result =
      prime * result +
      ((doubleObjectAttribute == null) ? 0 : doubleObjectAttribute.hashCode());
    result =
      prime * result +
      ((floatObjectAttribute == null) ? 0 : floatObjectAttribute.hashCode());
    result =
      prime * result +
      ((integerAttribute == null) ? 0 : integerAttribute.hashCode());
    result = prime * result + ((key == null) ? 0 : key.hashCode());
    result =
      prime * result +
      ((longObjectAttribute == null) ? 0 : longObjectAttribute.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    NumberSetAttributeTestClass other = (NumberSetAttributeTestClass) obj;
    if (bigDecimalAttribute == null) {
      if (other.bigDecimalAttribute != null) return false;
    } else if (
      !bigDecimalAttribute.equals(other.bigDecimalAttribute)
    ) return false;
    if (bigIntegerAttribute == null) {
      if (other.bigIntegerAttribute != null) return false;
    } else if (
      !bigIntegerAttribute.equals(other.bigIntegerAttribute)
    ) return false;
    if (booleanAttribute == null) {
      if (other.booleanAttribute != null) return false;
    } else if (!booleanAttribute.equals(other.booleanAttribute)) return false;
    if (byteObjectAttribute == null) {
      if (other.byteObjectAttribute != null) return false;
    } else if (
      !byteObjectAttribute.equals(other.byteObjectAttribute)
    ) return false;
    if (calendarAttribute == null) {
      if (other.calendarAttribute != null) return false;
    } else if (!calendarAttribute.equals(other.calendarAttribute)) return false;
    if (dateAttribute == null) {
      if (other.dateAttribute != null) return false;
    } else if (!dateAttribute.equals(other.dateAttribute)) return false;
    if (doubleObjectAttribute == null) {
      if (other.doubleObjectAttribute != null) return false;
    } else if (
      !doubleObjectAttribute.equals(other.doubleObjectAttribute)
    ) return false;
    if (floatObjectAttribute == null) {
      if (other.floatObjectAttribute != null) return false;
    } else if (
      !floatObjectAttribute.equals(other.floatObjectAttribute)
    ) return false;
    if (integerAttribute == null) {
      if (other.integerAttribute != null) return false;
    } else if (!integerAttribute.equals(other.integerAttribute)) return false;
    if (key == null) {
      if (other.key != null) return false;
    } else if (!key.equals(other.key)) return false;
    if (longObjectAttribute == null) {
      if (other.longObjectAttribute != null) return false;
    } else if (
      !longObjectAttribute.equals(other.longObjectAttribute)
    ) return false;
    return true;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "NumberSetAttributeTestClass [key=" + key;
    //        + ", integerAttribute=" + integerAttribute
    //                + ", doubleObjectAttribute=" + doubleObjectAttribute + ",
    // floatObjectAttribute=" + floatObjectAttribute
    //                + ", bigDecimalAttribute=" + bigDecimalAttribute + ", bigIntegerAttribute=" +
    // bigIntegerAttribute
    //                + ", longObjectAttribute=" + longObjectAttribute + ", byteObjectAttribute=" +
    // byteObjectAttribute
    //                + ", dateAttribute=" + dateAttribute + ", calendarAttribute=" +
    // calendarAttribute
    //                + ", booleanAttribute=" + booleanAttribute + "]";
  }
}
