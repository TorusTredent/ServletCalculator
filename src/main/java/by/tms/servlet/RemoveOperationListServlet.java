package by.tms.servlet;

import by.tms.entity.User;
import by.tms.service.CalcService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/remove_history", name = "RemoveOperationListServlet")
public class RemoveOperationListServlet extends HttpServlet {

    private final CalcService calc = new CalcService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        removeAllOperations(user.getId());
        req.getSession().setAttribute("operationList", null);
        resp.sendRedirect("/pages/home/calculator/calculator.jsp");
    }

    private void removeAllOperations(int userId) {
        calc.removeAllOperations(userId);
    }
}
