package hospital.controllers.Visits;

import hospital.models.Visit;
import hospital.services.TempAttributesToObj;
import hospital.services.VisitService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createVisit")
public class CreateVisit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("windows-1251");
        Visit instance = TempAttributesToObj.getVisit(request);//TODO replace with JS get object from Form
        VisitService.create(instance);
        response.sendRedirect("/patientsView");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int patientId = Integer.parseInt(request.getParameter("patientId"));
        request.setAttribute("patientId", patientId);
        request.getRequestDispatcher("/Views/createVisitForm.jsp").forward(request, response);
    }
}
