import boto3

class WaitingLocalDynamoClient:
    """
    boto3 DynamoDB client wrapper that wraps `create_table` and `delete_table` methods
    and connects to localhost:8000.
    If these methods are called on this client, they will block returning until
        the table is created/deleted.
    This is the expected behavior of SDK clients in our Dafny code.
    All other methods besides these are unchanged and will call the boto3 client directly.
    """
    def __init__(self):
        self._client = boto3.client("dynamodb", endpoint_url="http://localhost:8000")
            
    def __getattr__(self, name):
        if hasattr(self._client, name):
            print(f'calling underlyign client {name=}')
            original_method = getattr(self._client, name)

            if name == 'create_table':
                return self._create_table_with_wait(original_method)
            elif name == 'delete_table':
                return self._delete_table_with_wait(original_method)

            return original_method

        raise AttributeError(f"'{type(self).__name__}' object has no attribute '{name}'")
    
    def _create_table_with_wait(self, create_method):
        def wrapper(*args, **kwargs):
            response = create_method(*args, **kwargs)  # Call the original create_table method
            table_name = kwargs.get('TableName')
            print(f"Waiting for table '{table_name}' to become active...")
            waiter = self._client.get_waiter('table_exists')
            waiter.wait(TableName=table_name)
            print(f"Table '{table_name}' is now active.")
            return response
        return wrapper

    def _delete_table_with_wait(self, delete_method):
        def wrapper(*args, **kwargs):
            response = delete_method(*args, **kwargs)  # Call the original delete_table method
            table_name = kwargs.get('TableName')
            print(f"Waiting for table '{table_name}' to be deleted...")
            waiter = self._client.get_waiter('table_not_exists')
            waiter.wait(TableName=table_name)
            print(f"Table '{table_name}' has been deleted.")
            return response
        return wrapper