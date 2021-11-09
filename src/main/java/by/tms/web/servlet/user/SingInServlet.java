package by.tms.web.servlet.user;

import by.tms.entity.User;
import by.tms.service.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/authorization", name = "AuthorizationServlet")
public class SingInServlet extends HttpServlet {

    private final UserService auth = new UserService();

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
                resp.sendRedirect("/pages/home/home.jsp");
                return;
            } else {
                req.setAttribute("message", "Username or password entered incorrectly ");
            }
        } else {
            req.setAttribute("message", "Username or password not entered");
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
