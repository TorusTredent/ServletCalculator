package by.tms.repository.configs;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configs {
    protected static String url = "jdbc:mysql://localhost/tms?useUnicode=true&serverTimezone=UTC";
    protected static String login = "root";
    protected static String password = "12344321";

    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
