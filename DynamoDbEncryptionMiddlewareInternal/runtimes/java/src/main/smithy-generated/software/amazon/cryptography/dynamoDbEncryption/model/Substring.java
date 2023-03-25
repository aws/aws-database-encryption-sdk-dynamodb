// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dynamoDbEncryption.model;

import java.util.Objects;

public class Substring {
  private final Integer low;

  private final Integer high;

  protected Substring(BuilderImpl builder) {
    this.low = builder.low();
    this.high = builder.high();
  }

  public Integer low() {
    return this.low;
  }

  public Integer high() {
    return this.high;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder low(Integer low);

    Integer low();

    Builder high(Integer high);

    Integer high();

    Substring build();
  }

  static class BuilderImpl implements Builder {
    protected Integer low;

    protected Integer high;

    protected BuilderImpl() {
    }

    protected BuilderImpl(Substring model) {
      this.low = model.low();
      this.high = model.high();
    }

    public Builder low(Integer low) {
      this.low = low;
      return this;
    }

    public Integer low() {
      return this.low;
    }

    public Builder high(Integer high) {
      this.high = high;
      return this;
    }

    public Integer high() {
      return this.high;
    }

    public Substring build() {
      if (Objects.isNull(this.low()))  {
        throw new IllegalArgumentException("Missing value for required field `low`");
      }
      return new Substring(this);
    }
  }
}
