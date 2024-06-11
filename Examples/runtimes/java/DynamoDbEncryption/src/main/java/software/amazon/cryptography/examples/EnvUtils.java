package software.amazon.cryptography.examples;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.StringUtils;

public class EnvUtils {

  @Nonnull
  public static String envOrDefault(
    @Nonnull String key,
    @Nonnull String _default
  ) {
    @Nullable
    String maybe = System.getenv(key);
    if (StringUtils.isEmpty(maybe)) {
      return _default;
    }
    return maybe;
  }

  @Nonnull
  public static String envOrFail(@Nonnull String key) {
    @Nullable
    String maybe = System.getenv(key);
    if (StringUtils.isEmpty(maybe)) {
      throw new RuntimeException(String.format("Env had no key: %s", key));
    }
    return maybe;
  }
}
