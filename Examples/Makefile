default:
	@echo make targets are : test_java, test_net, test_migrate, clean

# requires "make build_java mvn_local_deploy" in DynamoDbEncryption
test_java:
	gradle -p runtimes/java/DynamoDbEncryption test

# requires "make transpile_net" in DynamoDbEncryption
test_net:
	cd runtimes/net && dotnet run

# requires "make build_java mvn_local_deploy" in DynamoDbEncryption
test_migrate:
	gradle -p runtimes/java/Migration/PlaintextToAWSDBE test
	gradle -p runtimes/java/Migration/DDBECToAWSDBE test

clean:
	rm -f runtimes/net/*.pem runtimes/java/*.pem
