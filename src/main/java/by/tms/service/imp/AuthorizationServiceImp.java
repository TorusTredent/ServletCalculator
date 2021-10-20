package by.tms.service.imp;

import by.tms.entity.User;
import by.tms.service.AuthorizationService;
import by.tms.storage.UserStorage;

public class AuthorizationServiceImp implements AuthorizationService {

    @Override
    public boolean checkUsername(String username) {
        return UserStorage.checkUsername(username);
    }

    @Override
    public boolean checkPassword(String password) {
        return UserStorage.checkPassword(password);
    }

    @Override
    public User getUser(String username) {
        return UserStorage.getUser(username);
    }
}
