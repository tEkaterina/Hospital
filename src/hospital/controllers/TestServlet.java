package hospital.controllers;

import hospital.models.*;
import hospital.repositories.concrete.Repository;

import java.io.IOException;
import java.util.*;

import javax.print.Doc;
import javax.servlet.annotation.WebServlet;

@WebServlet("/patients")
public class TestServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Repository<Patient> patientRepository = new Repository<Patient>(Patient.class);

        List<Patient> patients = patientRepository.getAll();
        request.setAttribute("patients", patients);
        Patient p = patientRepository.getById(1);
        request.setAttribute("p", p);

        patientRepository.close();

        Repository<User> userRepository = new Repository<User>(User.class);
        User user = userRepository.getById(1);
        Doctor doctor = user.getDoctor();
        String doctorName = doctor.getName();

        request.getRequestDispatcher("/Views/patients.jsp").forward(request, response);

        userRepository.close();
    }
}
