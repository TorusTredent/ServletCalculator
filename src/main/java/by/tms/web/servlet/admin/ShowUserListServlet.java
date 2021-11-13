package by.tms.web.servlet.admin;

import by.tms.entity.User;
import by.tms.service.user.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(value = "/userList", name = "ShowUserListServlet")
public class ShowUserListServlet extends HttpServlet {

    private final AdminService admin = new AdminService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/home/admin/usersList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userNumber = req.getParameter("userNumber");
        String operation = req.getParameter("operation");

        List<User> list = (List<User>) req.getSession().getAttribute("userList");
        User user = list.get(Integer.parseInt(userNumber));

        if (operation.equals("history")) {
            req.getSession().setAttribute("chooseUser", user);
            resp.sendRedirect("/pages/home/admin/user_operation_history.jsp");
            return;
        }


        try {
            list = admin.performOperation(list, user, operation, userNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getSession().setAttribute("userList", list);

        getServletContext().getRequestDispatcher("/pages/home/admin/usersList.jsp").forward(req, resp);
    }
}
