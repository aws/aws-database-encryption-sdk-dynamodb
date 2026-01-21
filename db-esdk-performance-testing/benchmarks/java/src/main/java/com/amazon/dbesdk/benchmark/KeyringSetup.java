// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package com.amazon.dbesdk.benchmark;

import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.AesWrappingAlg;
import software.amazon.cryptography.materialproviders.model.CreateRawAesKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

import java.security.SecureRandom;
import java.util.Map;

/**
 * Helper class for setting up keyrings for DB-ESDK benchmarks.
 */
public class KeyringSetup {
    
    private static final String RAW_AES_KEYRING = "raw-aes";

    /**
     * Creates a keyring based on the specified type.
     * 
     * @param keyringType The type of keyring to create
     * @return The configured keyring
     * @throws Exception if keyring creation fails
     */
    public static IKeyring createKeyring(String keyringType) throws Exception {
        if (RAW_AES_KEYRING.equals(keyringType)) {
            return createRawAesKeyring();
        } else {
            throw new IllegalArgumentException("Unsupported keyring type: " + keyringType);
        }
    }

    /**
     * Creates a Raw AES keyring with a randomly generated 256-bit key.
     * This matches the Go implementation's keyring setup.
     * 
     * @return Raw AES keyring
     * @throws Exception if keyring creation fails
     */
    private static IKeyring createRawAesKeyring() throws Exception {
        // Initialize Material Providers client
        MaterialProviders matProv = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();

        // Generate a 256-bit (32-byte) random key
        byte[] key = new byte[32];
        new SecureRandom().nextBytes(key);

        // Create Raw AES keyring input
        CreateRawAesKeyringInput keyringInput = CreateRawAesKeyringInput.builder()
                .keyName("test-aes-256-key")
                .keyNamespace("DB-ESDK-performance-test")
                .wrappingKey(key)
                .wrappingAlg(AesWrappingAlg.ALG_AES256_GCM_IV12_TAG16)
                .build();

        // Create and return the keyring
        return matProv.CreateRawAesKeyring(keyringInput);
    }
}
