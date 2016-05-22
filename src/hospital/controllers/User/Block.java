package hospital.controllers.User;

import hospital.models.User;
import hospital.repositories.concrete.Repository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/block")
public class Block extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Repository<User> userRepository = new Repository< User>(User.class);
        User user = userRepository.getById(id);
        user.setActivity(!user.getActivity());
        userRepository.update(user);
        userRepository.close();

        response.sendRedirect("/usersView");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
