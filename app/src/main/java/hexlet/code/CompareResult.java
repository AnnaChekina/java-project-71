package hexlet.code;

import java.util.Map;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class CompareResult {

    public static List<DiffItem> compare(Map<String, Object> data1, Map<String, Object> data2) {
        TreeSet<String> allKeys = new TreeSet<>();
        allKeys.addAll(data1.keySet());
        allKeys.addAll(data2.keySet());

        List<DiffItem> diff = new ArrayList<>();

        for (String key : allKeys) {
            boolean inFirst = data1.containsKey(key);
            boolean inSecond = data2.containsKey(key);
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (inFirst && inSecond) {
                if (areValuesEqual(value1, value2)) {
                    diff.add(new DiffItem(key, value1, value2, "unchanged"));
                } else {
                    diff.add(new DiffItem(key, value1, value2, "updated"));
                }
            } else if (inFirst) {
                diff.add(new DiffItem(key, value1, null, "removed"));
            } else {
                diff.add(new DiffItem(key, null, value2, "added"));
            }
        }

        return diff;
    }

    private static boolean areValuesEqual(Object value1, Object value2) {
        if (value1 == null && value2 == null) {
            return true;
        }
        if (value1 == null || value2 == null) {
            return false;
        }
        return value1.equals(value2);
    }
}
