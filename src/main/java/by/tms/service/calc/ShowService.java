package by.tms.service.calc;

import by.tms.entity.Operation;
import by.tms.repository.CalculatorRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ShowService {

    private final CalculatorRepository calcRepository = new CalculatorRepository();

    public List<String> showOperations(int userId) {
        LinkedList<Operation> list = calcRepository.getOperationList(userId);
        return prepareToAttribute(list);
    }

    private List<String> prepareToAttribute(List<Operation> list) {
        List<String> operationList = new ArrayList<>();
        for (Operation value : list) {
            operationList.add("Operation " + value.getOperation() + " = " + value.getResult());
        }
        Collections.reverse(operationList);
        return operationList;
    }
}
