package hospital.controllers.User;

import hospital.models.Doctor;
import hospital.models.User;
import hospital.repositories.concrete.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Balashechka on 10.05.2016.
 */
@WebServlet("/userIsAdd")
public class userIsAdd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Repository<User> userRepository = new Repository<User>(User.class);
        List<User> users = userRepository.getAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/Views/UserIsAdd.jsp").forward(request, response);
    }
}
