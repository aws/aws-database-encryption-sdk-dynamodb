package aws.cryptography.dbesdk.testserver.server.error;

/**
 * Marks a failure that originated as an exception thrown by the underlying real
 * DBE client (EncryptItem/DecryptItem, or config-driven keyring/CMM construction
 * that DBE itself rejects). The {@link aws.cryptography.dbesdk.testserver.server.registry.DbesdkClient}
 * implementation catches the DBE exception and rethrows it wrapped in this type
 * so the {@link ErrorClassifier} can distinguish DBE-origin failures from
 * TestServer-framework failures.
 *
 * <p>The DBE exception's message is captured verbatim so the classifier can
 * forward it unmodified in a {@code DBESDKClientError}.
 */
public final class DbesdkClientException extends Exception {

  /**
   * Wrap a DBE-thrown exception.
   *
   * @param cause the exception thrown by the real DBE client; its message is
   *     forwarded unmodified.
   */
  public DbesdkClientException(Throwable cause) {
    super(cause == null ? null : cause.getMessage(), cause);
  }

  /**
   * @return the DBE exception's message, unmodified. May be {@code null} if
   *     the underlying DBE exception carried no message.
   */
  public String dbeMessage() {
    return getMessage();
  }
}
