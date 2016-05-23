package hospital.controllers.Visits;

//import hospital.services.VisitService;

import hospital.models.User;
import hospital.services.UserService;
import hospital.services.VisitService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteVisit")
public class DeleteVisit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        VisitService.delete(id);

        User user = (User) request.getSession().getAttribute("currentUser");

        String patientId = request.getParameter("patientId");
        if (patientId != null) {
            response.sendRedirect("/patientVisits?patientId" + patientId);
        }else if(user != null && user.getRoleName().equals(User.RoleName.Doctor)){
            response.sendRedirect("/doctorVisit");
        }else{
            response.sendRedirect(UserService.getTemplatePage(user));
        }
    }
}
