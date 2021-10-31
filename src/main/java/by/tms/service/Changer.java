package by.tms.service;

import by.tms.repository.UserRepository;

public class Changer {

    public void changeName(int userId, String newName) {
        UserRepository.changeName(userId, newName);
    }

    public void changePassword(int userId, String newPassword) {
        UserRepository.changePassword(userId, newPassword);
    }
}
