// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.Map;
import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class ResolveAttributesInput {

  /**
   * Use the config for this Table.
   */
  private final String TableName;

  /**
   * The Item to be examined.
   */
  private final Map<String, AttributeValue> Item;

  /**
   * The beacon version to use. Defaults to 'writeVersion'.
   */
  private final Integer Version;

  protected ResolveAttributesInput(BuilderImpl builder) {
    this.TableName = builder.TableName();
    this.Item = builder.Item();
    this.Version = builder.Version();
  }

  /**
   * @return Use the config for this Table.
   */
  public String TableName() {
    return this.TableName;
  }

  /**
   * @return The Item to be examined.
   */
  public Map<String, AttributeValue> Item() {
    return this.Item;
  }

  /**
   * @return The beacon version to use. Defaults to 'writeVersion'.
   */
  public Integer Version() {
    return this.Version;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param TableName Use the config for this Table.
     */
    Builder TableName(String TableName);

    /**
     * @return Use the config for this Table.
     */
    String TableName();

    /**
     * @param Item The Item to be examined.
     */
    Builder Item(Map<String, AttributeValue> Item);

    /**
     * @return The Item to be examined.
     */
    Map<String, AttributeValue> Item();

    /**
     * @param Version The beacon version to use. Defaults to 'writeVersion'.
     */
    Builder Version(Integer Version);

    /**
     * @return The beacon version to use. Defaults to 'writeVersion'.
     */
    Integer Version();

    ResolveAttributesInput build();
  }

  static class BuilderImpl implements Builder {

    protected String TableName;

    protected Map<String, AttributeValue> Item;

    protected Integer Version;

    protected BuilderImpl() {}

    protected BuilderImpl(ResolveAttributesInput model) {
      this.TableName = model.TableName();
      this.Item = model.Item();
      this.Version = model.Version();
    }

    public Builder TableName(String TableName) {
      this.TableName = TableName;
      return this;
    }

    public String TableName() {
      return this.TableName;
    }

    public Builder Item(Map<String, AttributeValue> Item) {
      this.Item = Item;
      return this;
    }

    public Map<String, AttributeValue> Item() {
      return this.Item;
    }

    public Builder Version(Integer Version) {
      this.Version = Version;
      return this;
    }

    public Integer Version() {
      return this.Version;
    }

    public ResolveAttributesInput build() {
      if (Objects.isNull(this.TableName())) {
        throw new IllegalArgumentException(
          "Missing value for required field `TableName`"
        );
      }
      if (Objects.nonNull(this.TableName()) && this.TableName().length() < 3) {
        throw new IllegalArgumentException(
          "The size of `TableName` must be greater than or equal to 3"
        );
      }
      if (
        Objects.nonNull(this.TableName()) && this.TableName().length() > 255
      ) {
        throw new IllegalArgumentException(
          "The size of `TableName` must be less than or equal to 255"
        );
      }
      if (Objects.isNull(this.Item())) {
        throw new IllegalArgumentException(
          "Missing value for required field `Item`"
        );
      }
      if (Objects.nonNull(this.Version()) && this.Version() < 1) {
        throw new IllegalArgumentException(
          "`Version` must be greater than or equal to 1"
        );
      }
      return new ResolveAttributesInput(this);
    }
  }
}
