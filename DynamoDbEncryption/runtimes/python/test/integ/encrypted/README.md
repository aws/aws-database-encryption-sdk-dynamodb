Integration tests for encrypted interfaces.

These integration tests verify that encrypted boto3 interfaces behave as drop-in replacements for plaintext boto3 interfaces.

Each test runs with both a plaintext client and an encrypted client, using the same request parameters and expecting the same response.

This validates that encrypted clients expect the same input shapes as plaintext clients
and encrypted clients return the same output shapes as plaintext clients.

This guarantees that users can substitute encrypted interfaces without modifying their application logic.
