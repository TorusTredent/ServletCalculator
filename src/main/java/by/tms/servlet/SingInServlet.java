package by.tms.servlet;

import by.tms.entity.User;
import by.tms.service.imp.SingInServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/authorization", name = "AuthorizationServlet")
public class SingInServlet extends HttpServlet {

    private final SingInServiceImp auth = new SingInServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (checkData(username, password)) {
            User user = getUser(username);
            req.getSession().setAttribute("user", user);
            resp.getWriter().println("You are logged in account");
        } else {
            resp.getWriter().println("Username or password entered incorrectly ");
        }

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