package by.tms.service.user;

import by.tms.entity.User;
import by.tms.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public boolean checkUsername(String username) {
        return userRepository.checkUsername(username);
    }

    public boolean checkPassword(String password, String username) {
        return userRepository.checkPassword(password, username);
    }

    public User getUser(String username) {
        return userRepository.getUser(username.toLowerCase());
    }

    public boolean checkUniqUsername(String username) {
        return !userRepository.checkUsername(username);
    }

    public void createUser(String name, String username, String password) {
        User user = new User(name, username, password);
        userRepository.addUser(user);
    }

    public void deleteUser(int userId) {
        userRepository.deleteUser(userId);
    }
}
