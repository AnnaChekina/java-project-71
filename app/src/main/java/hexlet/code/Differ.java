package hexlet.code;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static hexlet.code.CompareResult.compare;
import static hexlet.code.Parser.parse;
import static hexlet.code.ReaderFile.readFile;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        String file1Content = readFile(filepath1);
        String file2Content = readFile(filepath2);

        Map<String, Object> file1Parsed = parse(file1Content, filepath1);
        Map<String, Object> file2Parsed = parse(file2Content, filepath2);

        List<DiffItem> diff = compare(file1Parsed, file2Parsed);

        return Formatter.format(diff, format);
    }

    public static String generate(String filepath1, String filepath2) throws IOException {
        return Differ.generate(filepath1, filepath2, "stylish");
    }
}
