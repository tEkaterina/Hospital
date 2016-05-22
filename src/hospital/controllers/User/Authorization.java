package hospital.controllers.User;

import com.sun.deploy.net.HttpRequest;
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

@WebServlet("")
public class Authorization extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Repository<User> usersRepository = new Repository<User>(User.class);
        String strLog = request.getParameter("login");
        String strPas = request.getParameter("password");

        User currentUser = UserService.getCurrentUser(strLog);

        if (UserService.IsAuthorized(strLog, strPas)){
            request.getSession(true).setAttribute("currentUser", currentUser);
            request.getRequestDispatcher(UserService.getTemplatePage(currentUser)).forward(request, response);
        }
        else{
            response.sendRedirect("");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("currentUser") == null) {
            Repository<User> userRepository = new Repository<User>(User.class);
            if (userRepository.getAll().isEmpty()) {
                UserService.IsFirstAdmin();
            }
            request.getRequestDispatcher("/Views/autorizationForm.jsp").forward(request, response);
        }
        else{
            User currentUser = (User)request.getSession().getAttribute("currentUser");
            request.getRequestDispatcher(UserService.getTemplatePage(currentUser)).forward(request, response);
        }
    }
}
