package by.tms.service;

public interface CalcService {
    Double sum(String num1, String num2);
    Double sub(String num1, String num2);
    Double multiply(String num1, String num2);
    Double div(String num1, String num2);
    void addCalculatedInMemory(String calculated);
}
