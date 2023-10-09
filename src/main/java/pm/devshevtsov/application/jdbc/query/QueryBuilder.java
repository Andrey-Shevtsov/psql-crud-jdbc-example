package pm.devshevtsov.application.jdbc.query;

import java.util.*;
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
                String params = entrySet.stream()
                        .map(Map.Entry::getKey)
                        .collect(Collectors.joining(", "));
                List<String> values = entrySet.stream()
                        .map(Map.Entry::getValue)
                        .toList();
                String fmtValues = values.stream()
                        .map(s -> "\'" + s + "\'")
                        .collect(Collectors.joining(", "));
                q = "INSERT INTO " + query.getTableName() + " (" + params + ") " +
                        "VALUES (" + fmtValues + ");";
                break;
        }
        query.setQueryString(q);
        return query;
    }

}
