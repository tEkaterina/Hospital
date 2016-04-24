package hospital.controllers;

import hospital.models.Patient;
import hospital.repositories.concrete.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/patientsView")
public class UpdatePatients extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Repository<Patient> patientRepository = new Repository<Patient>(Patient.class);

        List<Patient> patients = patientRepository.getAll();
        request.setAttribute("patients", patients);
        request.getRequestDispatcher("/Views/patientsView.jsp").forward(request, response);
    }
}
