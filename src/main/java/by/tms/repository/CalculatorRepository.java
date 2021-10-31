package by.tms.repository;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.repository.configs.Configs;
import by.tms.repository.configs.Const;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CalculatorRepository extends Configs {

    public static void addOperation(Operation operation) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, password)) {

                String query = "INSERT INTO " + Const.OPERATIONS_TABLE + "(" + Const.OPERATIONS_NUM1 + ", " +
                        Const.OPERATIONS_NUM2 + ", " + Const.OPERATIONS_OPERATION + ", " + Const.OPERATIONS_RESULT +
                        ", " + Const.OPERATIONS_USER_ID + ") " + "VALUES (?, ?, ?, ?, ?)";

                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, operation.getNum1());
                    prep.setString(2, operation.getNum2());
                    prep.setString(3, operation.getOperation());
                    prep.setString(4, operation.getResult());
                    prep.setInt(5, operation.getUser_id());
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Operation> getOperationList(int userId) {
        List<Operation> operationList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, password)) {

                String query = "SELECT " + Const.OPERATIONS_NUM1 + ", " + Const.OPERATIONS_NUM2 + ", "
                        + Const.OPERATIONS_OPERATION + ", " + Const.OPERATIONS_RESULT +
                        " FROM " + Const.OPERATIONS_TABLE + " WHERE " + Const.OPERATIONS_USER_ID + " = ?";

                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setInt(1, userId);
                    ResultSet rs = prep.executeQuery();
                    while (rs.next()) {
                        operationList.add(new Operation(rs.getString(1), rs.getString(2),
                                rs.getString(3), rs.getString(4)));
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
