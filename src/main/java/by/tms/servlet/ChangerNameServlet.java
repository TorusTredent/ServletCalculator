package by.tms.servlet;

import by.tms.entity.User;
import by.tms.service.imp.ChangerImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (value = "/changerName", name = "ChangerNameServlet")
public class ChangerNameServlet extends HttpServlet {

    private final ChangerImp changer = new ChangerImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newName = req.getParameter("newName");

        User user = (User) req.getSession().getAttribute("user");

        if (changeName(user, newName)) {
            resp.getWriter().println("Changes complete");
        } else {
            resp.getWriter().println("New name not entered");
        }
    }



    private boolean changeName(User user, String newName) {
        if (newName == null || newName.isEmpty()) {
            return false;
        }
        changer.changeName(user, newName);
        return true;
    }
}
