package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

public final class PathSegment {

    private final String key;

    public PathSegment(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PathSegment)) return false;
        return key != null ? key.equals(((PathSegment) o).key) : ((PathSegment) o).key == null;
    }

    @Override
    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }
}
