package hexlet.code.formatters;

import hexlet.code.DiffItem;

import java.util.List;
import java.util.Map;

public class Stylish {

    public static String formatStylish(List<DiffItem> diff) {
        StringBuilder result = new StringBuilder("{\n");

        for (DiffItem item : diff) {
            switch (item.getStatus()) {
                case "same":
                    result.append("    ").append(item.getKey()).append(": ")
                            .append(formatValue(item.getValue1())).append("\n");
                    break;
                case "updated":
                    result.append("  - ").append(item.getKey()).append(": ")
                            .append(formatValue(item.getValue1())).append("\n");
                    result.append("  + ").append(item.getKey()).append(": ")
                            .append(formatValue(item.getValue2())).append("\n");
                    break;
                case "added":
                    result.append("  + ").append(item.getKey()).append(": ")
                            .append(formatValue(item.getValue2())).append("\n");
                    break;
                case "removed":
                    result.append("  - ").append(item.getKey()).append(": ")
                            .append(formatValue(item.getValue1())).append("\n");
                    break;
                default:
                    throw new RuntimeException("Unknown status: '" + item.getStatus() + "'");
            }
        }

        result.append("}");
        return result.toString();
    }

    private static String formatValue(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof List || value instanceof Map) {
            return value.toString();
        }
        return value.toString();
    }
}
