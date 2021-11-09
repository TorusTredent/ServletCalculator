package by.tms.service.user;

import by.tms.repository.UserRepository;

public class ChangerService {

    private final UserRepository userRepository = new UserRepository();

    public void changeName(int userId, String newName) {
        userRepository.changeName(userId, newName);
    }

    public void changePassword(int userId, String newPassword) {
        userRepository.changePassword(userId, newPassword);
    }
}
