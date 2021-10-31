package by.tms.service;

import by.tms.entity.User;
import by.tms.repository.UserRepository;

public class RegistrationService {

    public boolean checkUniqUsername(String username) {
        return !UserRepository.checkUsername(username);
    }

    public void createUser(String name, String username, String password) {
        User user = new User(name, username, password);
        UserRepository.addUser(user);
    }
}
