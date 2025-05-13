# Python AWS Database Encryption SDK for DynamoDB

[![MPL-python-tests](https://github.com/aws/aws-database-encryption-sdk-dynamodb/actions/workflows/push.yml/badge.svg)](https://github.com/aws/aws-database-encryption-sdk-dynamodb/actions/workflows/push.yml)
[![Code style: black](https://img.shields.io/badge/code_style-black-000000.svg)](https://github.com/ambv/black)
[![Documentation Status](https://readthedocs.org/projects/aws-dbesdk-dynamodb-python/badge/)](https://aws-dbesdk-dynamodb-python.readthedocs.io/en/latest/)

Documentation for the Python AWS Database Encryption SDK for DynamoDB.

The latest full documentation can be found at [Read the Docs](https://aws-dbesdk-dynamodb-python.readthedocs.io/en/latest/).

Find us on [GitHub](https://github.com/aws/aws-database-encryption-sdk-dynamodb).

## Security

If you discover a potential security issue in this project
we ask that you notify AWS/Amazon Security via our
[vulnerability reporting page](http://aws.amazon.com/security/vulnerability-reporting/).
Please **do not** create a public GitHub issue.

## Getting Started

### Required Prerequisites

- Python 3.11+
- aws-cryptographic-material-providers 1.10.0+

### Installation

> **Note:**
> If you have not already installed [cryptography](https://cryptography.io/en/latest/), you might need to install additional prerequisites as
> detailed in the [cryptography installation guide](https://cryptography.io/en/latest/installation/) for your operating system.

```bash
$ pip install aws-dbesdk-dynamodb
```

### Concepts

The AWS Database Encryption SDK for DynamoDB (DBESDK-DynamoDB) is available in multiple languages.
The concepts in the Python implementation of the DBESDK-DynamoDB are the same as in other languages.
For more information on concepts in the DBESDK-DynamoDB, see the [README](https://github.com/aws/aws-database-encryption-sdk-dynamodb/blob/main/README.md) for all languages.

DBESDK-DynamoDB uses cryptographic material providers from the AWS Cryptographic Material Providers Library (MPL).
For more information on the MPL, see its [README](https://github.com/aws/aws-database-encryption-sdk-dynamodb/blob/main/README.md) or [readthedocs](https://aws-cryptographic-material-providers-library.readthedocs.io/en/latest/) page.
