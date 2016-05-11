package hospital.controllers.User;

import hospital.models.User;
import hospital.repositories.concrete.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Balashechka on 10.05.2016.
 */
@WebServlet ("/addNewAdmin")
public class addNewAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("windows-1251");
        Repository<User> userRepository = new Repository<User>(User.class);

        User user = new User();
        String pass = request.getParameter("password");
        String email = request.getParameter("email");
        String salt = HashCode.saltGeneration().toString();
        user.setSalt(salt);
        pass = pass + salt;
        pass = HashCode.MD5(pass);
        user.setPassword(pass);
        user.setEmail(email);
        user.setRoleName(User.RoleName.Admin);
        userRepository.add(user);
        //request.getSession(true).setAttribute(User.RoleName.Admin, user);

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

        response.sendRedirect("/failed");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/addNewAdmin.jsp").forward(request, response);
    }
}
