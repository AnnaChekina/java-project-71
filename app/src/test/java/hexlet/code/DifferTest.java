package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private static String executedResultStylish;
    private static String executedResultPlain;
    private static String executedResultJson;

    public static Path getAbsolutePath(String fileName) {
        return Paths.get("./src/test/resources/", fileName).toAbsolutePath().normalize();
    }

    public static String readFile(String fileName) throws IOException {
        Path filePath = getAbsolutePath(fileName);
        return Files.readString(filePath).trim();
    }

    @BeforeAll
    public static void setup() throws IOException {
        executedResultStylish = readFile("expected_result/stylish.txt");
        executedResultPlain = readFile("expected_result/plain.txt");
        executedResultJson = readFile("expected_result/json.json");
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    public void testGenerateWithDefaultOutput(String inputFormat) throws Exception {
        var file1 = getAbsolutePath("input_files/input_file1." + inputFormat).toString();
        var file2 = getAbsolutePath("input_files/input_file2." + inputFormat).toString();

        String actualResult = Differ.generate(file1, file2);
        assertEquals(actualResult, executedResultStylish);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    public void testGenerateWithStylishOutput(String inputFormat) throws Exception {
        var file1 = getAbsolutePath("input_files/input_file1." + inputFormat).toString();
        var file2 = getAbsolutePath("input_files/input_file2." + inputFormat).toString();

        String actualResult = Differ.generate(file1, file2, "stylish");
        assertEquals(actualResult, executedResultStylish);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    public void testGenerateWithPlainOutput(String inputFormat) throws Exception {
        var file1 = getAbsolutePath("input_files/input_file1." + inputFormat).toString();
        var file2 = getAbsolutePath("input_files/input_file2." + inputFormat).toString();

        String actualResult = Differ.generate(file1, file2, "plain");
        assertEquals(actualResult, executedResultPlain);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    public void testGenerateWithJsonOutput(String inputFormat) throws Exception {
        var file1 = getAbsolutePath("input_files/input_file1." + inputFormat).toString();
        var file2 = getAbsolutePath("input_files/input_file2." + inputFormat).toString();

        String actualResult = Differ.generate(file1, file2, "json");
        JSONAssert.assertEquals(actualResult, executedResultJson, false);
    }
}
