package by.tms.security;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"RegistrationServlet"})
public class RegistrationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (checkInputValuesForNull(name, username, password)) {
            chain.doFilter(req, res);
        } else {
            res.getWriter().println("Name, username or password not entered");
        }
    }

    private boolean checkInputValuesForNull(String name, String username, String password) {
        if (name != null && username != null && password != null) {
            return !name.isEmpty() && !username.isEmpty() && !password.isEmpty();
        }
        return false;
    }
}
