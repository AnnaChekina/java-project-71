package hexlet.code.formatters;

import hexlet.code.DiffItem;

import java.util.List;
import java.util.Map;

public class Plain {

    public static String formatPlain(List<DiffItem> diff) {
        StringBuilder result = new StringBuilder();

        for (DiffItem item : diff) {
            switch (item.getStatus()) {
                case "unchanged":
                    // unchanged properties are not shown in plain format
                    break;
                case "updated":
                    result.append("Property '").append(item.getKey()).append("' was ").append(item.getStatus())
                            .append(". From ").append(formatValue(item.getValue1())).append(" to ")
                            .append(formatValue(item.getValue2())).append("\n");
                    break;
                case "added":
                    result.append("Property '").append(item.getKey()).append("' was ")
                            .append(item.getStatus()).append(" with value: ")
                            .append(formatValue(item.getValue2())).append("\n");
                    break;
                case "removed":
                    result.append("Property '").append(item.getKey()).append("' was ")
                            .append(item.getStatus()).append("\n");
                    break;
                default:
                    break;
            }
        }

        return result.toString().trim();
    }

    private static String formatValue(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof List || value instanceof Map) {
            return "[complex value]";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        return value.toString();
    }
}
