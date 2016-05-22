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

@WebServlet ("/addNewAdmin")
public class addNewAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("windows-1251");
        User admin = TempAttributesToObj.getUser(request);
        if (UserService.isValidAdmin(request)){
            UserService.addAdmin(admin);
            response.sendRedirect("/success");
        }
        else{
            response.sendRedirect("/failed");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("partialPage", "/Views/addNewAdmin.jsp");
        request.setAttribute("activeNavPill", "addNewAdmin");
        User user = (User)request.getSession().getAttribute("currentUser");
        request.getRequestDispatcher(UserService.getTemplatePage(user)).forward(request, response);
    }
}
