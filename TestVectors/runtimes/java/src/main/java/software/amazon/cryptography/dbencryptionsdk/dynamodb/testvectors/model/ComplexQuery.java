// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package software.amazon.cryptography.dbencryptionsdk.dynamodb.testvectors.model;

import java.util.Collections;
import java.util.List;

/**
 * A complex query definition containing a simple query, a list of config names
 * that should pass, and a list of config names that should fail.
 */
public class ComplexQuery {

    private final SimpleQuery query;
    private final List<String> pass;
    private final List<String> fail;

    public ComplexQuery(SimpleQuery query, List<String> pass, List<String> fail) {
        this.query = query;
        this.pass = pass != null ? Collections.unmodifiableList(pass) : Collections.<String>emptyList();
        this.fail = fail != null ? Collections.unmodifiableList(fail) : Collections.<String>emptyList();
    }

    public SimpleQuery getQuery() {
        return query;
    }

    public List<String> getPass() {
        return pass;
    }

    public List<String> getFail() {
        return fail;
    }

    @Override
    public String toString() {
        return "ComplexQuery{query=" + query + ", pass=" + pass + ", fail=" + fail + "}";
    }
}
