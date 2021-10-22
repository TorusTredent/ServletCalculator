package by.tms.service.imp;

import by.tms.entity.User;
import by.tms.repository.UserRepository;
import by.tms.service.RegistrationService;

public class RegistrationServiceImp implements RegistrationService {

    @Override
    public boolean checkUniqUsername(String username) {
        return !UserRepository.checkUsername(username);
    }

    @Override
    public void createUser(String name, String username, String password) {
        User user = new User(name, username, password);
        UserRepository.addUser(user);
    }
}
