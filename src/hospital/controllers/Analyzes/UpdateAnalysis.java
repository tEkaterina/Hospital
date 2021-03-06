package hospital.controllers.Analyzes;

import hospital.models.Analysis;
import hospital.models.User;
import hospital.services.AnalyzService;
import hospital.services.TempAttributesToObj;
import hospital.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateAnalyz")
public class UpdateAnalysis extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("windows-1251");
        Analysis analysis = TempAttributesToObj.getAnalysis(request); //TODO replace with JS get object from Form
        AnalyzService.update(analysis);
        response.sendRedirect("/analyzes?id="+analysis.getVisit().getId());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("analyz", AnalyzService.getById(id));
        request.setAttribute("visitId", Integer.parseInt(request.getParameter("visitId")));
        request.setAttribute("partialPage", "/Views/editAnalyzForm.jsp");
        User user = (User) request.getSession().getAttribute("currentUser");
        request.getRequestDispatcher(UserService.getTemplatePage(user)).forward(request, response);
    }
}
