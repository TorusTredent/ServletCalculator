package by.tms.servlet;


import by.tms.service.imp.RegistrationServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/registration", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private final RegistrationServiceImp registration = new RegistrationServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (checkNewUsername(username)) {
            createUser(name, username, password);
            resp.getWriter().println("User create!");
        } else {
            resp.getWriter().println("Username is already used");
        }
    }


    private void createUser(String name, String username, String password) {
        registration.createUser(name, username, password);
    }

    private boolean checkNewUsername(String username) {
        return registration.checkUniqUsername(username);
    }

}