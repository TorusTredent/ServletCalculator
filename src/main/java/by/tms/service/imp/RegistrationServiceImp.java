package by.tms.service.imp;

import by.tms.entity.User;
import by.tms.service.RegistrationService;
import by.tms.storage.UserStorage;

public class RegistrationServiceImp implements RegistrationService {

    @Override
    public boolean checkNewUsernameInMemory(String username) {
        return UserStorage.checkUniqUsername(username);
    }

    @Override
    public void createUser(String name, String username, String password) {
        User user = new User(name, username, password);
        UserStorage.addUser(user);
    }
}
