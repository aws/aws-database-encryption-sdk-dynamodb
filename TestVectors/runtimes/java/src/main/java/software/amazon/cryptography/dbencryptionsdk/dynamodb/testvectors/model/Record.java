// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package software.amazon.cryptography.dbencryptionsdk.dynamodb.testvectors.model;

import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * A test record consisting of a record number and a DynamoDB item.
 */
public class Record {

    private final int number;
    private final Map<String, AttributeValue> item;

    public Record(int number, Map<String, AttributeValue> item) {
        this.number = number;
        this.item = item;
    }

    public int getNumber() {
        return number;
    }

    public Map<String, AttributeValue> getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Record{number=" + number + ", item=" + item + "}";
    }
}
