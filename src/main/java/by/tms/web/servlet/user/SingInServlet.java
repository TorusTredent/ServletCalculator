package by.tms.web.servlet.user;

import by.tms.entity.User;
import by.tms.service.calc.ShowService;
import by.tms.service.user.AdminService;
import by.tms.service.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(value = "/authorization", name = "AuthorizationServlet")
public class SingInServlet extends HttpServlet {

    private final UserService auth = new UserService();
    private final AdminService admin = new AdminService();
    private final ShowService showService = new ShowService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/home/auth/singIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (!checkInputValuesForNull(username, password)) {
            if (checkData(username, password)) {
                User user = getUser(username);
                req.getSession().setAttribute("user", user);
                if (user.getStatus().equals("admin")) {
                    req.getSession().setAttribute("userList", admin.getUserList());
                }
                List<String> operationList = showService.showOperations(user.getId());
                req.getSession().setAttribute("operationList", operationList);
                resp.sendRedirect("/pages/home/home.jsp");
                return;
            } else {
                req.setAttribute("alert", "Username or password entered incorrectly ");
            }
        } else {
            req.setAttribute("alert", "Username or password not entered");
        }
        getServletContext().getRequestDispatcher("/pages/home/auth/singIn.jsp").forward(req, resp);
    }

    private boolean checkInputValuesForNull(String username, String password) {
        if (username == null || password == null) {
            return true;
        }
        return username.isEmpty() || password.isEmpty();
    }

    private boolean checkData(String username, String password) {
        if (auth.checkUsername(username)) {
            return auth.checkPassword(password, username);
        }
        return false;
    }

    private User getUser(String username) {
        return auth.getUser(username);
    }
}
