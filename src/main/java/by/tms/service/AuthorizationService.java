package by.tms.service;

import by.tms.entity.User;

public interface AuthorizationService {
    boolean checkUsername(String username);
    boolean checkPassword(String password, String username);
    User getUser(String username);
}
