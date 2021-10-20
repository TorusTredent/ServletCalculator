package by.tms.storage;

import by.tms.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private static final List<User> list = new ArrayList<>();

    public static void addUser(User user) {
        list.add(user);
    }

    public static boolean checkUniqUsername(String username) {
        for (User user : list) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public static boolean listIsEmpty() {
        return list.isEmpty();
    }

    public static boolean checkUsername(String username) {
        for (User user : list) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPassword(String password) {
        for (User user : list) {
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static User getUser(String username) {
        for (User user : list) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static void changeName(User user, String newName) {
        for (User userList : list) {
            if (userList == user) {
                userList.setName(newName);
            }
        }
    }

    public static void changePassword(User user, String newPassword) {
        for (User userList : list) {
            if (userList == user) {
                userList.setPassword(newPassword);
            }
        }
    }
}
