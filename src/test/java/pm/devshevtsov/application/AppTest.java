package pm.devshevtsov.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pm.devshevtsov.application.jdbc.query.LegacyQuery;
import pm.devshevtsov.application.jdbc.query.QueryBuilder;

import java.util.HashMap;
import java.util.Map;

public class AppTest {

    QueryBuilder builder = new QueryBuilder();

    Map<String, String> map = new HashMap<>();

    @Test
    @DisplayName("build example query")
    void buildBasicQuery() {

        map.put("id", "oers31sf1fgld34");
        map.put("name", "John");
        map.put("lastName", "Svetov");

        System.out.println("Input map: " + map);

        LegacyQuery legacyQuery = builder.setType("INSERT")
                .setTable("test")
                .setPayload(map)
                .build();
        assertEquals(legacyQuery.getQueryString(),
                "INSERT INTO test (id, name, lastName) VALUES (\'oers31sf1fgld34\', \'John\', \'Svetov\');");
    }
}
