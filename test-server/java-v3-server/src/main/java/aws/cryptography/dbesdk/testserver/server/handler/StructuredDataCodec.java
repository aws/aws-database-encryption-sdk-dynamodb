package aws.cryptography.dbesdk.testserver.server.handler;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthItem;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoItem;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.PathSegment;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructureSegment;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal;

/**
 * Maps the minimal wire structured-data shapes onto the DBE Structured
 * Encryption model types and back: {@code StructuredDataMap} (name → terminal),
 * {@code CryptoSchemaMap} (name → Crypto Action), and {@code AuthenticateSchemaMap}
 * (name → Authenticate Action). A terminal carries opaque {@code value} bytes and
 * a 2-byte {@code typeId}, both passed through unchanged.
 */
public final class StructuredDataCodec {

  /** Wire structured-data map → DBE structured-data map. */
  public Map<String, StructuredDataTerminal> toDbe(
    Map<
      String,
      aws.cryptography.dbesdk.testserver.server.model.StructuredDataTerminal
    > wire
  ) {
    Map<String, StructuredDataTerminal> out = new LinkedHashMap<>();
    wire.forEach((name, terminal) ->
      out.put(
        name,
        StructuredDataTerminal
          .builder()
          .value(terminal.getValue())
          .typeId(terminal.getTypeId())
          .build()
      )
    );
    return out;
  }

  /** DBE structured-data map → wire structured-data map. */
  public Map<
    String,
    aws.cryptography.dbesdk.testserver.server.model.StructuredDataTerminal
  > toWire(Map<String, StructuredDataTerminal> dbe) {
    Map<
      String,
      aws.cryptography.dbesdk.testserver.server.model.StructuredDataTerminal
    > out = new LinkedHashMap<>();
    dbe.forEach((name, terminal) ->
      out.put(
        name,
        aws.cryptography.dbesdk.testserver.server.model.StructuredDataTerminal
          .builder()
          .value(terminal.value())
          .typeId(terminal.typeId())
          .build()
      )
    );
    return out;
  }

  /** Wire Crypto Schema → DBE Crypto Schema. */
  public Map<String, CryptoAction> toDbeCryptoSchema(
    Map<
      String,
      aws.cryptography.dbesdk.testserver.server.model.CryptoAction
    > wire
  ) {
    Map<String, CryptoAction> out = new LinkedHashMap<>();
    wire.forEach((name, action) ->
      out.put(name, CryptoAction.valueOf(action.getValue()))
    );
    return out;
  }

  /** Wire Authenticate Schema → DBE Authenticate Schema. */
  public Map<String, AuthenticateAction> toDbeAuthenticateSchema(
    Map<
      String,
      aws.cryptography.dbesdk.testserver.server.model.AuthenticateAction
    > wire
  ) {
    Map<String, AuthenticateAction> out = new LinkedHashMap<>();
    wire.forEach((name, action) ->
      out.put(name, AuthenticateAction.valueOf(action.getValue()))
    );
    return out;
  }

  // -- Path-based (list) forms ------------------------------------------------

  /** Wire Crypto List → DBE Crypto List. */
  public List<CryptoItem> toDbeCryptoList(
    List<aws.cryptography.dbesdk.testserver.server.model.PathCryptoItem> wire
  ) {
    List<CryptoItem> out = new ArrayList<>(wire.size());
    for (var item : wire) {
      out.add(
        CryptoItem
          .builder()
          .key(toDbePath(item.getPath()))
          .data(toDbeTerminal(item.getData()))
          .action(CryptoAction.valueOf(item.getAction().getValue()))
          .build()
      );
    }
    return out;
  }

  /** Wire Auth List → DBE Auth List. */
  public List<AuthItem> toDbeAuthList(
    List<aws.cryptography.dbesdk.testserver.server.model.PathAuthItem> wire
  ) {
    List<AuthItem> out = new ArrayList<>(wire.size());
    for (var item : wire) {
      out.add(
        AuthItem
          .builder()
          .key(toDbePath(item.getPath()))
          .data(toDbeTerminal(item.getData()))
          .action(AuthenticateAction.valueOf(item.getAction().getValue()))
          .build()
      );
    }
    return out;
  }

  /** DBE Crypto List → wire Crypto List. */
  public List<
    aws.cryptography.dbesdk.testserver.server.model.PathCryptoItem
  > toWireCryptoList(List<CryptoItem> dbe) {
    List<aws.cryptography.dbesdk.testserver.server.model.PathCryptoItem> out =
      new ArrayList<>(dbe.size());
    for (CryptoItem item : dbe) {
      out.add(
        aws.cryptography.dbesdk.testserver.server.model.PathCryptoItem
          .builder()
          .path(fromDbePath(item.key()))
          .data(toWireTerminal(item.data()))
          .action(
            aws.cryptography.dbesdk.testserver.server.model.CryptoAction.from(
              item.action().name()
            )
          )
          .build()
      );
    }
    return out;
  }

  private static List<PathSegment> toDbePath(List<String> wire) {
    List<PathSegment> out = new ArrayList<>(wire.size());
    for (String segment : wire) {
      out.add(
        PathSegment
          .builder()
          .member(StructureSegment.builder().key(segment).build())
          .build()
      );
    }
    return out;
  }

  private static List<String> fromDbePath(List<PathSegment> dbe) {
    List<String> out = new ArrayList<>(dbe.size());
    for (PathSegment segment : dbe) {
      out.add(segment.member().key());
    }
    return out;
  }

  private static StructuredDataTerminal toDbeTerminal(
    aws.cryptography.dbesdk.testserver.server.model.StructuredDataTerminal wire
  ) {
    return StructuredDataTerminal
      .builder()
      .value(wire.getValue())
      .typeId(wire.getTypeId())
      .build();
  }

  private static aws.cryptography.dbesdk.testserver.server.model.StructuredDataTerminal toWireTerminal(
    StructuredDataTerminal dbe
  ) {
    return aws.cryptography.dbesdk.testserver.server.model.StructuredDataTerminal
      .builder()
      .value(dbe.value())
      .typeId(dbe.typeId())
      .build();
  }
}
