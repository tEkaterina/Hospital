package hospital.services;


import hospital.models.Address;
import hospital.models.Patient;


import javax.servlet.http.HttpServletRequest;

public class TempAttributesToObj {

    public static Patient getPatient(HttpServletRequest request) {

        Patient patient = new Patient();
        Address address = new Address();
        String id = request.getParameter("id");
        if (id!=null) {
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
}
