package by.tms.web.filter;

import by.tms.entity.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter(servletNames = {"CalculatorServlet", "ChangerPasswordServlet", "ChangerNameServlet",
        "DeleteUserProfileServlet", "LogOut", "RemoveOperationListServlet", "ShowCalculatorMemoryServlet",
        "ShowUserProfileServlet"})
public class AuthFilter extends HttpFilter {
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        User user = (User) req.getAttribute("user");
//
//        if (user != null) {
//            chain.doFilter(req, res);
//        } else {
//            res.sendRedirect("/pages/home/home.jsp");
//        }
//    }
}
