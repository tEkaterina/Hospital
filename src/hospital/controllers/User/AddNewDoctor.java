package hospital.controllers.User;

import hospital.models.Doctor;
import hospital.models.Speciality;
import hospital.models.User;
import hospital.repositories.concrete.Repository;

import javax.print.Doc;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Balashechka on 09.05.2016.
 */
@WebServlet("/addNewDoctor")
public class AddNewDoctor extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("windows-1251");
        Repository<Doctor> doctorRepository = new Repository<Doctor>(Doctor.class);
        Repository<User> userRepository = new Repository<User>(User.class);
        Repository<Speciality> specialityRepository = new Repository<Speciality>(Speciality.class);

        User user = new User();
        Doctor doctor = new Doctor();
        doctor.setName(request.getParameter("name"));
        doctor.setSurname(request.getParameter("surname"));
        doctor.setCategory(Doctor.Category.valueOf(request.getParameter("category")));
        doctor.setTelephone(request.getParameter("phone"));
        doctorRepository.add(doctor);

        String pass = request.getParameter("password");
        String email = request.getParameter("email");
        String salt = HashCode.saltGeneration().toString();
        user.setSalt(salt);
        pass = pass + salt;
        pass = HashCode.MD5(pass);
        user.setPassword(pass);
        user.setEmail(email);
        user.setRoleName(User.RoleName.Admin);
        user.setDoctor(doctor);
        userRepository.add(user);

        /*User currentUser = userRepository.getByField("email", email);
        User currentUser1 = userRepository.getByField("email", email);
        if (currentUser.equals(currentUser1)){
           response.sendRedirect("/failed");
        }
        else
        {
            user.setPassword(pass);
            user.setEmail(email);
            userRepository.add(user);
        }*/
        response.sendRedirect("/userIsAdd");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      request.getRequestDispatcher("/Views/addNewDoctor.jsp").forward(request, response);
    }
}
