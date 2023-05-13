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
    public static void main(String[] args) throws Exception {
        File myFile = new File("flat_attributes.json");
        myFile.createNewFile();
        Map<String, AttributeValue.Builder> jsonData = new HashMap<>();
        //2000 * 100 bytes = 200 KB
        for (Integer i = 0; i < 2000; i++) {
                byte[] randomData = new byte[100];
                new Random().nextBytes(randomData);
                jsonData.put("Attribute".concat(i.toString()), AttributeValue.builder().b(SdkBytes.fromByteArray(randomData)));
            FileOutputStream fileOutputStream = new FileOutputStream(myFile);
            fileOutputStream.write(JsonMapper.builder().serializationInclusion(JsonInclude.Include.NON_NULL).build().writeValueAsBytes(jsonData));
            fileOutputStream.close();
        }
    }
}
