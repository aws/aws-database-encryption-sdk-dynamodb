[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Additional Encryption Context

## Motivation

In the current design, the primary hash and sort keys are made available for branch key calculations. This is sufficient for any system specifically designed with branch keys in mind, but may be insufficient for some legacy systems.

For example, imagine two tables : Users and Groups.
Each Group has a primary key of GroupID, which determines the branch key.
Each User has a primary key of UserID, and a non-key field holding the GroupID.
Thus when querying the User table, the GroupID is unavailable to the branch key calculation, and so the proper branch key cannot be determined.

## Goal

Designate some sign-only attributes to be available to customers for branch key calculations, KMS encryption contexts and such.

### Where to handle the additions

#### Option Taken : Add attributes to the encryption context

Advantages include :

- Simple user story
- Tiny change to API

#### Option Not Taken : Pass attributes to the keyring

We could have extended the keyring interface to receive a set of key-value pairs, and then passed all signed attributes to the keyring, which would use that to choose the branch key.

Advantages include :

- This feature is now available to all MPL-based products, not just the DBESDK.

Drawbacks include :

- Versioning the keyring might be costly, especially for customers that already have a custom keyring.
- There is no way to enforce that the values passed in are in some way authenticated.

### Which Attributes to Include

#### Option Taken : Allow the user to configure which signed fields are included

Where the customer used to designate “sign only” they now specify a subset of those to be in the encryption context.

#### Option Not Taken : Include all signed fields

Simplest for the customer, but this could be very large in some cases, and the KMS limit on encryption context size is fairly small.

### Versioning

We need some way, at decrypt time, to know which attributes were used in the encryption context.

To do that, we change the legend in the header. Currently, the legend holds one of two values (encrypted or sign_only) for each signed attribute. To this we must add a third value for SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT, but changing the header format requires us to bump the version number stored in the header.

#### Option Taken : Only write new version if needed

If no SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT attributes are configured, then Encrypt writes a version 1 record, exactly like older versions.

If any SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT attributes are configured, then a version 2 record is written, which has a third possible value in the Legend; thus most customers stay at version 1 and are not impacted. As long as a customer distributes version 3.3 of the DBESDK everywhere before writing the first SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT record, all should be well.

On decrypt, the version number and legend are examined to determine which fields are ENCRYPT_AND_SIGN, SIGN_ONLY OR SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT. As with version 1, the encrypt configuration and decrypt configuration must agree on which fields in the record are DO_NOTHING; otherwise the record will fail to decrypt.

#### Option Not Taken : Always write new version

Once we support version 2, we always write version 2. The downside to this is the usual two-phase update problem; that is, if one part of a customers system is updated, and starts writing version 2 records, then other parts of their system, not yet updated, will be unable to read them.

### Cryptographic action for primary keys

Currently, the primary hash and sort keys must be SIGN_ONLY, even though they behave as SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT. Going forward, the primary keys must continue to have the SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT functionality.

#### Option Taken - If any attributes are marked SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT then primary keys must also be SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT

This keeps a consistent meaning for all the CryptoActions, while not requiring a version2 header for customers not using the new feature.

#### Option Not Taken - Primary keys MUST still be SIGN_ONLY

When customers adopt SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT, they don’t need to update their primary keys; however, this means that SIGN_ONLY sometimes means SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT leading to confusion

#### Option Not Taken - Primary keys can be either SIGN_ONLY or SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT

Even easier on customers, as they can change or not, but this still means that SIGN_ONLY sometimes means SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT leading to confusion

### Where to calculate the new encryption context entries?

Currently, we generate the encryption context in the Item Encryptor, but only the Structure Encryptor has access to the header and its legend.

#### Option Taken - Structure Encryptor

On Decrypt, the Structure Encryptor has the necessary context to determine which attributes were used in the encryption context.

On encrypt, the Structure Encryptor adds to the required encryption context any attributes marked as SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.

On decrypt, the Structure Encryptor examines the legend in the header to determine which fields were SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT, and performs the same operation as in encrypt.

#### Option Not Taken - Item Encryptor

This would be simplest for Encrypt, as we already generate the encryption context in the Item Encryptor and pass it into the Structure Encryptor. Unfortunately, on Decrypt things are more complex, and we need to parse the header to find out which attributes were used in the encryption context. Trying to do this in the Item Encryptor would require too much back and forth across the Item/Structure boundary.

# User Friendly Encryption Context

## Background

In the DBESDK, we include the values of the primary hash and sort keys in the encryption context. We serialize the AttributeValue into a a sequence of bytes (as per StructuredEncryption) and then Base64 encode the result.
Thus the string “key” is in the encryption context as “AAFrZXk=”.

This is problematic in a number of ways

- A customer looking around trying to figure out what is going on does not see anything helpful. Further, since we don’t surface the deserialization logic, there is no way for them to turn “AAFrZXk=” back into “key”.
- There is no straightforward way to use these values as part of a KMS key policy, which would be a valuable tool for customers.

It would be nice to simply store “key”, but that has issues.

The branch key selector function takes a map of AttributeName to AttributeValue. Thus we need to recreate the type of the value. If we see the value “123” is that a string or a number? If we see the string “AAFrZXk=”, is that a literal string or the base64 encoding of something else?

Further, we can’t ameliorate this with something in the config file, or even the encrypted record’s version number, because the only input to the branch key selector function is the encryption context.

### Option Taken - plain strings, plus a legend

In the version 2 records, add a new entry to the encryption context : aws-crypto-legend. Much like the legend in the StructuredEncryption header, this holds one character per attribute in the encryption context. Sort the keys in the encryption context and the values in the legend are in that same order.

The value in the legend tells us how to interpret the string values in the EC.

- S - a string
- N - a number
- L - a literal : true, false or null
- B - everything else. All Map, List, Set and Binary types will continue to be encoded exactly as they are now. Thus they will still be ugly to look at, and difficult to use in KMS policies.

The addition of the legend adds a few bytes (17 + 1 per attribute), but strings and numbers stored this way take up less space as they don’t have to pay the overhead of our serialization format and base64 encoding (e.g. “key” which will drop from 8 characters to 3).

Whenever we generate an encryption context, we know what record version we’re dealing with. In the selector, we can trigger on the existence of the legend field.

If a customer wants this new functionality, they can simply change their primary hash and sort keys to SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.

### Option Not Taken : DynamoDB's JSON syntax

We could do without the legend if we used the DynamoDB JSON syntax for values. Thus key would become {”S“ : ”key“}

This has the advantage of simplicity, and is more user friendly then the current AAFrZXk= situation, but it has drawbacks.

- Whitespace is meaningless in JSON, but would be significant to a key policy, leading to confusion.
- A key policy referring directly to {”S“ : ”key“} is still a suboptimal user experience
- This would increase the size of the encryption context. Eventually somebody’s going to bump up against the 4K barrier for encryption contexts in KMS.

### Option Not Taken - Change interface to branch key selector

If this took a map of string to string, instead of an AttributeMap, then it would be ok to lose the type information. Unfortunately, this would break all the customers currently using one.

### Option Not Taken - Change interface to branch key selector for version 2 records

The place where we construct the branchKeyIdSupplier, we don’t know the version. Once we know the version, we’ve lost the knowledge of which supplier we are using.

### Option Not Taken - Deduce the type

Skip the legend. If it looks like a number or a literal, that’s what it is. If it ends with a ‘=’ it’s binary, otherwise it’s a string.
This would work 99% of the time, but we need 100%.

### Option Not Taken - Pass in everything as a string

We could store everything in this new way, but don’t keep the legend. Then wrap everything up as an AttributeValue of type String.
Any customer with a binary key would be out of luck entirely.
Any customer that actually cares about the difference between String(123) and Number(123) would also be sad.

Add type information to the config for every SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT attribute.
This would be great, except that the branch key selector doesn’t have access to the config.
