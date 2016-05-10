package hospital.controllers.Visits;

import hospital.models.User;
import hospital.services.DoctorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doctorVisit")
public class ReadDoctorVisit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User)request.getSession().getAttribute("currentUser");
        request.setAttribute("visits", DoctorService.getVisits(user.getDoctor().getId()));
        request.getRequestDispatcher("/Views/doctor'sVisitsView.jsp").forward(request, response);
    }
}
