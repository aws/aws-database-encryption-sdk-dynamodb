import boto3
from decimal import Decimal
from boto3.dynamodb.conditions import Key, Attr, And, Or, Not

ddb = boto3.resource("dynamodb")
table = ddb.Table("ComplexBeaconTestTable")

sdk_input = {'IndexName': 'GSI-1', 'FilterExpression': '#n0 > :v0', 'KeyConditionExpression': '( #n1 = :v1 AND #n2 BETWEEN :v2 AND :v3 )', 'ExpressionAttributeNames': {'#n1': 'aws_dbe_b_PK1', '#n2': 'aws_dbe_b_SK1', '#n0': 'Duration'}, 'ExpressionAttributeValues': {':v0': Decimal('0'), ':v1': 'EE-c', ':v3': 'MS-2022-07-08', ':v2': 'MS-2022-07-02'}}
my_input = {'IndexName': 'GSI-1', 'FilterExpression': Attr("Duration").gt("0"), 'KeyConditionExpression': '( #n1 = :v1 AND #n2 BETWEEN :v2 AND :v3 )', 'ExpressionAttributeNames': {'#n1': 'aws_dbe_b_PK1', '#n2': 'aws_dbe_b_SK1'}, 'ExpressionAttributeValues': {':v1': 'EE-c', ':v3': 'MS-2022-07-08', ':v2': 'MS-2022-07-02'}}
# my_input = {'IndexName': 'GSI-1', 'FilterExpression': Attr("Duration").gt(), 'KeyConditionExpression': Key("aws_dbe_b_PK1").eq("EE-c") & Key("aws_dbe_b_SK1").between("MS-2022-07-02", "MS-2022-07-08")}

out = table.query(**my_input)
print(f"{out=}")