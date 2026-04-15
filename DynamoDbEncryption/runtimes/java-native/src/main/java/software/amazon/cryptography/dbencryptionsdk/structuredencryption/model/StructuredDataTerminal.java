package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.util.Arrays;

public final class StructuredDataTerminal {

    private final byte[] value;
    private final byte[] typeId;

    public StructuredDataTerminal(byte[] value, byte[] typeId) {
        if (typeId == null || typeId.length != 2) {
            throw new IllegalArgumentException("typeId must be exactly 2 bytes");
        }
        this.value = Arrays.copyOf(value, value.length);
        this.typeId = Arrays.copyOf(typeId, typeId.length);
    }

    public byte[] getValue() {
        return Arrays.copyOf(value, value.length);
    }

    public byte[] getTypeId() {
        return Arrays.copyOf(typeId, typeId.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StructuredDataTerminal)) return false;
        StructuredDataTerminal that = (StructuredDataTerminal) o;
        return Arrays.equals(value, that.value) && Arrays.equals(typeId, that.typeId);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(value);
        result = 31 * result + Arrays.hashCode(typeId);
        return result;
    }
}
