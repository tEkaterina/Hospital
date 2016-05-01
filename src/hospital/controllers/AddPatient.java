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


@WebServlet("/addPatient")
public class AddPatient extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Repository<Patient> patientRepository = new Repository<Patient>(Patient.class);
        Patient addedPatient = new Patient();
        addedPatient.setName(request.getParameter("name"));
        addedPatient.setSurname(request.getParameter("surname"));
        addedPatient.setClinicNumber(request.getParameter("clinic"));

        Repository<Address> addressRepository = new Repository<Address>(Address.class);
        Address addedAddress = new Address();
        addedAddress.setStreet(request.getParameter("street"));
        addedAddress.setHouse(request.getParameter("house"));
        addedAddress.setHousing(request.getParameter("housing"));
        addedAddress.setApartment(request.getParameter("apartment"));

        addedPatient.setAddress(addedAddress);
        addressRepository.add(addedAddress);
        patientRepository.add(addedPatient);

        response.sendRedirect("/patientsView");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
