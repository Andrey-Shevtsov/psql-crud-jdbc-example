package pm.devshevtsov.application.jdbc.connection;

import java.util.Map;
import java.sql.*;
import java.util.Properties;

public class CustomJdbcConnector {

    private final String urlTemplate = "jdbc:postgresql://";
    private String hostIp;
    private String hostPort;
    private String dbName;

    private Properties properties = new Properties();

    private Connection connection;

    private Map<String, String> propsMap;
    public CustomJdbcConnector() {

    }

    // Getters and setters


    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public void setHostPort(String hostPort) {
        this.hostPort = hostPort;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public void setPropsMap(Map<String, String> propsMap) {
        this.propsMap = propsMap;
    }
}
