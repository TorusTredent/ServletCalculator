package by.tms.service.user;

import by.tms.entity.User;
import by.tms.repository.UserRepository;

import java.util.LinkedList;
import java.util.List;

public class AdminService {

    private final UserRepository user = new UserRepository();

    public List<User> getUserList () {
        return user.getUserList();
    }

}
