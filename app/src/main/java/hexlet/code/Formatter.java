package hexlet.code;

import java.io.IOException;
import java.util.List;

import static hexlet.code.formatters.Json.formatJson;
import static hexlet.code.formatters.Plain.formatPlain;
import static hexlet.code.formatters.Stylish.formatStylish;

public class Formatter {

    public static String format(List<DiffItem> diff, String format) throws IOException {
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
}
