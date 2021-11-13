package by.tms.service.user;

import by.tms.entity.User;
import by.tms.repository.UserRepository;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AdminService {

    private final UserRepository userRepo = new UserRepository();

    public List<User> getUserList() {
        return userRepo.getUserList();
    }

    public List<User> performOperation(List<User> list, User user, String operation, String userNumber) throws SQLException {
        switch (operation) {
            case "addAdmin": {
                if (!user.getStatus().equals("admin")) {
                    User modifyUser = addAdminStatus(user);
                    int number = Integer.parseInt(userNumber);
                    list.set(number, modifyUser);
                }
                return list;
            }
            case "removeAdmin": {
                if (user.getStatus().equals("admin")) {
                    User modifyUser = removeAdminStatus(user);
                    int number = Integer.parseInt(userNumber);
                    list.set(number, modifyUser);
                }
                return list;
            }
            case "deleteUser": {
                deleteUser(user);
                list.remove(user);
                return list;
            }
        }
        return null;
    }

    private User addAdminStatus(User user) {
        user.setStatus("admin");
        userRepo.addAdminStatus(user.getId());
        return user;
    }

    private User removeAdminStatus(User user) {
        user.setStatus("user");
        userRepo.removeAdminStatus(user.getId());
        return user;
    }

    private void deleteUser(User user) {
        userRepo.deleteUser(user.getId());
    }

}