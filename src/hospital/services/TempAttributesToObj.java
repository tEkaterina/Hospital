package hospital.services;


import hospital.models.*;
import hospital.repositories.concrete.Repository;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TempAttributesToObj {

    public static Patient getPatient(HttpServletRequest request) {

        Patient patient = new Patient();
        Address address = new Address();
        String id = request.getParameter("id");
        if (!id.equals("")) {
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

    public static Analysis getAnalysis(HttpServletRequest request) {
        Analysis analysis = new Analysis();
        String id = request.getParameter("id");
        if (id!=null) {
            analysis.setId(Integer.parseInt(id));
        }
        analysis.setDate(new Date());
        analysis.setVisit(VisitService.getById(Integer.parseInt(request.getParameter("visitId"))));
        analysis.setHbA1c(Float.parseFloat(request.getParameter("hbA1c")));
        analysis.setTotalCholesterol(Float.parseFloat(request.getParameter("cholesterol")));
        analysis.setTriglycerides(Float.parseFloat(request.getParameter("triglycerides")));
        return analysis;
    }

    public static Visit getVisit(HttpServletRequest request) {
        Visit visit = new Visit();
        visit.setComment(request.getParameter("comment"));
        visit.setDate(new Date());
        User user = (User)request.getSession().getAttribute("currentUser");
        visit.setDoctor(user.getDoctor());
        visit.setPatient(PatientService.getById(Integer.parseInt(request.getParameter("patientId"))));
        return visit;
    }

    public static User getUser(HttpServletRequest request){
        User user = new User();

        String pass = request.getParameter("password");
        String email = request.getParameter("email");
        String salt = UserService.saltGeneration().toString();

        user.setEmail(email);
        user.setActivity(true);
        user.setSalt(salt);
        if (pass != null && !pass.equals("")) {
            pass = pass + salt;
            pass = UserService.MD5(pass);
            user.setPassword(pass);
        }
        return user;
    }

    public static Doctor getDoctor(HttpServletRequest request) {
        Doctor doctor = new Doctor();
        String id = request.getParameter("id");
        if (id != null) {
            doctor.setId(Integer.parseInt(id));
        }
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
