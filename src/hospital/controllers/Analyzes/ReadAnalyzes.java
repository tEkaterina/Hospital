package hospital.controllers.Analyzes;

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

        int visitId = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("analyzes", VisitService.getAnalyzes(visitId));
        request.setAttribute("visit", VisitService.getById(visitId));
        request.getRequestDispatcher("/Views/analysisView.jsp").forward(request, response);
    }
}
