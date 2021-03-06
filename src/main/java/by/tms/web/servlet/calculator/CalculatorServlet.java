package by.tms.web.servlet.calculator;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.calc.CalcService;
import by.tms.service.calc.ShowService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(value = "/calc", name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

    private final CalcService calc = new CalcService();
    private final ShowService showService = new ShowService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/pages/home/calculator/calculator.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String operation = req.getParameter("operation");

        if (!checkInputValueForNull(num1, num2, operation)) {
            req.setAttribute("alert", "Number 1, number2 or operation not entered");
        } else {
            if (checkValues(num1, num2, operation)) {
                User user = (User) req.getSession().getAttribute("user");

                Operation oper = new Operation(num1, num2, operation, String.valueOf(getValue(num1, num2, operation)), user.getId());
                oper.setResult(String.valueOf(getValue(num1, num2, operation)));
                addCalculatedInMemory(oper);

                String calculated = "Operation " + oper.getOperation() + " = " + oper.getResult();
                req.setAttribute("calcMessage", calculated);

                List<String> list = showService.showOperations(user.getId());
                req.getSession().setAttribute("operationList", list);
            } else {
                req.setAttribute("alert", "Incorrect data entered");
            }
        }
        getServletContext().getRequestDispatcher("/pages/home/calculator/calculator.jsp").forward(req, resp);
    }

    private void addCalculatedInMemory(Operation operation) {
        calc.addCalculatedInMemory(operation);
    }

    private double getValue(String num1, String num2, String operation) {
        switch (operation) {
            case "sum": {
                return calc.sum(num1, num2);
            }
            case "sub": {
                return calc.sub(num1, num2);
            }
            case "multiply": {
                return calc.multiply(num1, num2);
            }
            case "div": {
                return calc.div(num1, num2);
            }
        }
        return 0;
    }

    private boolean checkInputValueForNull(String num1, String num2, String operation) {
        if (num1 != null && num2 != null && operation != null) {
            return !num1.isEmpty() && !num2.isEmpty() && !operation.isEmpty();
        }
        return false;
    }

    private boolean checkValues(String num1, String num2, String operation) {
        boolean hasDigitNum1 = num1.matches("[\\d]+");
        if (!hasDigitNum1) {
            return false;
        }
        boolean hasDigitNum2 = num2.matches("[\\d]+");
        if (!hasDigitNum2) {
            return false;
        }
        switch (operation) {
            case "sum":
            case "sub":
            case "multiply":
            case "div": {
                return true;
            }
            default: {
                return false;
            }
        }
    }
}
