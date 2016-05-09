package hospital.controllers.Visits;

import hospital.models.Patient;
import hospital.models.Visit;
import hospital.repositories.concrete.Repository;
import hospital.services.PatientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/patientVisits")
public class ReadPatientVisits extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int patientId = Integer.parseInt(request.getParameter("idPatient"));
        request.setAttribute("visits", PatientService.getVisits(patientId));
        request.setAttribute("patient", PatientService.getById(patientId));
        request.getRequestDispatcher("/Views/patient'sVisitsView.jsp").forward(request, response);

    }
}
