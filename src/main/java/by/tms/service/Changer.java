package by.tms.service;

import by.tms.entity.User;

public interface Changer {
    void changeName(User user, String newName);
    void changePassword(User user, String newPassword);
}
