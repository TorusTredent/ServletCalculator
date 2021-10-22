package by.tms.service;

public interface RegistrationService {
    boolean checkUniqUsername(String username);
    void createUser(String name, String username, String password);
}
