from boto3.resources.base import ServiceResource
from boto3.resources.collection import CollectionManager
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    DynamoDbTablesEncryptionConfig,
)

class EncryptedTablesCollectionManager:

    def __init__(
        self,
        collection: CollectionManager,
        encryption_config: DynamoDbTablesEncryptionConfig,
    ):
        self._collection = collection
        self._encryption_config = encryption_config

    # def _transform_table:

class EncryptedResource:
    def __init__(
        self,
        resource: ServiceResource,
        encryption_config: DynamoDbTablesEncryptionConfig,
    ):
        self._resource = resource
        self._encryption_config = DynamoDbTablesEncryptionConfig
    
    def Table(self, name, **kwargs):
        print("EncryptedResource making EncryptedTable")
        table_kwargs = dict(
            table=self._resource.Table(name),
            encryption_config=self._encryption_config
        )

        return EncryptedTable(**table_kwargs)
    
    def __getattr__(self, name):
        print("calling EncryptedResource.__getattr__")
        # Before calling __getattr__, the class will look at its own methods.
        # Any methods defined on the class are called before getting to this point.

        # __getattr__ doesn't find a class' protected methods by default.
        # if name in self._get_protected_methods():
        #     return getattr(self, name)
        # If the class doesn't override a boto3 method, defer to boto3 now.
        if hasattr(self._resource, name):
            return getattr(self._resource, name)
        else:
            raise AttributeError(f"'{self.__class__.__name__}' object has no attribute '{name}'")