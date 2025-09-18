package hexlet.code;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String format(List<DiffItem> diff, String format) {
        switch (format) {
            case "stylish" -> {
                return formatStylish(diff);
            }
            case "plain" -> {
                return formatPlain(diff);
            }
            case "json" -> {
                return formatJson(diff);
            }
            default -> throw new RuntimeException("Unsupported output format: " + format);
        }
    }

    public static String formatStylish(List<DiffItem> diff) {
        StringBuilder result = new StringBuilder("{\n");

        for (DiffItem item : diff) {
            switch (item.getStatus()) {
                case "unchanged":
                    result.append("    ").append(item.getKey()).append(": ")
                            .append(formatValue(item.getValue1())).append("\n");
                    break;
                case "changed":
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
                    break;
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

    private static String formatPlain(List<DiffItem> diff) {
        return "Plain format not implemented yet";
    }

    private static String formatJson(List<DiffItem> diff) {
        return "JSON format not implemented yet";
    }
}
