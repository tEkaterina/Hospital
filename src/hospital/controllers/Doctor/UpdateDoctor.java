package hospital.controllers.Doctor;

import hospital.models.Doctor;
import hospital.models.Speciality;
import hospital.repositories.concrete.Repository;
import hospital.services.DoctorService;
import hospital.services.SpecialityService;
import hospital.services.TempAttributesToObj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/updateDoctor")
public class UpdateDoctor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("windows-1251");
        Doctor updatedPatient = TempAttributesToObj.getDoctor(request); //TODO replace with JS get object from Form
        DoctorService.update(updatedPatient);
        response.sendRedirect("/doctorsView");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("doctor", DoctorService.getById(id));
        request.setAttribute("specialities", SpecialityService.getAll());
        request.getRequestDispatcher("/Views/editDoctorForm.jsp").forward(request, response);
    }
}
