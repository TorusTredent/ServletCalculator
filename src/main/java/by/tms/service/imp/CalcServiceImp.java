package by.tms.service.imp;

import by.tms.service.CalcService;
import by.tms.storage.CalculatorStorage;

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
    public void addCalculatedInMemory(String calculated) {
        CalculatorStorage.addOperation(calculated);
    }
}
