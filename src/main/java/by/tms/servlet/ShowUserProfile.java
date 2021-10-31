package by.tms.servlet;

import by.tms.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/profile", name = "ShowUserProfile")
public class ShowUserProfile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/home/profile/show_user_profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<String> list = new ArrayList<>();
        list.add("Your date: ");
        list.add("Name: " + user.getName());
        list.add("Username: " + user.getUsername());
        list.add("Password: " + user.getPassword());
        req.getSession().setAttribute("userProfile", list);
        getServletContext().getRequestDispatcher("/pages/home/profile/show_user_profile.jsp").forward(req, resp);
    }
}
