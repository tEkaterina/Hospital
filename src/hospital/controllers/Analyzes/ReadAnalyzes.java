package hospital.controllers.Analyzes;

import hospital.models.User;
import hospital.services.UserService;
import hospital.services.VisitService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/analyzes")
public class ReadAnalyzes extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null){
            id = request.getSession().getAttribute("id").toString();
            request.getSession().removeAttribute("id");
        }
        int visitId = Integer.parseInt(id);
        request.setAttribute("analyzes", VisitService.getAnalyzes(visitId));
        request.setAttribute("visit", VisitService.getById(visitId));
        request.setAttribute("partialPage", "/Views/analysisView.jsp");

        User user = (User) request.getSession().getAttribute("currentUser");
        request.getRequestDispatcher(UserService.getTemplatePage(user)).forward(request, response);
    }
}
