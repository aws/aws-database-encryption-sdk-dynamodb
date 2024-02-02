[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Database Encryption SDK

## Background

The existing encryption context for the Database Encryption SDK is difficult to use in two ways.

1. The values are somewhat obfuscated, e.g. `AAFrZXk=` instead of `key`,
which makes it difficult to use in a KMS Key Policy, and difficult for humans to inspect.

1. The encryption context feeds directly into the Branch Key Selector function,
providing access to the primary partition and sort keys.
For some customers, other fields might be necessary for proper branch key selection.

