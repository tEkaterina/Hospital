package hospital.controllers.User;

import hospital.models.User;
import hospital.repositories.concrete.Repository;
import hospital.services.TempUserService;
import hospital.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logIn")
public class Autorization extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String strLog = request.getParameter("login");
        String strPas = request.getParameter("password");

        User currentUser = UserService.getCurrentUser(strLog);

        if (UserService.IsAuthorized(strLog, strPas)){
            request.getSession(true).setAttribute("currentUser", currentUser);
            if (currentUser.isDoctor()) {
                request.getRequestDispatcher("/Views/doctorProfile.jsp").forward(request, response);
            }
            if (currentUser.isAdmin()) {
                request.getRequestDispatcher("/Views/adminProfile.jsp").forward(request, response);
            }
        }
        else{
            response.sendRedirect("/logIn");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Repository<User> userRepository = new Repository<User>(User.class);
        if (userRepository.getAll().isEmpty()){
            UserService.IsFirstAdmin();
        }

        request.getRequestDispatcher("/Views/autorizationForm.jsp").forward(request, response);
    }
}
