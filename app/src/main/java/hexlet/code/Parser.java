package hexlet.code;

import java.io.IOException;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Parser {

    public static Map<String, Object> parse(String content, String format) throws IOException {
        ObjectMapper mapper = createMapperForFormat(format);
        return mapper.readValue(content, new TypeReference<>() {
        });
    }

    private static ObjectMapper createMapperForFormat(String format) {
        if (format.equals("json")) {
            return new ObjectMapper();
        } else if (format.equals("yaml") || format.equals("yml")) {
            return new ObjectMapper(new YAMLFactory());
        } else {
            throw new IllegalArgumentException("Unsupported format: '" + format + "'");
        }
    }
}
