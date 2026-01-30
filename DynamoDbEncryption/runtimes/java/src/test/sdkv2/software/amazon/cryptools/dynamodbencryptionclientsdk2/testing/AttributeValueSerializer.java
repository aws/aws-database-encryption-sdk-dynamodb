package software.amazon.cryptools.dynamodbencryptionclientsdk2.testing;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import com.amazonaws.util.Base64;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.nio.ByteBuffer;

public class AttributeValueSerializer extends JsonSerializer<AttributeValue.Builder> {
    @Override
    public void serialize(AttributeValue.Builder value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException {
        if (value != null) {
            jgen.writeStartObject();
            if (value.build().s() != null) {
                jgen.writeStringField("S", value.build().s());
            } else if (value.build().b() != null) {
                ByteBuffer valueBytes = value.build().b().asByteBuffer();
                byte[] arr = new byte[valueBytes.remaining()];
                valueBytes.get(arr);
                jgen.writeStringField("B", Base64.encodeAsString(arr));
            } else if (value.build().n() != null) {
                jgen.writeStringField("N", value.build().n());
            } else if (value.build().ss() != null) {
                jgen.writeFieldName("SS");
                jgen.writeStartArray();
                for (String s : value.build().ss()) {
                    jgen.writeString(s);
                }
                jgen.writeEndArray();
            } else if (value.build().ns() != null) {
                jgen.writeFieldName("NS");
                jgen.writeStartArray();
                for (String num : value.build().ns()) {
                    jgen.writeString(num);
                }
                jgen.writeEndArray();
            } else {
                throw new IllegalStateException(
                        "AttributeValue has no value or type not implemented for serialization.");
            }
            jgen.writeEndObject();
        }
    }
}
