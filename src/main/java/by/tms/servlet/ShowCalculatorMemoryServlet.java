package by.tms.servlet;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.ShowService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(value = "/show_history", name = "ShowCalculatorMemoryServlet")
public class ShowCalculatorMemoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/home/calculator/show_calc_history.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String hide = req.getParameter("hide");
        String show = req.getParameter("show");

        if (hide != null) {
            req.getSession().setAttribute("operationList", null);
        }

        if (show != null) {
            List<Operation> list = getOperationList(user.getId());
            if (list.isEmpty()) {
                req.getSession().setAttribute("operationList", null);
            } else {
                req.getSession().setAttribute("operationList", prepareToAttribute(list));
            }
        }

        getServletContext().getRequestDispatcher("/pages/home/calculator/show_calc_history.jsp").forward(req, resp);
    }

    private List<String> prepareToAttribute(List<Operation> list) {
        List<String> operationList = new ArrayList<>();
        for (Operation value : list) {
            operationList.add("Operation " + value.getOperation() + " = " + value.getResult());
        }
        Collections.reverse(operationList);
        return operationList;
    }


    private List<Operation> getOperationList(int userId) {
        ShowService show = new ShowService();
        return show.showOperations(userId);
    }
}
