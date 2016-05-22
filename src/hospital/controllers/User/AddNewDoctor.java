package hospital.controllers.User;

import hospital.models.Doctor;
import hospital.models.Speciality;
import hospital.models.User;
import hospital.repositories.concrete.Repository;
import hospital.services.*;

import javax.print.Doc;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addNewDoctor")
public class AddNewDoctor extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("windows-1251");
        if (UserService.isValidDoctor(request)) {
            Doctor doctor = TempAttributesToObj.getDoctors(request);
            User user = TempAttributesToObj.getAdmin(request);
            UserService.addDoctor(user, doctor);
            response.sendRedirect("/success");
        }
        else {
            response.sendRedirect("/failed");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DoctorService.checkSpecialityList();
        request.setAttribute("specialities", SpecialityService.getAll());
        request.setAttribute("partialPage", "/Views/addNewDoctor.jsp");
        request.setAttribute("activeNavPill", "addNewDoctor");
        User user = (User) request.getSession().getAttribute("currentUser");
        request.getRequestDispatcher(UserService.getTemplatePage(user)).forward(request, response);
    }
}
