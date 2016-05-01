package hospital.controllers;

import hospital.models.Address;
import hospital.models.Patient;
import hospital.repositories.concrete.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/editPatient")
public class EditPatient extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Repository<Patient> patientRepository = new Repository<Patient>(Patient.class);
        Repository<Address> addressRepository = new Repository<Address>(Address.class);

        int id = Integer.parseInt(request.getParameter("id"));
        Patient editedPatient = patientRepository.getById(id);

        editedPatient.setName(request.getParameter("name"));
        editedPatient.setSurname(request.getParameter("surname"));
        editedPatient.setClinicNumber(request.getParameter("clinic"));

        Address editedAddress = editedPatient.getAddress();
        editedAddress.setStreet(request.getParameter("street"));
        editedAddress.setHouse(request.getParameter("house"));
        editedAddress.setHousing(request.getParameter("housing"));
        editedAddress.setApartment(request.getParameter("apartment"));

        editedPatient.setAddress(editedAddress);
        addressRepository.update(editedAddress);
        patientRepository.update(editedPatient);

        response.sendRedirect("/patientsView");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Repository<Patient> patientRepository = new Repository<Patient>(Patient.class);
        Patient editedPatient = patientRepository.getById(id);
        request.setAttribute("patient",editedPatient);
        request.getRequestDispatcher("/Views/editPatientForm.jsp").forward(request, response);

    }
}
