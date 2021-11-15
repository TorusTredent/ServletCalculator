package by.tms.web.servlet.user;

import by.tms.entity.User;
import by.tms.service.user.ChangerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (value = "/changer_name", name = "ChangerNameServlet")
public class ChangerNameServlet extends HttpServlet {

    private final ChangerService changer = new ChangerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/home/profile/change_name.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newName = req.getParameter("name");

        User user = (User) req.getSession().getAttribute("user");

        if (checkForNull(newName)) {
            changeName(user.getId(), newName);
            user.setName(newName);
            req.setAttribute("message", "Changes complete ");
        } else {
            req.setAttribute("alert", "New name not entered");
        }
        getServletContext().getRequestDispatcher("/pages/home/profile/change_name.jsp").forward(req, resp);
    }

    private boolean checkForNull(String newName) {
        return newName != null && !newName.isEmpty();
    }

    private void changeName(int userId, String newName) {
        changer.changeName(userId, newName);
    }
}
