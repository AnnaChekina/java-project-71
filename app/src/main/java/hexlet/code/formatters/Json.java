package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import hexlet.code.DiffItem;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Json {

    public static String formatJson(List<DiffItem> diff) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<Map<String, Object>> result = new ArrayList<>();

        for (DiffItem item : diff) {
            Map<String, Object> itemMap = new LinkedHashMap<>();
            itemMap.put("key", item.getKey());
            itemMap.put("status", item.getStatus());

            switch (item.getStatus()) {
                case "same", "removed":
                    itemMap.put("oldValue", item.getValue1());
                    break;
                case "updated":
                    itemMap.put("oldValue", item.getValue1());
                    itemMap.put("newValue", item.getValue2());
                    break;
                case "added":
                    itemMap.put("newValue", item.getValue2());
                    break;
                default:
                    break;
            }

            result.add(itemMap);
        }

        return mapper.writeValueAsString(result);
    }
}
