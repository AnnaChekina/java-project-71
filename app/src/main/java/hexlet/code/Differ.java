package hexlet.code;

import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Differ {
    public static String generate(Map<String, Object> data1, Map<String, Object> data2) {
        TreeSet<String> allKeys = new TreeSet<>();
        allKeys.addAll(data1.keySet());
        allKeys.addAll(data2.keySet());

        String result = allKeys.stream()
                .flatMap(key -> generateKeyDiff(key, data1, data2))
                .collect(Collectors.joining("\n"));

        return  "{\n" + result + "\n}";
    }

    public static Stream<String> generateKeyDiff(String key, Map<String, Object> data1, Map<String, Object> data2) {
        boolean isFirst = data1.containsKey(key);
        boolean isSecond = data2.containsKey(key);
        Object value1 = data1.get(key);
        Object value2 = data2.get(key);

        if (isFirst && isSecond) {
            if (value1.equals(value2)) {
                return Stream.of("   " + key + ": " + value1);
            } else {
                return Stream.of(
                        " - " + key + ": " + value1,
                        " + " + key + ": " + value2
                );
            }
        } else if (isFirst) {
            return Stream.of("   " + key + ": " + value1);
        } else {
            return Stream.of("   " + key + ": " + value2);
        }
    }
}
