# Step 0

In Step 0, your system is in the starting state using the legacy DynamoDB Encryption Client:

- reads items in the old format using the DynamoDB Encryption Client
- writes items in the old format using the DynamoDB Encryption Client
- cannot read items in the new AWS Database Encryption SDK format

This represents the baseline configuration before beginning the migration process.
Your dataset consists only of data written in the old format.

When operating in this state, your system is fully dependent on the legacy DynamoDB Encryption Client library
and its associated encryption format.
