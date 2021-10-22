package by.tms.servlet;

import by.tms.entity.User;
import by.tms.service.imp.ShowServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/show_history", name = "ShowCalculatorMemoryServlet")
public class ShowCalculatorMemoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        List<String> operationList = getOperationList(user.getId());

        if (!operationList.isEmpty()) {
            for (int i = operationList.size() - 1; i >= 0; i--) {
                resp.getWriter().println(operationList.get(i));
            }
        } else {
            resp.getWriter().println("List of operations is empty");
        }

    }

    private List<String> getOperationList (int userId) {
        ShowServiceImp show = new ShowServiceImp();
        return show.showOperations(userId);
    }
}
