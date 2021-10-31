package by.tms.service;

import by.tms.entity.User;
import by.tms.repository.UserRepository;

public class SingInServiceImp{

    public boolean checkUsername(String username) {
        return UserRepository.checkUsername(username);
    }

    public boolean checkPassword(String password, String username) {
        return UserRepository.checkPassword(password, username);
    }

    public User getUser(String username) {
        return UserRepository.getUser(username.toLowerCase());
    }
}
