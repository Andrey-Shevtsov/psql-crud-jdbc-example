package pm.devshevtsov.application.jdbc.query;

import java.util.Map;

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
                StringBuilder params = new StringBuilder();
                StringBuilder values = new StringBuilder();
                for (Map.Entry<String, String> entry : query.getPayload().entrySet()) {
                    params.append(entry.getKey()).append(", ");
                    values.append(entry.getValue()).append(", ");
                }
                q = "INSERT INTO " + query.getTableName() + " (" + params + ") " +
                        "VALUES (" + values + ");";
                break;
        }
        query.setQueryString(q);
        return query;
    }

}
