package pm.devshevtsov.application.jdbc.query;

import java.util.Map;

public class LegacyQuery {
    private String type; //Create ,Read, Update or Delete Query
    private String tableName; // Name of Table that related to the query
    private Map<String, String> payload; //Data needed to be taken or updated

    private String queryString; // Finalized string

    public LegacyQuery() {

    }

    // Getters and Setters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Map<String, String> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, String> payload) {
        this.payload = payload;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }
}
