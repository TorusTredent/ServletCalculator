package by.tms.servlet;

import by.tms.entity.User;
import by.tms.service.imp.AuthorizationServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/authorization")
public class AuthorizationServlet extends HttpServlet {

    private final AuthorizationServiceImp auth = new AuthorizationServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (checkInputValuesForNull(username, password)) {
            resp.getWriter().println("Username or password not entered ");
        } else {
            if (checkValues(username.toLowerCase(), password)) {
                User user = getUser(username.toLowerCase());
                req.getSession().setAttribute("user", user);
                resp.getWriter().println("You are logged in account");
            } else {
                resp.getWriter().println("Username or password entered incorrectly ");
            }
        }
    }

    private boolean checkInputValuesForNull(String username, String password) {
        return username == null || password == null;
    }

    private boolean checkValues(String username, String password) {
        if (auth.checkUsername(username)) {
            return auth.checkPassword(password);
        } else {
            return false;
        }
    }

    private User getUser(String username) {
        return auth.getUser(username);
    }
}
