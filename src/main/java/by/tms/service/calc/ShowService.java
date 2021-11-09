package by.tms.service.calc;

import by.tms.entity.Operation;
import by.tms.repository.CalculatorRepository;

import java.util.LinkedList;

public class ShowService {

    private final CalculatorRepository calcRepository = new CalculatorRepository();

    public LinkedList<Operation> showOperations(int userId) {
        return calcRepository.getOperationList(userId);
    }
}
