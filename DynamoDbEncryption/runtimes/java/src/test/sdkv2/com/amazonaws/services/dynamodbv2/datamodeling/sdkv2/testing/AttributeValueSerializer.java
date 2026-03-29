package com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.testing;

import com.amazonaws.util.Base64;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class AttributeValueSerializer extends JsonSerializer<AttributeValue> {

  @Override
  public void serialize(
    AttributeValue value,
    JsonGenerator jgen,
    SerializerProvider provider
  ) throws IOException {
    if (value == null) return;
    jgen.writeStartObject();
    if (value.s() != null) {
      jgen.writeStringField("S", value.s());
    } else if (value.b() != null) {
      jgen.writeStringField(
        "B",
        Base64.encodeAsString(value.b().asByteArray())
      );
    } else if (value.n() != null) {
      jgen.writeStringField("N", value.n());
    } else if (value.hasSs()) {
      jgen.writeFieldName("SS");
      jgen.writeStartArray();
      for (String s : value.ss()) {
        jgen.writeString(s);
      }
      jgen.writeEndArray();
    } else if (value.hasNs()) {
      jgen.writeFieldName("NS");
      jgen.writeStartArray();
      for (String num : value.ns()) {
        jgen.writeString(num);
      }
      jgen.writeEndArray();
    } else if (value.hasL()) {
      jgen.writeFieldName("L");
      jgen.writeStartArray();
      for (AttributeValue item : value.l()) {
        serialize(item, jgen, provider);
      }
      jgen.writeEndArray();
    } else if (value.hasM()) {
      jgen.writeFieldName("M");
      jgen.writeStartObject();
      for (java.util.Map.Entry<String, AttributeValue> entry : value
        .m()
        .entrySet()) {
        jgen.writeFieldName(entry.getKey());
        serialize(entry.getValue(), jgen, provider);
      }
      jgen.writeEndObject();
    } else {
      throw new IllegalStateException(
        "AttributeValue has no value or type not implemented for serialization."
      );
    }
    jgen.writeEndObject();
  }
}
