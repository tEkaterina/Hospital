package hospital.controllers.Patient;

import hospital.models.Address;
import hospital.models.Patient;
import hospital.models.User;
import hospital.repositories.concrete.Repository;
import hospital.services.PatientService;
import hospital.services.TempAttributesToObj;
import hospital.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/createPatient")
public class CreatePatient extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("windows-1251");
        Patient addedPatient = TempAttributesToObj.getPatient(request); //TODO replace with JS get object from Form
        PatientService.create(addedPatient);
        response.sendRedirect("/patientsView");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("currentUser");
        request.setAttribute("partialPage", "/Views/createPatientForm.jsp");
        request.setAttribute("activeNavPill", "patient");
        request.getRequestDispatcher(UserService.getTemplatePage(user)).forward(request, response);
    }
}
