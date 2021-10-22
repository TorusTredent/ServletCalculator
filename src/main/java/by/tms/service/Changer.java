package by.tms.service;

public interface Changer {
    void changeName(int userId, String newName);
    void changePassword(int userId, String newPassword);
}
