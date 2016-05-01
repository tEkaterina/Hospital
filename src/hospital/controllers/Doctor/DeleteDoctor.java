package hospital.controllers.Doctor;

import hospital.models.Doctor;
import hospital.repositories.concrete.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteDoctor")
public class DeleteDoctor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Repository<Doctor> doctorRepository = new Repository<Doctor>(Doctor.class);
        int id = Integer.parseInt(request.getParameter("id"));
        Doctor deletedDoctor = doctorRepository.getById(id);
        doctorRepository.delete(deletedDoctor);
        response.sendRedirect("/doctorsView");
    }
}
