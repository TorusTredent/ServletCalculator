package by.tms.security;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"CalculatorServlet"})
public class CalculatorFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String operation = req.getParameter("operate");

        if (!checkInputValueForNull(num1, num2, operation)) {
            res.getWriter().println("Number 1, number2 or operation not entered");
        } else {
            if (checkValues(num1, num2, operation)) {
                chain.doFilter(req, res);
            } else {
                res.getWriter().println("Incorrect data entered");
            }
        }
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

    private boolean checkInputValueForNull(String num1, String num2, String operation) {
        if (num1 != null && num2 != null && operation != null) {
            return !num1.isEmpty() && !num2.isEmpty() && !operation.isEmpty();
        }
        return false;
    }
}
