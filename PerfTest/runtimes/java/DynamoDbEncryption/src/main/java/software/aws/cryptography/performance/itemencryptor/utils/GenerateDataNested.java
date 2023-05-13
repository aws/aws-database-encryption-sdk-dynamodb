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
public class GenerateDataNested {
    public static void main(String[] args) throws Exception {
        File myFile = new File("nested_attributes.json");
        myFile.createNewFile();
        Map<String, AttributeValue.Builder> jsonData = new HashMap<>();
        for (Integer i = 0; i < 200; i++) {
            //Randomise level of nesting
            for (Integer j = 0; j < new Random().nextInt(100); j++) {
                byte[] randomData = new byte[100];
                new Random().nextBytes(randomData);
                jsonData.put("Attribute".concat(i.toString()), AttributeValue.builder().m(gen(j)));
            }
            FileOutputStream fileOutputStream = new FileOutputStream(myFile);
            fileOutputStream.write(JsonMapper.builder().serializationInclusion(JsonInclude.Include.NON_NULL).build().writeValueAsBytes(jsonData));
            fileOutputStream.close();
        }
    }
    static Map<String, AttributeValue> gen(Integer j) {
        if(j == 0) {
            byte[] randomData = new byte[1000];
            new Random().nextBytes(randomData);
            Map<String, AttributeValue> val = new HashMap<>();
            val.put("Attribute".concat(j.toString()), AttributeValue.fromB(SdkBytes.fromByteArray(randomData)));
            return val;
        }
        Map<String, AttributeValue> nested = gen(j-1);
        Map<String, AttributeValue> parent = new HashMap<>();
        parent.put("Attribute".concat(j.toString()), AttributeValue.fromM(nested));
        return parent;
    }
}
