package software.amazon.cryptography.dbencryptionsdk.structuredencryption.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AuthItem {

    private final List<PathSegment> key;
    private final StructuredDataTerminal data;
    private final AuthenticateAction action;

    public AuthItem(List<PathSegment> key, StructuredDataTerminal data, AuthenticateAction action) {
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

    public AuthenticateAction getAction() {
        return action;
    }
}
