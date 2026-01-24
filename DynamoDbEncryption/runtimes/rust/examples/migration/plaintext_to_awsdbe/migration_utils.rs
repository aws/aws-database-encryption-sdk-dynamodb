// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use aws_sdk_dynamodb::types::AttributeValue;
use std::collections::HashMap;

/*
Utility module for the PlaintextToAWSDBE migration examples.
This module contains shared functionality used by all migration steps.
*/

// Common attribute values used across all migration steps
pub const ENCRYPTED_AND_SIGNED_VALUE: &str = "this will be encrypted and signed";
pub const SIGN_ONLY_VALUE: &str = "this will never be encrypted, but it will be signed";
pub const DO_NOTHING_VALUE: &str = "this will never be encrypted nor signed";

// Verify that a returned item matches the expected values
pub fn verify_returned_item(
    item: &HashMap<String, AttributeValue>,
    partition_key_value: &str,
    sort_key_value: &str,
) -> Result<bool, Box<dyn std::error::Error>> {
    if let Some(AttributeValue::S(pk)) = item.get("partition_key") {
        if pk != partition_key_value {
            return Err(format!(
                "partition_key mismatch: expected {}, got {}",
                partition_key_value, pk
            )
            .into());
        }
    } else {
        return Err("partition_key not found or not a string".into());
    }

    if let Some(AttributeValue::N(sk)) = item.get("sort_key") {
        if sk != sort_key_value {
            return Err(
                format!("sort_key mismatch: expected {}, got {}", sort_key_value, sk).into(),
            );
        }
    } else {
        return Err("sort_key not found or not a number".into());
    }

    if let Some(AttributeValue::S(attr1)) = item.get("attribute1") {
        if attr1 != ENCRYPTED_AND_SIGNED_VALUE {
            return Err(format!(
                "attribute1 mismatch: expected {}, got {}",
                ENCRYPTED_AND_SIGNED_VALUE, attr1
            )
            .into());
        }
    } else {
        return Err("attribute1 not found or not a string".into());
    }

    if let Some(AttributeValue::S(attr2)) = item.get("attribute2") {
        if attr2 != SIGN_ONLY_VALUE {
            return Err(format!(
                "attribute2 mismatch: expected {}, got {}",
                SIGN_ONLY_VALUE, attr2
            )
            .into());
        }
    } else {
        return Err("attribute2 not found or not a string".into());
    }

    if let Some(AttributeValue::S(attr3)) = item.get("attribute3") {
        if attr3 != DO_NOTHING_VALUE {
            return Err(format!(
                "attribute3 mismatch: expected {}, got {}",
                DO_NOTHING_VALUE, attr3
            )
            .into());
        }
    } else {
        return Err("attribute3 not found or not a string".into());
    }

    Ok(true)
}
