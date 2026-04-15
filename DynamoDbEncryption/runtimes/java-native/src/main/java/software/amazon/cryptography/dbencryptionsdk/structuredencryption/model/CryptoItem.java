package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CryptoItem {

    private final List<PathSegment> key;
    private final StructuredDataTerminal data;
    private final CryptoAction action;

    public CryptoItem(List<PathSegment> key, StructuredDataTerminal data, CryptoAction action) {
        this.key = Collections.unmodifiableList(new ArrayList<PathSegment>(key));
        this.data = data;
        this.action = action;
    }

    public List<PathSegment> getKey() {
        return key;
    }

    public StructuredDataTerminal getData() {
        return data;
    }

    public CryptoAction getAction() {
        return action;
    }
}
