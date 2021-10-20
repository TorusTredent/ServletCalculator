package by.tms.servlet;


import by.tms.service.imp.RegistrationServiceImp;
import by.tms.storage.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final RegistrationServiceImp registration = new RegistrationServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (!checkInputValuesForNull(name, username, password)) {
            resp.getWriter().println("Name, username or password not entered");
        } else {
            if (checkNewUsername(username)) {
                createUser(name, username, password);
                resp.getWriter().println("User create!");
            } else {
                resp.getWriter().println("Username is already used");
            }
        }
    }


    private void createUser(String name, String username, String password) {
        registration.createUser(name, username, password);
    }

    private boolean checkInputValuesForNull(String name, String username, String password) {
        if (name != null && username != null && password != null) {
            return !name.isEmpty() && !username.isEmpty() && !password.isEmpty();
        }
        return false;
    }

    private boolean checkNewUsername(String username) {
        if (UserStorage.listIsEmpty()) {
            return true;
        } else {
            return registration.checkNewUsernameInMemory(username);
        }
    }

}