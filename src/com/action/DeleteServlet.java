package com.action;

import com.dao.Impl.UserDaoImpl;
import com.dao.UserDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int couid = Integer.parseInt(request.getParameter("couid"));
        HttpSession session = request.getSession();
        int stuid = (int)session.getAttribute("stuid");
        UserDao userDao = new UserDaoImpl();
        userDao.deleteCourse(stuid,couid);
        response.sendRedirect("jsp/delete_course.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
