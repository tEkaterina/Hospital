package hospital.controllers.Visits;

import hospital.models.Patient;
import hospital.models.Visit;
import hospital.repositories.concrete.Repository;
import hospital.services.PatientService;
import hospital.services.TempAttributesToObj;
import hospital.services.VisitService;

import javax.servlet.RequestDispatcher;
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

        response.sendRedirect("/patientVisits?patientId=" + instance.getPatient().getId());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
