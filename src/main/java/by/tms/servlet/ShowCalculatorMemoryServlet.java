package by.tms.servlet;

import by.tms.storage.CalculatorStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/showHistory", name = "ShowCalculatorMemoryServlet")
public class ShowCalculatorMemoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> history = CalculatorStorage.getHistoryList();

        if (!history.isEmpty()) {
            for (String list : history) {
                resp.getWriter().println(list);
            }
        } else {
            resp.getWriter().println("History is empty");
        }

    }
}
