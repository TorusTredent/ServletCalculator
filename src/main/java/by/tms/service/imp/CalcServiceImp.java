package by.tms.service.imp;

import by.tms.repository.CalculatorRepository;
import by.tms.service.CalcService;

public class CalcServiceImp implements CalcService {

    @Override
    public Double sum(String num1, String num2) {
        double numb1 = Double.parseDouble(num1);
        double numb2 = Double.parseDouble(num2);
        return numb1 + numb2;
    }

    @Override
    public Double sub(String num1, String num2) {
        double numb1 = Double.parseDouble(num1);
        double numb2 = Double.parseDouble(num2);
        return numb1 - numb2;
    }

    @Override
    public Double multiply(String num1, String num2) {
        double numb1 = Double.parseDouble(num1);
        double numb2 = Double.parseDouble(num2);
        return numb1 * numb2;
    }

    @Override
    public Double div(String num1, String num2) {
        double numb1 = Double.parseDouble(num1);
        double numb2 = Double.parseDouble(num2);
        return numb1 / numb2;
    }

    @Override
    public void addCalculatedInMemory(String calculated, int userId) {
        CalculatorRepository.addOperation(calculated, userId);
    }

    @Override
    public void removeAllOperations(int userId) {
        CalculatorRepository.removeAllOperations(userId);
    }
}
