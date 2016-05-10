package hospital.controllers.Visits;

//import hospital.services.VisitService;

import hospital.services.VisitService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/updateVisit")
public class UpdateVisit extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("windows-1251");
        int id = Integer.parseInt(request.getParameter("id"));
        String comment = request.getParameter("comment");
        VisitService.update(id, comment);
        response.sendRedirect("/patientsView");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("visit", VisitService.getById(id));
        request.getRequestDispatcher("/Views/editVisitForm.jsp").forward(request, response);

    }
}
