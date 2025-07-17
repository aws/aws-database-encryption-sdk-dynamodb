# Step 0

In Step 0, your system is in the starting state using plaintext DynamoDB operations:

- continue to read plaintext items
- continue to write plaintext items
- cannot read encrypted items

This represents the baseline configuration before beginning the migration process.
Your dataset consists only plaintext data.

When operating in this state, your system has no client-side encryption in place,
and all data is stored in plaintext in your DynamoDB tables.
