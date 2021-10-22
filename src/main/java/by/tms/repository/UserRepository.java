package by.tms.repository;

import by.tms.entity.User;
import by.tms.repository.configs.Configs;
import by.tms.repository.configs.Const;

import java.sql.*;

public class UserRepository extends Configs {

    public static void addUser(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, password)) {

                String query = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_FIRSTNAME + ", " +
                        Const.USER_USERNAME + ", " + Const.USER_PASSWORD + ") " + "VALUES (?, ?, ?)";

                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, user.getName());
                    prep.setString(2, user.getUsername());
                    prep.setString(3, user.getPassword());
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkUsername(String username) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, password)) {

                String query = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_USERNAME + " = ?";

                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, username);
                    ResultSet rs = prep.executeQuery();
                    return rs.next();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkPassword(String inputPassword, String username) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, password)) {

                String query = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_PASSWORD + " = ? AND " +
                        Const.USER_USERNAME + " = ?";

                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, inputPassword);
                    prep.setString(2, username);
                    ResultSet rs = prep.executeQuery();
                    return rs.next();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static User getUser(String username) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, password)) {

                String query = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_USERNAME + " = ?";

                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, username);
                    ResultSet rs = prep.executeQuery();
                    if (rs.next()) {
                        return new User(rs.getInt(1),rs.getString(2), rs.getString(3),
                                rs.getString(4));
                    }
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void changeName(int userId, String name) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, password)) {

                String query = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_FIRSTNAME +
                        " = ? WHERE " + Const.USER_ID + " = ?";

                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, name);
                    prep.setLong(2, userId);
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changePassword(int userId, String newPassword) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, password)) {

                String query = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_PASSWORD +
                        " = ? WHERE " + Const.USER_ID + " = ?";

                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, newPassword);
                    prep.setLong(2, userId);
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(int userId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, password)) {

                String query = "DELETE FROM " + Const.USER_TABLE + " WHERE " + Const.USER_ID + " = ?";

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
