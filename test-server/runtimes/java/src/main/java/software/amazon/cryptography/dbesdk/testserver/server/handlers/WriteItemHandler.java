// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.server.handlers;

import java.util.Map;
import java.util.Objects;
import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.cryptography.dbesdk.testserver.model.DBESDKClientError;
import software.amazon.cryptography.dbesdk.testserver.model.GenericServerError;
import software.amazon.cryptography.dbesdk.testserver.model.WriteItemInput;
import software.amazon.cryptography.dbesdk.testserver.model.WriteItemOutput;
import software.amazon.cryptography.dbesdk.testserver.server.ClientRegistry;
import software.amazon.cryptography.dbesdk.testserver.server.EnhancedClientHandle;
import software.amazon.cryptography.dbesdk.testserver.service.WriteItemOperation;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Handler for the {@code WriteItem} operation (Reqs 5.1, 5.5).
 *
 * <p>This is the {@code writeItem} operation handler of the design's Java_Server component. It
 * implements the smithy-java generated {@link WriteItemOperation} functional interface, so {@code
 * TestServerMain.buildService()} registers it directly; the constructor signature {@code
 * WriteItemHandler(ClientRegistry)} is unchanged so that wiring keeps compiling.
 *
 * <h2>Behavior</h2>
 *
 * <ol>
 *   <li><b>Resolve the client (Req 4.4):</b> look up the request's {@code ClientId} in the {@link
 *       ClientRegistry} and use the corresponding Enhanced_Client.
 *   <li><b>Encrypt and write (Req 5.1):</b> translate the modeled {@code Item} into an SDK v2
 *       attribute map ({@link AttributeValueConversions}) and call {@link
 *       EnhancedClientHandle#putItem}, which encrypts the item and writes it to the
 *       DynamoDB_Backend. On success, return {@code WriteItemOutput{ completed = true }}.
 *   <li><b>Error mapping (Req 5.5):</b> an encrypt exception thrown by the Enhanced_Client (DB-ESDK)
 *       is forwarded as {@link DBESDKClientError}; a backend connectivity/timeout failure surfaces
 *       as {@link GenericServerError}. No fallback is attempted and the registry is never mutated by
 *       a failed write.
 * </ol>
 *
 * <h2>Encrypt-vs-backend classification</h2>
 *
 * {@code putItem} drives the AWS SDK v2 call with the DB-ESDK {@code DynamoDbEncryptionInterceptor}
 * attached, so a single {@code putItem} can fail either inside the DB-ESDK (encryption/signing) or
 * inside the AWS SDK (connecting to / timing out against the DynamoDB_Backend). These are
 * distinguished by exception provenance, walking the whole cause chain:
 *
 * <ul>
 *   <li><b>DB-ESDK / encrypt failure → {@code DBESDKClientError}.</b> Every DB-ESDK, Material
 *       Providers, and Structured Encryption exception type lives under the {@code
 *       software.amazon.cryptography.} package (e.g. {@code
 *       software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model
 *       .DynamoDbEncryptionTransformsException}, {@code ...dynamodb.model.DynamoDbEncryptionException},
 *       {@code OpaqueError}, {@code CollectionOfErrors}). If any throwable in the cause chain is from
 *       that package, the failure originated in the Enhanced_Client and is forwarded as {@code
 *       DBESDKClientError}. Checking the whole chain (and giving DB-ESDK precedence) is deliberate:
 *       the interceptor runs inside the SDK call, so an encrypt error may be wrapped by an SDK
 *       exception — but a genuine backend timeout/connectivity failure never has a DB-ESDK cause.
 *   <li><b>Backend connectivity/timeout failure → {@code GenericServerError}.</b> Otherwise, if a
 *       throwable in the chain is an AWS SDK {@link SdkException} (which is the root of all SDK v2
 *       exceptions, including {@code ApiCallTimeoutException} / {@code ApiCallAttemptTimeoutException}
 *       for the configurable timeout, {@code SdkClientException} for connectivity, and {@code
 *       AwsServiceException} for service-side rejections), the failure is a backend concern and is
 *       surfaced as {@code GenericServerError}.
 *   <li><b>Anything else → {@code GenericServerError}.</b> Any other failure (for example an {@code
 *       IllegalArgumentException} for a table the client was not configured with) is a
 *       framework/server-side concern and is surfaced as {@code GenericServerError}.
 * </ul>
 *
 * <h2>Unknown-{@code ClientId} guard (Reqs 4.4, 4.5)</h2>
 *
 * Resolving an absent/empty/unknown {@code ClientId} to a {@code GenericServerError} is delegated to
 * the shared {@link ClientResolution#resolveOrThrow} guard, which the {@code readItem} handler uses
 * too so the rule is enforced identically across operations (task 4.3 consolidated the previously
 * duplicated per-handler copies). The guard runs as the first step of {@link #writeItem}, before any
 * item translation or {@link EnhancedClientHandle#putItem} call, so an unknown id performs no
 * operation and leaves the registry unchanged (Req 4.5).
 */
public final class WriteItemHandler implements WriteItemOperation {

  private final ClientRegistry registry;

  /**
   * @param registry the process-wide Client_Registry used to resolve the request's {@code ClientId};
   *     must not be {@code null}
   */
  public WriteItemHandler(final ClientRegistry registry) {
    this.registry = Objects.requireNonNull(registry, "registry must not be null");
  }

  @Override
  public WriteItemOutput writeItem(final WriteItemInput input, final RequestContext context) {
    // 1. Resolve the ClientId to its Enhanced_Client (Reqs 4.4, 4.5). Absent/empty/unknown ->
    //    GenericServerError via the shared guard, thrown BEFORE any operation so nothing is
    //    performed and the registry is left unchanged.
    final EnhancedClientHandle handle =
        ClientResolution.resolveOrThrow(registry, input.getClientId());

    // 2. Translate the modeled Item into the SDK v2 attribute map the Enhanced_Client expects.
    final Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> sdkItem =
        AttributeValueConversions.toSdkItem(input.getItem());

    // 3. Encrypt + write to the DynamoDB_Backend (Req 5.1). Classify any failure into the modeled
    //    error shapes (Req 5.5); never fall back, never mutate the registry.
    try {
      handle.putItem(input.getTableName(), sdkItem);
    } catch (final RuntimeException failure) {
      throw classify(failure);
    }

    // 4. Success: report completion (Req 5.1).
    return WriteItemOutput.builder().completed(true).build();
  }

  /**
   * Classifies a failure thrown by {@link EnhancedClientHandle#putItem} into the appropriate modeled
   * error (Req 5.5): a DB-ESDK/encrypt failure becomes {@link DBESDKClientError}; an AWS SDK backend
   * connectivity/timeout failure (or any other failure) becomes {@link GenericServerError}.
   */
  private static RuntimeException classify(final RuntimeException failure) {
    if (isDbEsdkException(failure)) {
      return DBESDKClientError.builder()
          .message(
              "The Enhanced Client failed to encrypt or write the item: " + describe(failure))
          .withCause(failure)
          .build();
    }
    if (hasSdkException(failure)) {
      return GenericServerError.builder()
          .message(
              "The write could not be completed against the DynamoDB backend "
                  + "(connectivity or timeout): "
                  + describe(failure))
          .withCause(failure)
          .build();
    }
    return GenericServerError.builder()
        .message("The write item operation failed: " + describe(failure))
        .withCause(failure)
        .build();
  }

  /**
   * @return {@code true} if any throwable in {@code t}'s cause chain is a DB-ESDK / Material
   *     Providers / Structured Encryption exception (identified by the {@code
   *     software.amazon.cryptography.} package), indicating the failure originated in the
   *     Enhanced_Client rather than the AWS SDK backend call.
   */
  private static boolean isDbEsdkException(final Throwable t) {
    for (Throwable c = t; c != null; c = nextCause(c)) {
      if (c.getClass().getName().startsWith("software.amazon.cryptography.")) {
        return true;
      }
    }
    return false;
  }

  /**
   * @return {@code true} if any throwable in {@code t}'s cause chain is an AWS SDK v2 {@link
   *     SdkException} (the root of every SDK exception, covering timeout, connectivity, and
   *     service-side failures).
   */
  private static boolean hasSdkException(final Throwable t) {
    for (Throwable c = t; c != null; c = nextCause(c)) {
      if (c instanceof SdkException) {
        return true;
      }
    }
    return false;
  }

  /** Advances along the cause chain, guarding against a self-referential cause. */
  private static Throwable nextCause(final Throwable t) {
    final Throwable cause = t.getCause();
    return cause == t ? null : cause;
  }

  private static String describe(final Throwable t) {
    final String message = t.getMessage();
    return (message != null && !message.isEmpty()) ? message : t.getClass().getSimpleName();
  }
}
