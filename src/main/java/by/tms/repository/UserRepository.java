package by.tms.repository;

import by.tms.entity.User;
import by.tms.repository.configs.Configs;
import by.tms.repository.configs.Const;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserRepository extends Configs{

    public void addUser(User user) {
        try {
            try (Connection connection = connect()) {
                try (PreparedStatement prep = connection.prepareStatement(Const.addUserQuery)) {
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

    public boolean checkUsername(String username) {
        try {
            try (Connection connection = connect()) {
                try (PreparedStatement prep = connection.prepareStatement(Const.checkUsernameQuery)) {
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

    public boolean checkPassword(String inputPassword, String username) {
        try {
            try (Connection connection = connect()) {
                try (PreparedStatement prep = connection.prepareStatement(Const.checkPasswordQuery)) {
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

    public User getUser(String username) {
        try {
            try (Connection connection = connect()) {
                try (PreparedStatement prep = connection.prepareStatement(Const.getUserQuery)) {
                    prep.setString(1, username);
                    ResultSet rs = prep.executeQuery();
                    return getUser(rs);
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void changeName(int userId, String name) {
        try {
            try (Connection connection = connect()) {
                try (PreparedStatement prep = connection.prepareStatement(Const.changeNameQuery)) {
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

    public void changePassword(int userId, String newPassword) {
        try {
            try (Connection connection = connect()) {
                try (PreparedStatement prep = connection.prepareStatement(Const.changePasswordQuery)) {
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

    public void deleteUser(int userId) {
        try {
            try (Connection connection = connect()) {
                try (PreparedStatement prep = connection.prepareStatement(Const.deleteUserQuery)) {
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

    public List<User> getUserList() {
        try {
            try (Connection connection = connect()) {
                try (PreparedStatement prep = connection.prepareStatement(Const.getUserListQuery)) {
                    ResultSet rs = prep.executeQuery();
                    return getListUser(rs);
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<User> getListUser(ResultSet rs) throws SQLException {
        List<User> list = new ArrayList<>();
        while(rs.next()) {
            list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5)));
        }
        return list;
    }

    private User getUser(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return new User(rs.getInt(1),rs.getString(2), rs.getString(3),
                    rs.getString(4));
        }
        return null;
    }
}
