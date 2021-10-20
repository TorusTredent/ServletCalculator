package by.tms.servlet;

import by.tms.entity.User;
import by.tms.service.imp.ChangerImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (value = "/changerPassword", name = "ChangerPasswordServlet")
public class ChangerPasswordServlet extends HttpServlet {

    private final ChangerImp changer = new ChangerImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newPassword = req.getParameter("newPassword");

        User user = (User) req.getSession().getAttribute("user");

        if (changePassword(user, newPassword)) {
            resp.getWriter().println("Changes complete");
        } else {
            resp.getWriter().println("New password not entered");

        }
    }

    private boolean changePassword (User user, String newPassword) {
        if (newPassword == null || newPassword.isEmpty()) {
            return false;
        }
        changer.changePassword(user, newPassword);
        return true;
    }

}
