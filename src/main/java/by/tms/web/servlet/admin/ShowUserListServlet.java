package by.tms.web.servlet.admin;

import by.tms.entity.User;
import by.tms.service.user.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/userList", name = "ShowUserListServlet")
public class ShowUserListServlet extends HttpServlet {

    private final AdminService admin = new AdminService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("pages/home/admin/usersList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("userList") == null) {
            List<User> userList = admin.getUserList();
            if (userList.isEmpty()) {
                req.setAttribute("message", "List is empty");
            } else {
                req.getSession().setAttribute("userList", userList);
            }
        }

       
    }
}
