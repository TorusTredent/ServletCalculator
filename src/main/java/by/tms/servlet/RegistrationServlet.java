package by.tms.servlet;


import by.tms.service.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/registration", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private final RegistrationService registration = new RegistrationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/home/auth/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (checkInputValuesForNull(name, username, password)) {
            if (checkNewUsername(username)) {
                createUser(name, username, password);
                resp.sendRedirect("/pages/home/home.jsp");
                return;
            } else {
                req.setAttribute("message", "Username is already used");
            }
        } else {
            req.setAttribute("message","Name, username or password not entered");
        }
        getServletContext().getRequestDispatcher("/pages/home/auth/registration.jsp").forward(req, resp);
    }

    private boolean checkInputValuesForNull(String name, String username, String password) {
        if (name != null && username != null && password != null) {
            return !name.isEmpty() && !username.isEmpty() && !password.isEmpty();
        }
        return false;
    }

    private void createUser(String name, String username, String password) {
        registration.createUser(name, username, password);
    }

    private boolean checkNewUsername(String username) {
        return registration.checkUniqUsername(username);
    }

}