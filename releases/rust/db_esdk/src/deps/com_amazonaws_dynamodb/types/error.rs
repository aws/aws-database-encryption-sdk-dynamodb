// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[derive(::std::clone::Clone, ::std::fmt::Debug, ::std::cmp::PartialEq)]
pub enum Error {
    ProvisionedThroughputExceededException {
        error: aws_sdk_dynamodb::types::error::ProvisionedThroughputExceededException,
    },

    TableAlreadyExistsException {
        error: aws_sdk_dynamodb::types::error::TableAlreadyExistsException,
    },

    InternalServerError {
        error: aws_sdk_dynamodb::types::error::InternalServerError,
    },

    ReplicaNotFoundException {
        error: aws_sdk_dynamodb::types::error::ReplicaNotFoundException,
    },

    GlobalTableNotFoundException {
        error: aws_sdk_dynamodb::types::error::GlobalTableNotFoundException,
    },

    BackupNotFoundException {
        error: aws_sdk_dynamodb::types::error::BackupNotFoundException,
    },

    ImportNotFoundException {
        error: aws_sdk_dynamodb::types::error::ImportNotFoundException,
    },

    TableNotFoundException {
        error: aws_sdk_dynamodb::types::error::TableNotFoundException,
    },

    InvalidRestoreTimeException {
        error: aws_sdk_dynamodb::types::error::InvalidRestoreTimeException,
    },

    ConditionalCheckFailedException {
        error: aws_sdk_dynamodb::types::error::ConditionalCheckFailedException,
    },

    DuplicateItemException {
        error: aws_sdk_dynamodb::types::error::DuplicateItemException,
    },

    TableInUseException {
        error: aws_sdk_dynamodb::types::error::TableInUseException,
    },

    InvalidExportTimeException {
        error: aws_sdk_dynamodb::types::error::InvalidExportTimeException,
    },

    ImportConflictException {
        error: aws_sdk_dynamodb::types::error::ImportConflictException,
    },

    ReplicaAlreadyExistsException {
        error: aws_sdk_dynamodb::types::error::ReplicaAlreadyExistsException,
    },

    ContinuousBackupsUnavailableException {
        error: aws_sdk_dynamodb::types::error::ContinuousBackupsUnavailableException,
    },

    IdempotentParameterMismatchException {
        error: aws_sdk_dynamodb::types::error::IdempotentParameterMismatchException,
    },

    ExportNotFoundException {
        error: aws_sdk_dynamodb::types::error::ExportNotFoundException,
    },

    RequestLimitExceeded {
        error: aws_sdk_dynamodb::types::error::RequestLimitExceeded,
    },

    ResourceNotFoundException {
        error: aws_sdk_dynamodb::types::error::ResourceNotFoundException,
    },

    GlobalTableAlreadyExistsException {
        error: aws_sdk_dynamodb::types::error::GlobalTableAlreadyExistsException,
    },

    LimitExceededException {
        error: aws_sdk_dynamodb::types::error::LimitExceededException,
    },

    ResourceInUseException {
        error: aws_sdk_dynamodb::types::error::ResourceInUseException,
    },

    BackupInUseException {
        error: aws_sdk_dynamodb::types::error::BackupInUseException,
    },

    PointInTimeRecoveryUnavailableException {
        error: aws_sdk_dynamodb::types::error::PointInTimeRecoveryUnavailableException,
    },

    TransactionCanceledException {
        error: aws_sdk_dynamodb::types::error::TransactionCanceledException,
    },

    TransactionConflictException {
        error: aws_sdk_dynamodb::types::error::TransactionConflictException,
    },

    ItemCollectionSizeLimitExceededException {
        error: aws_sdk_dynamodb::types::error::ItemCollectionSizeLimitExceededException,
    },

    InvalidEndpointException {
        error: aws_sdk_dynamodb::types::error::InvalidEndpointException,
    },

    TransactionInProgressException {
        error: aws_sdk_dynamodb::types::error::TransactionInProgressException,
    },

    ExportConflictException {
        error: aws_sdk_dynamodb::types::error::ExportConflictException,
    },

    IndexNotFoundException {
        error: aws_sdk_dynamodb::types::error::IndexNotFoundException,
    },
    Opaque {
        obj: ::dafny_runtime::Object<dyn ::std::any::Any>,
    },
}

impl ::std::cmp::Eq for Error {}

impl ::std::fmt::Display for Error {
    fn fmt(&self, f: &mut ::std::fmt::Formatter) -> ::std::fmt::Result {
        write!(f, "{:?}", self)
    }
}

impl ::std::error::Error for Error {}
