package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.model.AttributeValue;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.core.SdkBytes;

/**
 * Bridges the two {@code AttributeValue} shapes the test server sees:
 *
 * <ul>
 *   <li>The Smithy-modeled {@link AttributeValue} the wire carries (tagged
 *       union via optional members: S / N / B / BOOL / NULL / SS / NS / BS /
 *       L / M).</li>
 *   <li>The AWS SDK v2 {@link software.amazon.awssdk.services.dynamodb.model.AttributeValue}
 *       DBE's {@code DynamoDbItemEncryptor} consumes and returns.</li>
 * </ul>
 *
 * <p>L (list) and M (map) are recursive: their elements are themselves
 * AttributeValues, so the codec recurses to translate arbitrarily nested items.
 */
public final class DdbItemCodec {

  /** Modeled item map → SDK v2 item map. */
  public Map<
    String,
    software.amazon.awssdk.services.dynamodb.model.AttributeValue
  > toDdb(Map<String, AttributeValue> modeled) {
    Map<
      String,
      software.amazon.awssdk.services.dynamodb.model.AttributeValue
    > out = new LinkedHashMap<>(modeled.size());
    for (Map.Entry<String, AttributeValue> e : modeled.entrySet()) {
      out.put(e.getKey(), toDdbAttribute(e.getKey(), e.getValue()));
    }
    return out;
  }

  /** SDK v2 item map → modeled item map. */
  public Map<String, AttributeValue> toModel(
    Map<
      String,
      software.amazon.awssdk.services.dynamodb.model.AttributeValue
    > ddb
  ) {
    Map<String, AttributeValue> out = new LinkedHashMap<>(ddb.size());
    for (Map.Entry<
      String,
      software.amazon.awssdk.services.dynamodb.model.AttributeValue
    > e : ddb.entrySet()) {
      out.put(e.getKey(), toModelAttribute(e.getKey(), e.getValue()));
    }
    return out;
  }

  // ------------------------------------------------------------------

  private static software.amazon.awssdk.services.dynamodb.model.AttributeValue toDdbAttribute(
    String name,
    AttributeValue av
  ) {
    // Exactly one variant is expected to be set. If none are, that's a
    // caller bug — surface it rather than emit an empty AttributeValue.
    if (av.getS() != null) {
      return ddb().s(av.getS()).build();
    }
    if (av.getN() != null) {
      return ddb().n(av.getN()).build();
    }
    if (av.getB() != null) {
      return ddb().b(toSdkBytes(av.getB())).build();
    }
    if (av.isBool() != null) {
      return ddb().bool(av.isBool()).build();
    }
    if (av.isNull() != null) {
      return ddb().nul(av.isNull()).build();
    }
    if (av.hasSs()) {
      return ddb().ss(av.getSs()).build();
    }
    if (av.hasNs()) {
      return ddb().ns(av.getNs()).build();
    }
    if (av.hasBs()) {
      List<SdkBytes> bs = new ArrayList<>(av.getBs().size());
      for (ByteBuffer buf : av.getBs()) {
        bs.add(toSdkBytes(buf));
      }
      return ddb().bs(bs).build();
    }
    if (av.hasL()) {
      List<software.amazon.awssdk.services.dynamodb.model.AttributeValue> list =
        new ArrayList<>(av.getL().size());
      for (AttributeValue element : av.getL()) {
        list.add(toDdbAttribute(name, element));
      }
      return ddb().l(list).build();
    }
    if (av.hasM()) {
      Map<
        String,
        software.amazon.awssdk.services.dynamodb.model.AttributeValue
      > mm = new LinkedHashMap<>(av.getM().size());
      for (Map.Entry<String, AttributeValue> e : av.getM().entrySet()) {
        mm.put(e.getKey(), toDdbAttribute(e.getKey(), e.getValue()));
      }
      return ddb().m(mm).build();
    }
    throw new IllegalArgumentException(
      "Attribute '" +
      name +
      "' has no variant member set " +
      "(expected one of S, N, B, BOOL, NULL, SS, NS, BS, L, M)"
    );
  }

  private static AttributeValue toModelAttribute(
    String name,
    software.amazon.awssdk.services.dynamodb.model.AttributeValue ddb
  ) {
    if (ddb.s() != null) {
      return AttributeValue.builder().s(ddb.s()).build();
    }
    if (ddb.n() != null) {
      return AttributeValue.builder().n(ddb.n()).build();
    }
    if (ddb.b() != null) {
      return AttributeValue
        .builder()
        .b(ByteBuffer.wrap(ddb.b().asByteArray()))
        .build();
    }
    if (ddb.bool() != null) {
      return AttributeValue.builder().bool(ddb.bool()).build();
    }
    if (ddb.nul() != null) {
      return AttributeValue.builder().nullMember(ddb.nul()).build();
    }
    if (ddb.hasSs()) {
      return AttributeValue.builder().ss(ddb.ss()).build();
    }
    if (ddb.hasNs()) {
      return AttributeValue.builder().ns(ddb.ns()).build();
    }
    if (ddb.hasBs()) {
      List<ByteBuffer> bs = new ArrayList<>(ddb.bs().size());
      for (SdkBytes sb : ddb.bs()) {
        bs.add(ByteBuffer.wrap(sb.asByteArray()));
      }
      return AttributeValue.builder().bs(bs).build();
    }
    if (ddb.hasL()) {
      List<AttributeValue> list = new ArrayList<>(ddb.l().size());
      for (software.amazon.awssdk.services.dynamodb.model.AttributeValue element : ddb.l()) {
        list.add(toModelAttribute(name, element));
      }
      return AttributeValue.builder().l(list).build();
    }
    if (ddb.hasM()) {
      Map<String, AttributeValue> mm = new LinkedHashMap<>(ddb.m().size());
      for (Map.Entry<
        String,
        software.amazon.awssdk.services.dynamodb.model.AttributeValue
      > e : ddb.m().entrySet()) {
        mm.put(e.getKey(), toModelAttribute(e.getKey(), e.getValue()));
      }
      return AttributeValue.builder().m(mm).build();
    }
    throw new IllegalStateException(
      "DBE returned attribute '" +
      name +
      "' with an unsupported kind " +
      "(supported: S, N, B, BOOL, NULL, SS, NS, BS, L, M)"
    );
  }

  private static software.amazon.awssdk.services.dynamodb.model.AttributeValue.Builder ddb() {
    return software.amazon.awssdk.services.dynamodb.model.AttributeValue.builder();
  }

  private static SdkBytes toSdkBytes(ByteBuffer buf) {
    byte[] copy = new byte[buf.remaining()];
    buf.duplicate().get(copy);
    return SdkBytes.fromByteArray(copy);
  }
}
