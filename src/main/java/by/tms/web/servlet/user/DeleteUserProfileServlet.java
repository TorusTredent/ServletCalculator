package by.tms.web.servlet.user;

import by.tms.entity.User;
import by.tms.service.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/delete_profile", name = "DeleteUserProfileServlet")
public class DeleteUserProfileServlet extends HttpServlet {

    private final UserService delete = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        deleteUser(user.getId());
        req.getSession().invalidate();
        resp.sendRedirect("/pages/home/home.jsp");
    }

    private void deleteUser(int userId) {
        delete.deleteUser(userId);
    }
}
