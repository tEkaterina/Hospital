package hospital.controllers.Doctor;

import hospital.models.Doctor;
import hospital.models.User;
import hospital.repositories.concrete.Repository;
import hospital.services.DoctorService;
import hospital.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/doctorsView")
public class ReadDoctors extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("doctors", DoctorService.getAll());
        User user = (User)request.getSession().getAttribute("currentUser");
        request.setAttribute("partialPage", "/Views/doctorsView.jsp");
        request.setAttribute("activeNavPill", "doctor");
        request.getRequestDispatcher(UserService.getTemplatePage(user)).forward(request, response);
    }
}
