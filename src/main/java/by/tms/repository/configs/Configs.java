package by.tms.repository.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configs {
    protected static String url = "jdbc:mysql://localhost/tms?useUnicode=true&serverTimezone=UTC";
    protected static String login = "root";
    protected static String password = "12344321";

    protected static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
