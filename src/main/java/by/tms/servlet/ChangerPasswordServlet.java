package by.tms.servlet;

import by.tms.entity.User;
import by.tms.service.imp.ChangerImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (value = "/changer_password", name = "ChangerPasswordServlet")
public class ChangerPasswordServlet extends HttpServlet {

    private final ChangerImp changer = new ChangerImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newPassword = req.getParameter("password");

        User user = (User) req.getSession().getAttribute("user");

        if (checkPasswordForNull(newPassword)) {
            changePassword(user.getId(), newPassword);
            resp.getWriter().println("Changes complete");
        } else {
            resp.getWriter().println("New password not entered");

        }
    }


    private boolean checkPasswordForNull(String password) {
        return password != null && !password.isEmpty();

    }

    private void changePassword (int userId, String newPassword) {
        changer.changePassword(userId, newPassword);
    }
}
