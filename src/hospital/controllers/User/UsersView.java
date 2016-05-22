package hospital.controllers.User;

import hospital.models.Doctor;
import hospital.models.User;
import hospital.repositories.concrete.Repository;
import hospital.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/usersView")
public class UsersView extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Repository<User> userRepository = new Repository<User>(User.class);
        List<User> users = userRepository.getAll();
        userRepository.close();
        request.setAttribute("users", users);
        request.setAttribute("partialPage", "/Views/usersView.jsp");
        request.setAttribute("activeNavPill", "user");
        User user = (User) request.getSession().getAttribute("currentPage");
        request.getRequestDispatcher(UserService.getTemplatePage(user)).forward(request, response);
    }
}
