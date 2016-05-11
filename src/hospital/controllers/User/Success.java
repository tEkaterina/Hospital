package hospital.controllers.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Balashechka on 09.05.2016.
 */
@WebServlet("/success")
public class Success extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");


        if("doctor".equals(user) ){

            response.sendRedirect("/addNewDoctor");
        }
        else {

            response.sendRedirect("/addNewAdmin");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/success.jsp").forward(request, response);
    }
}
