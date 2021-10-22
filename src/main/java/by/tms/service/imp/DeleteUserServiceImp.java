package by.tms.service.imp;

import by.tms.repository.UserRepository;
import by.tms.service.DeleteUserService;

public class DeleteUserServiceImp implements DeleteUserService {
    @Override
    public void deleteUser(int userId) {
        UserRepository.deleteUser(userId);
    }
}
