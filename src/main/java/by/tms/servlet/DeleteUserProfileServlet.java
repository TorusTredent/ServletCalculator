package by.tms.servlet;

import by.tms.entity.User;
import by.tms.service.imp.DeleteUserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/delete_profile", name = "DeleteUserProfileServlet")
public class DeleteUserProfileServlet extends HttpServlet {

    private final DeleteUserServiceImp delete = new DeleteUserServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        deleteUser(user.getId());
        resp.getWriter().println("User delete");
        req.getSession().invalidate();
    }

    private void deleteUser(int userId) {
        delete.deleteUser(userId);
    }
}
