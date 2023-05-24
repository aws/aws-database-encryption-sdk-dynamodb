package software.aws.cryptography.performance.itemencryptor.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.json.JsonMapper;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * A convenient class to generate some random binary data with flat attributes. The logic is not thoroughly tested
 * and is mainly for debugging purpose (and avoid handwriting data).
 */
public class GenerateDataFlat {
    public static void main(final String[] args) throws Exception {
        final File myFile = new File("flat_attributes.json");
        myFile.createNewFile();
        final Map<String, AttributeValue.Builder> jsonData = new HashMap<>();
        //First 2 attributes are pk and sk
        for (Integer topLevelAttributeIndex = 2; topLevelAttributeIndex < 100; topLevelAttributeIndex++) {
            byte[] randomData = new byte[2000];
            new Random().nextBytes(randomData);
            jsonData.put("Attribute".concat(topLevelAttributeIndex.toString()), AttributeValue.builder().b(SdkBytes.fromByteArray(randomData)));
        }
        final FileOutputStream fileOutputStream = new FileOutputStream(myFile);
        fileOutputStream.write(JsonMapper.builder()
                                         .serializationInclusion(JsonInclude.Include.NON_NULL)
                                         .build()
                                         .writeValueAsBytes(jsonData));
        fileOutputStream.close();
    }
}
