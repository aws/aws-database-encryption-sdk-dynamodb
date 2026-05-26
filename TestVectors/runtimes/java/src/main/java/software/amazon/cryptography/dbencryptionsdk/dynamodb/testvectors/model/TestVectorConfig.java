// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package software.amazon.cryptography.dbencryptionsdk.dynamodb.testvectors.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;

/**
 * Aggregate data structure holding all parsed test vector data including records,
 * configs, queries, tests, and string ordering data.
 */
public class TestVectorConfig {

    private List<Record> globalRecords;
    private Map<String, TableConfig> tableEncryptionConfigs;
    private Map<String, TableConfig> largeEncryptionConfigs;
    private List<SimpleQuery> queries;
    private Map<String, String> names;
    private Map<String, AttributeValue> values;
    private List<SimpleQuery> failingQueries;
    private List<ComplexTest> complexTests;
    private List<IoTest> ioTests;
    private List<String[]> configsForIoTest;
    private List<String[]> configsForModTest;
    private List<WriteTest> writeTests;
    private List<RoundTripTest> roundTripTests;
    private List<DecryptTest> decryptTests;
    private List<String> strings;
    private List<LargeRecord> large;
    private CreateTableRequest schemaOnEncrypt;

    public TestVectorConfig() {
        this.globalRecords = new ArrayList<Record>();
        this.tableEncryptionConfigs = new HashMap<String, TableConfig>();
        this.largeEncryptionConfigs = new HashMap<String, TableConfig>();
        this.queries = new ArrayList<SimpleQuery>();
        this.names = new HashMap<String, String>();
        this.values = new HashMap<String, AttributeValue>();
        this.failingQueries = new ArrayList<SimpleQuery>();
        this.complexTests = new ArrayList<ComplexTest>();
        this.ioTests = new ArrayList<IoTest>();
        this.configsForIoTest = new ArrayList<String[]>();
        this.configsForModTest = new ArrayList<String[]>();
        this.writeTests = new ArrayList<WriteTest>();
        this.roundTripTests = new ArrayList<RoundTripTest>();
        this.decryptTests = new ArrayList<DecryptTest>();
        this.strings = new ArrayList<String>();
        this.large = new ArrayList<LargeRecord>();
    }

    public List<Record> getGlobalRecords() {
        return globalRecords;
    }

    public void setGlobalRecords(List<Record> globalRecords) {
        this.globalRecords = globalRecords;
    }

    public Map<String, TableConfig> getTableEncryptionConfigs() {
        return tableEncryptionConfigs;
    }

    public void setTableEncryptionConfigs(Map<String, TableConfig> tableEncryptionConfigs) {
        this.tableEncryptionConfigs = tableEncryptionConfigs;
    }

    public Map<String, TableConfig> getLargeEncryptionConfigs() {
        return largeEncryptionConfigs;
    }

    public void setLargeEncryptionConfigs(Map<String, TableConfig> largeEncryptionConfigs) {
        this.largeEncryptionConfigs = largeEncryptionConfigs;
    }

    public List<SimpleQuery> getQueries() {
        return queries;
    }

    public void setQueries(List<SimpleQuery> queries) {
        this.queries = queries;
    }

    public Map<String, String> getNames() {
        return names;
    }

    public void setNames(Map<String, String> names) {
        this.names = names;
    }

    public Map<String, AttributeValue> getValues() {
        return values;
    }

    public void setValues(Map<String, AttributeValue> values) {
        this.values = values;
    }

    public List<SimpleQuery> getFailingQueries() {
        return failingQueries;
    }

    public void setFailingQueries(List<SimpleQuery> failingQueries) {
        this.failingQueries = failingQueries;
    }

    public List<ComplexTest> getComplexTests() {
        return complexTests;
    }

    public void setComplexTests(List<ComplexTest> complexTests) {
        this.complexTests = complexTests;
    }

    public List<IoTest> getIoTests() {
        return ioTests;
    }

    public void setIoTests(List<IoTest> ioTests) {
        this.ioTests = ioTests;
    }

    public List<String[]> getConfigsForIoTest() {
        return configsForIoTest;
    }

    public void setConfigsForIoTest(List<String[]> configsForIoTest) {
        this.configsForIoTest = configsForIoTest;
    }

    public List<String[]> getConfigsForModTest() {
        return configsForModTest;
    }

    public void setConfigsForModTest(List<String[]> configsForModTest) {
        this.configsForModTest = configsForModTest;
    }

    public List<WriteTest> getWriteTests() {
        return writeTests;
    }

    public void setWriteTests(List<WriteTest> writeTests) {
        this.writeTests = writeTests;
    }

    public List<RoundTripTest> getRoundTripTests() {
        return roundTripTests;
    }

    public void setRoundTripTests(List<RoundTripTest> roundTripTests) {
        this.roundTripTests = roundTripTests;
    }

    public List<DecryptTest> getDecryptTests() {
        return decryptTests;
    }

    public void setDecryptTests(List<DecryptTest> decryptTests) {
        this.decryptTests = decryptTests;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public List<LargeRecord> getLarge() {
        return large;
    }

    public void setLarge(List<LargeRecord> large) {
        this.large = large;
    }

    public CreateTableRequest getSchemaOnEncrypt() {
        return schemaOnEncrypt;
    }

    public void setSchemaOnEncrypt(CreateTableRequest schemaOnEncrypt) {
        this.schemaOnEncrypt = schemaOnEncrypt;
    }

    @Override
    public String toString() {
        return "TestVectorConfig{"
                + "globalRecords=" + globalRecords.size()
                + ", tableEncryptionConfigs=" + tableEncryptionConfigs.size()
                + ", largeEncryptionConfigs=" + largeEncryptionConfigs.size()
                + ", queries=" + queries.size()
                + ", ioTests=" + ioTests.size()
                + ", complexTests=" + complexTests.size()
                + ", writeTests=" + writeTests.size()
                + ", roundTripTests=" + roundTripTests.size()
                + ", decryptTests=" + decryptTests.size()
                + "}";
    }
}
