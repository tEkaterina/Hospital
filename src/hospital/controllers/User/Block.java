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
 * Created by Zenbook on 12.05.2016.
 */
@WebServlet("/block")
public class Block extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Repository<User> userRepository = new Repository< User>(User.class);
        User user = userRepository.getById(id);
        user.setActivity(true);
        userRepository.update(user);
        userRepository.close();
        request.getRequestDispatcher("/Views/adminProfile.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Repository<User> userRepository = new Repository< User>(User.class);
        User user = userRepository.getById(id);
        user.setActivity(false);
        userRepository.update(user);
        userRepository.close();
        request.getRequestDispatcher("/Views/adminProfile.jsp").forward(request, response);

    }
}
