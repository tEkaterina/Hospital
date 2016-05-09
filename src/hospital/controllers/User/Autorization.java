package hospital.controllers.User;

import hospital.models.User;
import hospital.services.TempUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logIn")
public class Autorization extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User currentUser = TempUserService.getUser(); //TODO replace with autorization logic
        request.getSession(true).setAttribute("user", currentUser);
        response.sendRedirect("/patientsView");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/autorizationForm.jsp").forward(request, response);
    }
}
