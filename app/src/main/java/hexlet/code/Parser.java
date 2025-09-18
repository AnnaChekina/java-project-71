package hexlet.code;

import java.io.IOException;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Parser {

    public static Map<String, Object> parse(String content, String filepath) throws IOException {
        ObjectMapper mapper = createMapperForFile(filepath);
        return mapper.readValue(content, new TypeReference<>() {
        });
    }

    private static ObjectMapper createMapperForFile(String filepath) {
        if (filepath.toLowerCase().endsWith(".json")) {
            return new ObjectMapper();
        } else if (filepath.toLowerCase().endsWith(".yaml")
                || filepath.toLowerCase().endsWith(".yml")) {
            return new ObjectMapper(new YAMLFactory());
        } else {
            throw new IllegalArgumentException("Unsupported file format: " + filepath);
        }
    }
}
