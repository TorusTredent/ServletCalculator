package by.tms.service.imp;

import by.tms.entity.User;
import by.tms.repository.UserRepository;
import by.tms.service.Changer;

public class ChangerImp implements Changer {
    @Override
    public void changeName(int userId, String newName) {
        UserRepository.changeName(userId, newName);
    }

    @Override
    public void changePassword(int userId, String newPassword) {
        UserRepository.changePassword(userId, newPassword);
    }
}
