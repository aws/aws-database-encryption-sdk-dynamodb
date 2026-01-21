// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package com.amazon.dbesdk.benchmark;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * Utility functions for benchmark operations.
 */
public class Utils {
    
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Calculates the average of a list of double values.
     */
    public static double average(List<Double> values) {
        if (values.isEmpty()) {
            return 0.0;
        }
        return values.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    /**
     * Calculates the average of an array of double values.
     */
    public static double average(double[] values) {
        if (values.length == 0) {
            return 0.0;
        }
        return Arrays.stream(values).average().orElse(0.0);
    }

    /**
     * Calculates the specified percentile from a sorted array of values.
     * 
     * @param sortedValues Sorted array of values
     * @param percentile Percentile to calculate (0.0 to 1.0)
     * @return The percentile value
     */
    public static double percentile(double[] sortedValues, double percentile) {
        if (sortedValues.length == 0) {
            return 0.0;
        }
        if (percentile <= 0.0) {
            return sortedValues[0];
        }
        if (percentile >= 1.0) {
            return sortedValues[sortedValues.length - 1];
        }

        double index = percentile * (sortedValues.length - 1);
        int lower = (int) Math.floor(index);
        int upper = (int) Math.ceil(index);

        if (lower == upper) {
            return sortedValues[lower];
        }

        double weight = index - lower;
        return sortedValues[lower] * (1 - weight) + sortedValues[upper] * weight;
    }

    /**
     * Generates random test data of specified size.
     * 
     * @param size Size in bytes
     * @return Random byte array
     */
    public static byte[] generateTestData(int size) {
        byte[] data = new byte[size];
        RANDOM.nextBytes(data);
        return data;
    }

    /**
     * Gets the current timestamp in the format used by the Go implementation.
     */
    public static String getCurrentTimestamp() {
        return LocalDateTime.now().format(TIMESTAMP_FORMAT);
    }

    /**
     * Gets the Java version string.
     */
    public static String getJavaVersion() {
        return System.getProperty("java.version");
    }

    /**
     * Gets the number of available CPU cores.
     */
    public static int getCpuCount() {
        return Runtime.getRuntime().availableProcessors();
    }

    /**
     * Gets the total system memory in GB.
     */
    public static double getTotalMemoryGb() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        long maxMemory = memoryMXBean.getHeapMemoryUsage().getMax();
        if (maxMemory == -1) {
            // If max heap is not set, use the current committed memory as approximation
            maxMemory = memoryMXBean.getHeapMemoryUsage().getCommitted();
        }
        return maxMemory / (1024.0 * 1024.0 * 1024.0);
    }

    /**
     * Gets the current memory usage in MB.
     */
    public static double getCurrentMemoryUsageMb() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        long usedMemory = memoryMXBean.getHeapMemoryUsage().getUsed();
        return usedMemory / (1024.0 * 1024.0);
    }

    /**
     * Forces garbage collection and waits a short time for it to settle.
     */
    public static void forceGcAndWait() {
        System.gc();
        try {
            Thread.sleep(5); // 5ms settle time, matching Go's GCSettleTimeMs
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Converts milliseconds to seconds.
     */
    public static double msToSeconds(double milliseconds) {
        return milliseconds / 1000.0;
    }

    /**
     * Converts nanoseconds to milliseconds.
     */
    public static double nanosToMillis(long nanoseconds) {
        return nanoseconds / 1_000_000.0;
    }

    /**
     * Checks if a test type should be run based on quick config test types.
     * 
     * @param testType The test type to check
     * @param allowedTypes List of allowed test types (null means all are allowed)
     * @return true if the test should run
     */
    public static boolean shouldRunTestType(String testType, List<String> allowedTypes) {
        if (allowedTypes == null || allowedTypes.isEmpty()) {
            return true;
        }
        return allowedTypes.contains(testType);
    }

    /**
     * Formats a double value to 2 decimal places.
     */
    public static String formatDouble(double value) {
        return String.format("%.2f", value);
    }

    /**
     * Formats bytes per second to a human-readable format.
     */
    public static String formatBytesPerSecond(double bytesPerSecond) {
        if (bytesPerSecond >= 1_000_000_000) {
            return String.format("%.2f GB/sec", bytesPerSecond / 1_000_000_000);
        } else if (bytesPerSecond >= 1_000_000) {
            return String.format("%.2f MB/sec", bytesPerSecond / 1_000_000);
        } else if (bytesPerSecond >= 1_000) {
            return String.format("%.2f KB/sec", bytesPerSecond / 1_000);
        } else {
            return String.format("%.2f B/sec", bytesPerSecond);
        }
    }

    /**
     * Memory sample class for continuous memory monitoring.
     */
    public static class MemorySample {
        private final long timestamp;
        private final double heapMb;
        private final double allocatedMb;

        public MemorySample(long timestamp, double heapMb, double allocatedMb) {
            this.timestamp = timestamp;
            this.heapMb = heapMb;
            this.allocatedMb = allocatedMb;
        }

        public long getTimestamp() { return timestamp; }
        public double getHeapMb() { return heapMb; }
        public double getAllocatedMb() { return allocatedMb; }
    }
}
