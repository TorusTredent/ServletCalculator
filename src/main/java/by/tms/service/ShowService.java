package by.tms.service;

import by.tms.entity.Operation;
import by.tms.repository.CalculatorRepository;

import java.util.List;

public class ShowService {

    public List<Operation> showOperations(int userId) {
        return CalculatorRepository.getOperationList(userId);
    }
}
