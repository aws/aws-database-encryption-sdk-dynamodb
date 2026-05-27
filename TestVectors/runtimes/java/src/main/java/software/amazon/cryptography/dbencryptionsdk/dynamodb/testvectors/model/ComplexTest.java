// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package software.amazon.cryptography.dbencryptionsdk.dynamodb.testvectors.model;

import java.util.Collections;
import java.util.List;

/**
 * A complex test definition containing a config name, a list of complex queries,
 * and a list of failure queries.
 */
public class ComplexTest {

  private final String config;
  private final List<ComplexQuery> queries;
  private final List<SimpleQuery> failures;

  public ComplexTest(
    String config,
    List<ComplexQuery> queries,
    List<SimpleQuery> failures
  ) {
    this.config = config;
    this.queries =
      queries != null
        ? Collections.unmodifiableList(queries)
        : Collections.<ComplexQuery>emptyList();
    this.failures =
      failures != null
        ? Collections.unmodifiableList(failures)
        : Collections.<SimpleQuery>emptyList();
  }

  public String getConfig() {
    return config;
  }

  public List<ComplexQuery> getQueries() {
    return queries;
  }

  public List<SimpleQuery> getFailures() {
    return failures;
  }

  @Override
  public String toString() {
    return (
      "ComplexTest{config='" +
      config +
      "', queries=" +
      queries +
      ", failures=" +
      failures +
      "}"
    );
  }
}
