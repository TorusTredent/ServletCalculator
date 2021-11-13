package by.tms.web.servlet.admin;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.calc.ShowService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@WebServlet(value = "/userOperationList", name = "ShowUserOperationsServlet")
public class ShowUserOperationsServlet extends HttpServlet {

    private final ShowService showServ = new ShowService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/home/admin/user_operation_history.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hide = req.getParameter("hide");
        String show = req.getParameter("show");
        String back = req.getParameter("back");

        if (back != null) {
            req.getSession().setAttribute("adminOperationList", null);
            resp.sendRedirect("/pages/home/admin/usersList.jsp");
            return;
        }

        User user = (User) req.getSession().getAttribute("chooseUser");

        if (hide != null) {
            req.getSession().setAttribute("adminOperationList", null);
        }

        if (show != null) {
            LinkedList<Operation> operationList = showServ.showOperations(user.getId());
            if (operationList.isEmpty()) {
                req.getSession().setAttribute("adminOperationList", null);
            } else {
                req.getSession().setAttribute("adminOperationList", prepareToAttribute(operationList));
            }
        }
        getServletContext().getRequestDispatcher("/pages/home/admin/user_operation_history.jsp").forward(req, resp);
    }

    private List<String> prepareToAttribute(List<Operation> list) {
        List<String> operationList = new ArrayList<>();
        for (Operation value : list) {
            operationList.add("Operation " + value.getOperation() + " = " + value.getResult());
        }
        Collections.reverse(operationList);
        return operationList;
    }


}
