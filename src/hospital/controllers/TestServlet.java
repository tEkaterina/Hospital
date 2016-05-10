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

        Patient p = patientRepository.getByField("name", "Иван");
        Patient p1 = new Patient();
        p1.setName("Петька");
        p1.setSurname("Валерьев");
        patientRepository.add(p1);

        List<Patient> patients = patientRepository.getAll();
        request.setAttribute("patients", patients);
        request.setAttribute("p", p);

        patientRepository.close();

        request.getRequestDispatcher("/Views/patients.jsp").forward(request, response);
    }
}
