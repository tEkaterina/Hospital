package hospital.controllers.User;

import hospital.models.User;
import hospital.repositories.concrete.Repository;
import hospital.services.TempAttributesToObj;
import hospital.services.TempUserService;
import hospital.services.UserService;

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
        User admin = TempAttributesToObj.getAdmin(request);
        UserService.addAdmin(admin);
        response.sendRedirect("/success");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/addNewAdmin.jsp").forward(request, response);
    }
}
