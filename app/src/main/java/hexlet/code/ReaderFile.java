package hexlet.code;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReaderFile {

    public static String readFile(String filePath) throws Exception {
        try (InputStream input = App.class.getResourceAsStream("/" + filePath)) {
            if (input != null) {
                try (Scanner scanner = new Scanner(input).useDelimiter("\\A")) {
                    return scanner.hasNext() ? scanner.next() : "";
                }
            }
        }
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        if (Files.exists(path)) {
            return Files.readString(path);
        }
        throw new FileNotFoundException("File not found: " + filePath);
    }
}
