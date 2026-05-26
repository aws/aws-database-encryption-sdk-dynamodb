// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package software.amazon.cryptography.dbencryptionsdk.dynamodb.testvectors.model;

import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * A large test record consisting of a name and a DynamoDB item, used for performance testing.
 */
public class LargeRecord {

    private final String name;
    private final Map<String, AttributeValue> item;

    public LargeRecord(String name, Map<String, AttributeValue> item) {
        this.name = name;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public Map<String, AttributeValue> getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "LargeRecord{name='" + name + "', item=" + item + "}";
    }
}
