package by.tms.service.imp;

import by.tms.entity.User;
import by.tms.repository.UserRepository;
import by.tms.service.AuthorizationService;

public class SingInServiceImp implements AuthorizationService {

    @Override
    public boolean checkUsername(String username) {
        return UserRepository.checkUsername(username);
    }

    @Override
    public boolean checkPassword(String password, String username) {
        return UserRepository.checkPassword(password, username);
    }

    @Override
    public User getUser(String username) {
        return UserRepository.getUser(username.toLowerCase());
    }
}
