package pm.devshevtsov.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pm.devshevtsov.application.jdbc.query.LegacyQuery;
import pm.devshevtsov.application.jdbc.query.QueryBuilder;
import pm.devshevtsov.application.mockdata.QueryBuilderMockData;

import java.util.HashMap;
import java.util.Map;

public class AppTest {

    QueryBuilder builder = new QueryBuilder();

    static QueryBuilderMockData mock = new QueryBuilderMockData();

    @BeforeAll
    static void init() {
        mock.buildData();
    }

    @Test
    @DisplayName("build example query")
    void buildBasicQuery() {

        System.out.println("Input map: " + mock.insertQueryMock);

        LegacyQuery legacyQuery = builder.setType("INSERT")
                .setTable("test")
                .setPayload(mock.insertQueryMock)
                .build();
        assertEquals("INSERT INTO test (id, name, lastName) VALUES (\'oers31sf1fgld34\', \'John\', \'Svetov\');",
                legacyQuery.getQueryString()
        );
    }
}
