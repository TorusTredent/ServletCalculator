package by.tms.service;

import by.tms.repository.UserRepository;

public class DeleteUserService {

    public void deleteUser(int userId) {
        UserRepository.deleteUser(userId);
    }
}
