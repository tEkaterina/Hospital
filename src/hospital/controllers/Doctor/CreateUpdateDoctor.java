package hospital.controllers.Doctor;

import hospital.models.Doctor;
import hospital.models.Speciality;
import hospital.repositories.concrete.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/updateDoctor")
public class CreateUpdateDoctor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("windows-1251");
        Repository<Doctor> doctorRepository = new Repository<Doctor>(Doctor.class);
        Repository<Speciality> specialityRepository = new Repository<Speciality>(Speciality.class);

        Doctor doctor;
        String operation = request.getParameter("operation");
        if (operation.equals("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            doctor = doctorRepository.getById(id);
        } else {
            doctor = new Doctor();
        }
        doctor.setName(request.getParameter("name"));
        doctor.setSurname(request.getParameter("surname"));
        doctor.setTelephone(request.getParameter("phone"));
        doctor.setCategory(Doctor.Category.valueOf(request.getParameter("category")));

        int speciality_id =175;
        String specialityName = request.getParameter("specialities");
        Speciality speciality = specialityRepository.getById(speciality_id); //TODO replace call method GetSpecialityByName
        doctor.setSpeciality(speciality);

        if (operation.equals("edit")) {
            doctorRepository.update(doctor);
        } else {
            doctorRepository.add(doctor);
        }
        response.sendRedirect("/doctorsView");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Repository<Speciality> specialityRepository = new Repository<Speciality>(Speciality.class);
        List<Speciality> specialities = specialityRepository.getAll();
        request.setAttribute("specialities", specialities);

        if (id!=0) {
            Repository<Doctor> doctorRepository = new Repository<Doctor>(Doctor.class);
            Doctor editedDoctor = doctorRepository.getById(id);
            request.setAttribute("doctor", editedDoctor);
            request.setAttribute("operation", "edit");
        }
        request.getRequestDispatcher("/Views/editDoctorForm.jsp").forward(request, response);
    }
}
