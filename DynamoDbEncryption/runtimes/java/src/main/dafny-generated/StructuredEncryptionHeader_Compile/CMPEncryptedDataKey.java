// Class CMPEncryptedDataKey
// Dafny class CMPEncryptedDataKey compiled into Java
package StructuredEncryptionHeader_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class CMPEncryptedDataKey {
  public CMPEncryptedDataKey() {
  }
  public static boolean _Is(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey __source) {
    software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey _2_x = __source;
    return __default.ValidEncryptedDataKey(_2_x);
  }
  private static final dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> _TYPE = dafny.TypeDescriptor.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>referenceWithInitializer(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey.class, () -> software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey.Default());
  public static dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> _typeDescriptor() {
    return (dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
