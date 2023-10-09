package pm.devshevtsov.application.mockdata;

import java.util.HashMap;
import java.util.Map;

public class QueryBuilderMockData {

    public Map<String, String> insertQueryMock = new HashMap<>();

    public void buildData() {
        insertQueryMock.put("id", "oers31sf1fgld34");
        insertQueryMock.put("name", "John");
        insertQueryMock.put("lastName", "Svetov");
    }

}
