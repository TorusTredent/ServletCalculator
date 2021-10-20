package by.tms.service;

public interface RegistrationService {
    boolean checkNewUsernameInMemory(String username);
    void createUser(String name, String username, String password);
}
