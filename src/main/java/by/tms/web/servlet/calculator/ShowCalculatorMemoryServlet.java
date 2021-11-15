package by.tms.web.servlet.calculator;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.calc.ShowService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@WebServlet(value = "/show_history", name = "ShowCalculatorMemoryServlet")
public class ShowCalculatorMemoryServlet extends HttpServlet {

    private final  ShowService showServ = new ShowService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/home/calculator/show_calc_history.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String hide = req.getParameter("hide");
        String show = req.getParameter("show");

        if (hide != null) {
            req.getSession().setAttribute("operationList", null);
        }

        if (show != null) {
            List<String> prepList = showServ.showOperations(user.getId());
            if (prepList.isEmpty()) {
                req.getSession().setAttribute("operationList", null);
            } else {
                req.getSession().setAttribute("operationList",prepList);
            }
        }
        getServletContext().getRequestDispatcher("/pages/home/calculator/show_calc_history.jsp").forward(req, resp);
    }
}
