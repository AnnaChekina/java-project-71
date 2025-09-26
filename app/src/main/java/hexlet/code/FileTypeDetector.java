package hexlet.code;

public class FileTypeDetector {

    public static String getFileType(String filepath) {
        if (filepath.toLowerCase().endsWith(".json")) {
            return "json";
        } else if (filepath.toLowerCase().endsWith(".yaml") || filepath.toLowerCase().endsWith(".yml")) {
            return "yaml";
        } else {
            throw new IllegalArgumentException("Unsupported file format: '" + filepath + "'");
        }
    }
}
