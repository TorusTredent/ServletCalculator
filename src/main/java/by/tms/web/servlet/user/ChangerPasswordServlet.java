package by.tms.web.servlet.user;

import by.tms.entity.User;
import by.tms.service.user.ChangerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (value = "/changer_password", name = "ChangerPasswordServlet")
public class ChangerPasswordServlet extends HttpServlet {

    private final ChangerService changer = new ChangerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/home/profile/change_password.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newPassword = req.getParameter("password");

        User user = (User) req.getSession().getAttribute("user");

        if (checkPasswordForNull(newPassword)) {
            changePassword(user.getId(), newPassword);
            user.setPassword(newPassword);
            req.setAttribute("message", "Changes complete ");
        } else {
            req.setAttribute("alert", "New password not entered");
        }
        getServletContext().getRequestDispatcher("/pages/home/profile/change_password.jsp").forward(req, resp);
    }

    private boolean checkPasswordForNull(String password) {
        return password != null && !password.isEmpty();

    }

    private void changePassword (int userId, String newPassword) {
        changer.changePassword(userId, newPassword);
    }
}
