package com.action;

import com.dao.Impl.UserDaoImpl;
import com.dao.UserDao;
import com.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowStudentServlet")
public class ShowStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int couid = Integer.parseInt(request.getParameter("couid"));
        UserDao userDao = new UserDaoImpl();
        List<Student> studentList = userDao.showStudent(couid);
        request.getSession().setAttribute("studentList",studentList);
        response.sendRedirect("jsp/show_student.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
