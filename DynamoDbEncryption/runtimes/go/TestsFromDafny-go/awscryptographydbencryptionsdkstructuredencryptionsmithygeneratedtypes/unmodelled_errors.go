// Code generated by smithy-go-codegen DO NOT EDIT.

package awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes

import (
	"fmt"
)

type CollectionOfErrors struct {
	StructuredEncryptionBaseException
	ListOfErrors []error
	Message      string
}

func (e CollectionOfErrors) Error() string {
	return fmt.Sprintf("message: %s\n err %v", e.Message, e.ListOfErrors)
}

type OpaqueError struct {
	StructuredEncryptionBaseException
	ErrObject interface{}
}

func (e OpaqueError) Error() string {
	return fmt.Sprintf("message: %v", e.ErrObject)
}
