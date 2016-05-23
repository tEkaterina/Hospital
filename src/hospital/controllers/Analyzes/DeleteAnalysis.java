package hospital.controllers.Analyzes;

import hospital.models.Analysis;
import hospital.services.AnalyzService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteAnalyzes")
public class DeleteAnalysis extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int visitId = Integer.parseInt(request.getParameter("visitId"));
        AnalyzService.delete(id);
        response.sendRedirect("/analyzes?id="+visitId);
    }
}
