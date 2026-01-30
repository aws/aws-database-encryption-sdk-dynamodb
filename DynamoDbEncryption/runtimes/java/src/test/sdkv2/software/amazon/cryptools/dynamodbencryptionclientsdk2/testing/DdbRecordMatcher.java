package software.amazon.cryptools.dynamodbencryptionclientsdk2.testing;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import java.util.Map;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class DdbRecordMatcher extends BaseMatcher<Map<String, AttributeValue>>{
    private final Map<String, AttributeValue> expected;
    private final boolean invert;

    public static DdbRecordMatcher invert(Map<String, AttributeValue> expected) {
        return new DdbRecordMatcher(expected, true);
    }

    public static DdbRecordMatcher match(Map<String, AttributeValue> expected) {
        return new DdbRecordMatcher(expected, false);
    }

    public DdbRecordMatcher(Map<String, AttributeValue> expected, boolean invert) {
        this.expected = expected;
        this.invert = invert;
    }

    @Override
    public boolean matches(Object item) {
        @SuppressWarnings("unchecked")
        Map<String, AttributeValue> actual = (Map<String, AttributeValue>) item;
        if (!expected.keySet().equals(actual.keySet())) {
            return invert;
        }
        for (String key : expected.keySet()) {
            if (key.equals("version")) continue;
            AttributeValue e = expected.get(key);
            AttributeValue a = actual.get(key);
            if (!AttributeValueMatcher.attrEquals(a, e)) {
                return invert;
            }
        }
        return !invert;
    }

    @Override
    public void describeTo(Description description) {

    }
}
