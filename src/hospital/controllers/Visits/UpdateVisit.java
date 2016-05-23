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


@WebServlet("/updateVisit")
public class UpdateVisit extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("windows-1251");
        int id = Integer.parseInt(request.getParameter("id"));
        String comment = request.getParameter("comment");
        VisitService.update(id, comment);

        User user = (User) request.getSession().getAttribute("currentUser");

        String patientId = request.getParameter("patientId");
        if (patientId != null) {
            response.sendRedirect("/patientVisits?patientId="+patientId);
        }else if(user != null && user.getRoleName().equals(User.RoleName.Doctor)){
            response.sendRedirect("/doctorVisit");
        }else{
            response.sendRedirect(UserService.getTemplatePage(user));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("visit", VisitService.getById(id));
        request.setAttribute("partialPage", "/Views/editVisitForm.jsp");
        User user = (User) request.getSession().getAttribute("currentUser");
        request.getRequestDispatcher(UserService.getTemplatePage(user)).forward(request, response);

    }
}
