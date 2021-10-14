package by.tms;

public class ServiceImpCalc implements ServiceCalcul{

    @Override
    public String sum(String num1, String num2) {
        if (checkValue(num1, num2)) {
            double numb1 = Double.parseDouble(num1);
            double numb2 = Double.parseDouble(num2);
            double sum = numb1 + numb2;
            return String.valueOf(sum);
        }else {
            return null;
        }
    }

    @Override
    public String sub(String num1, String num2) {
        if (checkValue(num1, num2)) {
            double numb1 = Double.parseDouble(num1);
            double numb2 = Double.parseDouble(num2);
            double sub = numb1 - numb2;
            return String.valueOf(sub);
        } else {
            return null;
        }
    }

    @Override
    public String multiply(String num1, String num2) {
        if (checkValue(num1, num2)) {
            double numb1 = Double.parseDouble(num1);
            double numb2 = Double.parseDouble(num2);
            double multiply = numb1 * numb2;
            return String.valueOf(multiply);
        } else {
            return null;
        }
    }

    @Override
    public String div(String num1, String num2) {
        if (checkValue(num1, num2)) {
            double numb1 = Double.parseDouble(num1);
            double numb2 = Double.parseDouble(num2);
            double div = numb1 / numb2;
            return String.valueOf(div);
        } else {
            return null;
        }
    }

    private boolean checkValue(String num1, String num2) {
        boolean hasDigitNum1 = num1.matches("[\\d]+");
        boolean hasDigitNum2 = num1.matches("[\\d]+");
        return hasDigitNum1 && hasDigitNum2;
    }
}
