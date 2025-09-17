package hexlet.code;

import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class Parser {

    public static Map<String, Object> parse(String content) throws Exception {
        return new ObjectMapper().readValue(content, new TypeReference<>() { });
    }
}
