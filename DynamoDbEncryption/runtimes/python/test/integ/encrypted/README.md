Integration tests for encrypted interfaces.

These tests assert that the same requests can be passed to a plaintext boto3 interface and an encrypted boto3 interface and receive the same output.
This asserts that the encrypted boto3 interfaces expect the same input shapes and return the same output shapes as plaintext boto3 interfaces.
This guarantees that users can use encrypted interfaces as drop-in replacements for plaintext interfaces.
