package by.tms.service;

import by.tms.entity.Operation;
import by.tms.repository.CalculatorRepository;

public class CalcService{
    public Double sum(String num1, String num2) {
        double numb1 = Double.parseDouble(num1);
        double numb2 = Double.parseDouble(num2);
        return numb1 + numb2;
    }
    public Double sub(String num1, String num2) {
        double numb1 = Double.parseDouble(num1);
        double numb2 = Double.parseDouble(num2);
        return numb1 - numb2;
    }

    public Double multiply(String num1, String num2) {
        double numb1 = Double.parseDouble(num1);
        double numb2 = Double.parseDouble(num2);
        return numb1 * numb2;
    }

    public Double div(String num1, String num2) {
        double numb1 = Double.parseDouble(num1);
        double numb2 = Double.parseDouble(num2);
        return numb1 / numb2;
    }

    public void addCalculatedInMemory(Operation operation) {
        CalculatorRepository.addOperation(operation);
    }

    public void removeAllOperations(int userId) {
        CalculatorRepository.removeAllOperations(userId);
    }
}
