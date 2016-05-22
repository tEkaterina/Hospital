package hospital.controllers.Patient;
import hospital.models.Patient;
import hospital.models.User;
import hospital.repositories.concrete.Repository;
import hospital.services.PatientService;
import hospital.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/patientsView")
public class ReadPatients extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("patients", PatientService.getAll());
        request.setAttribute("partialPage", "/Views/patientsView.jsp");
        request.setAttribute("activeNavPill", "patient");
        User user = (User) request.getSession().getAttribute("currentUser");
        request.getRequestDispatcher(UserService.getTemplatePage(user)).forward(request, response);
    }
}
