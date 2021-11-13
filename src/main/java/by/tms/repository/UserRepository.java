package by.tms.repository;

import by.tms.entity.User;
import by.tms.repository.configs.Const;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.tms.repository.configs.Configs.connect;

public class UserRepository extends Const{

    public void addUser(User user) {
        try {
            try (Connection connection = connect()) {
                try (PreparedStatement prep = connection.prepareStatement(addUserQuery)) {
                    prep.setString(1, user.getName());
                    prep.setString(2, user.getUsername());
                    prep.setString(3, user.getPassword());
                    prep.setString(4, user.getStatus());
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
                try (PreparedStatement prep = connection.prepareStatement(checkUsernameQuery)) {
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
                try (PreparedStatement prep = connection.prepareStatement(checkPasswordQuery)) {
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
                try (PreparedStatement prep = connection.prepareStatement(getUserQuery)) {
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
                try (PreparedStatement prep = connection.prepareStatement(changeNameQuery)) {
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
                try (PreparedStatement prep = connection.prepareStatement(changePasswordQuery)) {
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
                try (PreparedStatement prep = connection.prepareStatement(deleteUserQuery)) {
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
                try (PreparedStatement prep = connection.prepareStatement(getUserListQuery)) {
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

    public void addAdminStatus(int userId) {
        try {
            try (Connection connection = connect()) {
                try (PreparedStatement prep = connection.prepareStatement(addAdminStatus)) {
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

    public void removeAdminStatus(int userId) {
        try {
            try (Connection connection = connect()) {
                try (PreparedStatement prep = connection.prepareStatement(removeAdminStatus)) {
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
                    rs.getString(4), rs.getString(5));
        }
        return null;
    }
}
