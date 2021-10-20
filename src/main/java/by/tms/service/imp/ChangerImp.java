package by.tms.service.imp;

import by.tms.entity.User;
import by.tms.service.Changer;
import by.tms.storage.UserStorage;

public class ChangerImp implements Changer {
    @Override
    public void changeName(User user, String newName) {
        UserStorage.changeName(user, newName);
    }

    @Override
    public void changePassword(User user, String newPassword) {
        UserStorage.changePassword(user, newPassword);
    }
}
