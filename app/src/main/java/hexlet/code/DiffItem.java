package hexlet.code;

public record DiffItem(String key, Object value1, Object value2, String status) {

    public String getKey() {
        return key;
    }

    public Object getValue1() {
        return value1;
    }


    public Object getValue2() {
        return value2;
    }

    public String getStatus() {
        return status;
    }
}
