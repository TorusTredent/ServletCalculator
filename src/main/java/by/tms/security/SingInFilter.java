package by.tms.security;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"AuthorizationServlet"})
public class SingInFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (!checkInputValuesForNull(username, password)) {
            chain.doFilter(req, res);
        } else {
            res.getWriter().println("Username or password not entered");
        }

    }

    private boolean checkInputValuesForNull(String username, String password) {
        if (username == null || password == null) {
            return true;
        }
        return username.isEmpty() || password.isEmpty();
    }
}