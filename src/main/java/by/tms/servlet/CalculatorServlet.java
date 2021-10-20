package by.tms.servlet;

import by.tms.service.imp.CalcServiceImp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/calc", name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

    private final CalcServiceImp calc = new CalcServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String operation = req.getParameter("operate");

        String calculated = "Operation = " + getValue(num1, num2, operation);
        addCalculatedInMemory(calculated);
        resp.getWriter().println(calculated);
    }

    private void addCalculatedInMemory(String calculated) {
        calc.addCalculatedInMemory(calculated);
    }


    private double getValue(String num1, String num2, String operation) {
        CalcServiceImp calc = new CalcServiceImp();
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
}
