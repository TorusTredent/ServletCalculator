package by.tms.repository;

import by.tms.entity.User;
import by.tms.repository.configs.Configs;
import by.tms.repository.configs.Const;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CalculatorRepository extends Configs {

    public static void addOperation(String operation, int userId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, password)) {

                String query = "INSERT INTO " + Const.OPERATIONS_TABLE + "(" + Const.OPERATIONS_OPERATION
                        + ", " + Const.OPERATIONS_USER_ID + ") " + "VALUES (?, ?)";

                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, operation);
                    prep.setInt(2, userId);
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> getOperationList(int userId) {
        List<String> operationList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, password)) {

                String query = "SELECT " + Const.OPERATIONS_OPERATION + " FROM " + Const.OPERATIONS_TABLE +
                        " WHERE " + Const.OPERATIONS_USER_ID + " = ?";

                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setInt(1, userId);
                    ResultSet rs = prep.executeQuery();
                    while (rs.next()) {
                        operationList.add(rs.getString(1));
                    }
                    return operationList;
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void removeAllOperations(int userId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, password)) {

                String query = "DELETE FROM " + Const.OPERATIONS_TABLE +
                        " WHERE " + Const.OPERATIONS_USER_ID + " = ?";

                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setInt(1, userId);
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
