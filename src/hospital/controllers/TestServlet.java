package hospital.controllers;

import hospital.models.*;
import hospital.repositories.concrete.Repository;

import java.io.IOException;
import java.util.*;

import javax.servlet.annotation.WebServlet;

@WebServlet("/patients")
public class TestServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Repository<Patient> patientRepository = new Repository<Patient>(Patient.class);

        Patient patient1 = new Patient();
        patient1.setName("Петр");
        patient1.setSurname("Петров");

        Patient patient2 = new Patient();
        patient2.setName("Иван");
        patient2.setSurname("Иванов");

        patientRepository.add(patient1);
        patientRepository.add(patient2);

        List<Patient> patients = patientRepository.getAll();
        request.setAttribute("patients", patients);

        request.getRequestDispatcher("/Views/patients.jsp").forward(request, response);
    }
}
