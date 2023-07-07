package aaa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTwo {
    private static final String URL = "db.url";
    private static final String NAME = "db.name";
    private static final String PASSWORD = "db.password";

    private ConnectionTwo(){}
    public static Connection open() {
        try {
            return DriverManager.getConnection(PropertiesUtil.get(URL),PropertiesUtil.get(NAME),PropertiesUtil.get(PASSWORD));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
