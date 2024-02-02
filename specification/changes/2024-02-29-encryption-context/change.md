[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Richer Encryption Context

## Summary

A new "version 2" record format will be introduced, to provide a better encryption context experience.

In version 1 records, the values in the encryption context are somewhat obfuscated, e.g. `AAFrZXk=` instead of `key`,
which makes it difficult to use in a KMS Key Policy, and difficult for humans to inspect.
In a version 2 record, if the corresponding attribute value is a string,
then the encryption context value for that attribute will be exactly that same string.

In version 1 records, the only field values stored in the encryption context are
the table's primary partition and sort keys.
As the encryption context is the only input to the Branch Key Selector,
this limits the Branch Key Selector to only those two fields.
In a version 2 record, a customer can designate additional fields to be included
in the encryption context,
and therefore available to the Branch Key Selector.

## Customer Facing Changes

A fourth Crypto Action will be made available : `SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT`, to join the existing `DO_NOTHING`, `SIGN_ONLY` and `ENCRYPT_AND_SIGN`.

The presence of any SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT attribute in the configuration
will cause a version 2 record to be written. 

If any SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT attribute is configured,
then the primary partition and sort keys must also be SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.

In such a case, all SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT attributes will be available to the Branch Key Selector,
and the values of the attributes in the encryption context will be human readable. Specifically :
| Type | attribute value | encryption context value |
| ----------- | ----------- | ----------- |
| String | "abc" | "abc" |
| Number | "123" | "123" |
| Null |  | "null" |
| Boolean | true | "true" |
| Boolean | false | "false" |
| Anything else | n/a | the version 1 value, looking something like "AAFrZXk=" |

Note that the values presented to the Branch Key Selector were always, and still are, DynamoDB AttributeValues.
The changes in encryption context values refer to the raw encryption context.