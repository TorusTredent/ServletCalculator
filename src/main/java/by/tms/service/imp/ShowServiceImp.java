package by.tms.service.imp;

import by.tms.repository.CalculatorRepository;
import by.tms.service.ShowService;

import java.util.List;

public class ShowServiceImp implements ShowService {
    @Override
    public List<String> showOperations(int userId) {
        return CalculatorRepository.getOperationList(userId);
    }
}
