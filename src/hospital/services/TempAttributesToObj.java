package hospital.services;


import hospital.models.Address;
import hospital.models.Doctor;
import hospital.models.Patient;
import hospital.models.Speciality;


import javax.servlet.http.HttpServletRequest;

public class TempAttributesToObj {

    public static Patient getPatient(HttpServletRequest request) {

        Patient patient = new Patient();
        Address address = new Address();
        String id = request.getParameter("id");
        if (id!="") {
            patient.setId(Integer.parseInt(request.getParameter("id")));
            address.setId(Integer.parseInt(request.getParameter("addressId")));
        }
        patient.setName(request.getParameter("name"));
        patient.setSurname(request.getParameter("surname"));
        patient.setClinicNumber(request.getParameter("clinic"));


        address.setStreet(request.getParameter("street"));
        address.setHouse(request.getParameter("house"));
        address.setHousing(request.getParameter("housing"));
        address.setApartment(request.getParameter("apartment"));

        patient.setAddress(address);
        return patient;
    }

    public static Doctor getDoctor(HttpServletRequest request) {
        Doctor doctor = new Doctor();
        doctor.setId(Integer.parseInt(request.getParameter("id")));
        doctor.setName(request.getParameter("name"));
        doctor.setSurname(request.getParameter("surname"));
        doctor.setTelephone(request.getParameter("phone"));
        doctor.setCategory(Doctor.Category.valueOf(request.getParameter("category")));

        String specialityName = request.getParameter("specialities");
        Speciality speciality = SpecialityService.getByName(specialityName);
        doctor.setSpeciality(speciality);

        return doctor;
    }
}
