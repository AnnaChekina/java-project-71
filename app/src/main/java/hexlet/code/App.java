package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<Integer> {

    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private String filepath1;

    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private String filepath2;

    @Option(names = {"-f", "--format"},
            defaultValue = "stylish",
            description = "output format [default: stylish]",
            paramLabel = "format")
    private String format;

    @Override
    public Integer call() {
        try {
            Map<String, Object> data1 = readFile(filepath1);
            Map<String, Object> data2 = readFile(filepath2);
            String diff = Differ.generate(data1, data2);
            System.out.println(diff);
            return 0;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return 1;
        }
    }

    private static Map<String, Object> readFile(String filePath) throws Exception {
        try (InputStream input = App.class.getResourceAsStream("/" + filePath)) {
            if (input != null) {
                try (Scanner scanner = new Scanner(input).useDelimiter("\\A")) {
                    return parse(scanner.hasNext() ? scanner.next() : "");
                }
            }
        }
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        if (Files.exists(path)) {
            String content = Files.readString(path);
            return parse(content);
        }
        throw new FileNotFoundException("File not found: " + filePath);
    }

    private static Map<String, Object> parse(String content) throws Exception {
        return new ObjectMapper().readValue(content, new TypeReference<>() { });
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
