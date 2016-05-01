package hospital.controllers.Doctor;

import hospital.models.DiseaseType;
import hospital.models.Doctor;
import hospital.models.InitialInspection;
import hospital.repositories.concrete.Repository;

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

        Repository<InitialInspection> repository = new Repository<InitialInspection>(InitialInspection.class);
        InitialInspection insp = new InitialInspection();
        repository.add(insp);

        Repository<Doctor> doctorsRepository = new Repository<Doctor>(Doctor.class);
        List<Doctor> doctors = doctorsRepository.getAll();
        request.setAttribute("doctors", doctors);
        request.getRequestDispatcher("/Views/doctorsView.jsp").forward(request, response);
    }
}
