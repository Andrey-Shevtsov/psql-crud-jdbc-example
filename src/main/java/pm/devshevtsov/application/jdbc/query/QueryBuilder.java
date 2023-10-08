package pm.devshevtsov.application.jdbc.query;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class QueryBuilder {

    public QueryBuilder() {

    }

    private LegacyQuery query = new LegacyQuery();

    public QueryBuilder setType(String type) {
        query.setType(type);
        return this;
    }

    public QueryBuilder setTable(String tableName) {
        query.setTableName(tableName);
        return this;
    }

    public QueryBuilder setPayload(Map<String, String> payload) {
        query.setPayload(payload);
        return this;
    }

    public LegacyQuery build() {
        String q = null;
        switch (query.getType()) {
            case "INSERT":
                Map<String, String> payload = query.getPayload();
                Set<Map.Entry<String, String>> entrySet = payload.entrySet();
                List<String> paramsList = entrySet.stream()
                        .map(Map.Entry::getKey)
                        .toList();
                List<String> valuesList = entrySet.stream()
                        .map(Map.Entry::getValue)
                        .toList();
                String params = entrySet.stream()
                        .map(Map.Entry::getKey)
                        .collect(Collectors.joining(","));
                q = "INSERT INTO " + query.getTableName() + " (" + params + ") " +
                        "VALUES (" + valuesList + ");";
                break;
        }
        query.setQueryString(q);
        return query;
    }

}
