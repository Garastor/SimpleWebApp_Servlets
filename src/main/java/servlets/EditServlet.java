package servlets;

import database.SqlOperation;
import models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditServlet", urlPatterns = "/edit")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String fName = request.getParameter("fName");
            String lName = request.getParameter("lName");
            String course = request.getParameter("course");
            int id = Integer.parseInt(request.getParameter("id"));
            Student student = new Student(fName, lName, course);
            SqlOperation.editStudent(student, id);
            response.sendRedirect("hello");
        } catch (Exception e){
            getServletContext().getRequestDispatcher("/change.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/change.jsp").forward(request, response);
    }
}
