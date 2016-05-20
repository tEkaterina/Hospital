package hospital.controllers.User;

import hospital.models.User;
import hospital.repositories.concrete.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class Authorization extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Repository<User> usersRepository = new Repository<User>(User.class);
        String strLog = request.getParameter("login");
        String strPas = request.getParameter("password");

        String user = request.getParameter("user");
        User currentUser = usersRepository.getByField("email", strLog);
        String salt = currentUser.getSalt();
        strPas = strPas + salt;
        if (currentUser.getPassword().equals(HashCode.MD5(strPas)) && currentUser.getActivity()){
            request.getSession(true).setAttribute("currentUser", currentUser);
            if (currentUser.isDoctor()) {
            request.getRequestDispatcher("/Views/doctorProfile.jsp").forward(request, response);
            }
            if (currentUser.isAdmin()) {
                request.getRequestDispatcher("/Views/adminProfile.jsp").forward(request, response);
            }
        }
        else{
            response.sendRedirect("");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Repository<User> userRepository = new Repository<User>(User.class);
        String pass;
        if (userRepository.getAll().isEmpty()){
            User user = new User();
            user.setEmail("admin@gmail.com");
            pass = "admin";
            String salt = HashCode.saltGeneration().toString();
            user.setSalt(salt);
            pass = pass + salt;
            user.setPassword(HashCode.MD5(pass));
            user.setRoleName(User.RoleName.Admin);
            user.setActivity(true);
            userRepository.add(user);
        }
        request.getRequestDispatcher("/Views/autorizationForm.jsp").forward(request, response);
    }
}
