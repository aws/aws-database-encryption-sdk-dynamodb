# Step 0

In Step 0, your system is in the starting state using plaintext DynamoDB operations:

- reads items in plaintext format directly from DynamoDB
- writes items in plaintext format directly to DynamoDB
- cannot read items in the AWS Database Encryption SDK format

This represents the baseline configuration before beginning the migration process.
Your dataset consists only of data written in plaintext format.

When operating in this state, your system has no client-side encryption in place,
and all data is stored in plaintext in your DynamoDB tables.
