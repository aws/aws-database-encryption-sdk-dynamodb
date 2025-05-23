// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model;

import java.util.List;
import java.util.stream.Collectors;

public class CollectionOfErrors extends RuntimeException {

  /**
   * The list of Exceptions encountered.
   */
  private final List<RuntimeException> list;

  protected CollectionOfErrors(BuilderImpl builder) {
    super(messageFromBuilder(builder), builder.cause());
    this.list = builder.list();
  }

  private static String messageFromBuilder(Builder builder) {
    if (builder.message() != null) {
      return builder.message();
    }
    if (builder.cause() != null) {
      return builder.cause().getMessage();
    }
    return null;
  }

  /**
   * See {@link Throwable#getMessage()}.
   */
  public String message() {
    return this.getMessage();
  }

  /**
   * See {@link Throwable#getCause()}.
   */
  public Throwable cause() {
    return this.getCause();
  }

  /**
   * @return The list of Exceptions encountered.
   */
  public List<RuntimeException> list() {
    return this.list;
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    /**
     * @param message The detailed message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
     */
    Builder message(String message);

    /**
     * @return The detailed message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
     */
    String message();

    /**
     * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method). (A {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    Builder cause(Throwable cause);

    /**
     * @return The cause (which is saved for later retrieval by the {@link #getCause()} method). (A {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    Throwable cause();

    /**
     * @param list The list of Exceptions encountered.
     */
    Builder list(List<RuntimeException> list);

    /**
     * @return The list of Exceptions encountered.
     */
    List<RuntimeException> list();

    CollectionOfErrors build();
  }

  static class BuilderImpl implements Builder {

    protected String message;

    protected Throwable cause;

    protected List<RuntimeException> list;

    protected BuilderImpl() {}

    protected BuilderImpl(CollectionOfErrors model) {
      this.cause = model.getCause();
      this.message = model.getMessage();
      this.list = model.list();
    }

    public Builder message(String message) {
      this.message = message;
      return this;
    }

    public String message() {
      return this.message;
    }

    public Builder cause(Throwable cause) {
      this.cause = cause;
      return this;
    }

    public Throwable cause() {
      return this.cause;
    }

    public Builder list(List<RuntimeException> list) {
      this.list = list;
      return this;
    }

    public List<RuntimeException> list() {
      return this.list;
    }

    public CollectionOfErrors build() {
      if (!(this.list == null || this.list.isEmpty())) {
        this.message =
          this.message +
          " String representation of Exceptions in list.\n" +
          this.list.stream()
            .map(ex -> ex.getClass().getSimpleName() + ": " + ex.getMessage())
            .collect(Collectors.joining("\n"));
      }
      return new CollectionOfErrors(this);
    }
  }
}
