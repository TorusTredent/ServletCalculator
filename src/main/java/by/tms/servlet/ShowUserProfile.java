package by.tms.servlet;

import by.tms.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/profile", name = "ShowUserProfile")
public class ShowUserProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        resp.getWriter().println("Your date: ");
        resp.getWriter().println("Name: " + user.getName());
        resp.getWriter().println("Username: " + user.getUsername());
        resp.getWriter().println("Password: " + user.getPassword());
    }
}
