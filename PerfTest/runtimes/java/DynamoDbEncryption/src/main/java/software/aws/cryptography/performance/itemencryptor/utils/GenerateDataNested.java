package software.aws.cryptography.performance.itemencryptor.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * A convenient class to generate some random binary data with flat attributes. The logic is not thoroughly tested
 * and is mainly for debugging purpose (and avoid handwriting data).
 */
public class GenerateDataNested {

  public static void main(final String[] args) throws Exception {
    final File myFile = new File("nested_attributes.json");
    myFile.createNewFile();
    final Map<String, AttributeValue.Builder> jsonData = new HashMap<>();
    //First 2 attributes are pk and sk
    for (
      Integer topLevelAttributeIndex = 2;
      topLevelAttributeIndex < 100;
      topLevelAttributeIndex++
    ) {
      //Randomise level of nesting
      final Integer nestedChildAttributeIndex = new Random().nextInt(31);
      jsonData.put(
        "Attribute".concat(topLevelAttributeIndex.toString()),
        AttributeValue
          .builder()
          .m(generateNestedChildren(nestedChildAttributeIndex))
      );
    }
    final FileOutputStream fileOutputStream = new FileOutputStream(myFile);
    fileOutputStream.write(
      JsonMapper
        .builder()
        .serializationInclusion(JsonInclude.Include.NON_NULL)
        .build()
        .writeValueAsBytes(jsonData)
    );
    fileOutputStream.close();
  }

  static Map<String, AttributeValue> generateNestedChildren(
    final Integer nestedChildAttributeIndex
  ) {
    if (nestedChildAttributeIndex == 0) {
      byte[] randomData = new byte[1000];
      new Random().nextBytes(randomData);
      Map<String, AttributeValue> leafNode = new HashMap<>();
      leafNode.put(
        "Attribute".concat(nestedChildAttributeIndex.toString()),
        AttributeValue.fromB(SdkBytes.fromByteArray(randomData))
      );
      return leafNode;
    }
    Map<String, AttributeValue> nested = generateNestedChildren(
      nestedChildAttributeIndex - 1
    );
    Map<String, AttributeValue> parent = new HashMap<>();
    parent.put(
      "Attribute".concat(nestedChildAttributeIndex.toString()),
      AttributeValue.fromM(nested)
    );
    return parent;
  }
}
