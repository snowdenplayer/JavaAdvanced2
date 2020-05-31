package applicationInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppMapper {
    public static Application map(ResultSet resultSet) throws SQLException {
       int id = resultSet.getInt("id");
       String name = resultSet.getString("name");
       int year = resultSet.getInt("age");

        return new Application(id,name,year);
    }
}
