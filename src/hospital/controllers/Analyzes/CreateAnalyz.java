package hospital.controllers.Analyzes;

import hospital.models.Analysis;
import hospital.services.AnalyzService;
import hospital.services.TempAttributesToObj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createAnalyz")
public class CreateAnalyz extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("windows-1251");
        Analysis instance = TempAttributesToObj.getAnalysis(request); //TODO replace with JS get object from Form
        AnalyzService.create(instance);
        response.sendRedirect("/patientsView");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int visitId = Integer.parseInt(request.getParameter("visitId"));
        request.setAttribute("visitId", visitId);
        request.getRequestDispatcher("/Views/createAnalyzForm.jsp").forward(request, response);
    }
}
