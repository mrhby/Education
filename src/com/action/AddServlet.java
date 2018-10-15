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
import java.io.PrintWriter;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        int couid =  Integer.parseInt(request.getParameter("couid"));
        HttpSession session = request.getSession();
        int stuid = (int)session.getAttribute("stuid");
        UserDao userDao = new UserDaoImpl();
        int i = userDao.findCourseById(stuid,couid);
        if(i == 1){
            out.print("<script language='javascript'>alert('改课程已经选择，请重新选课');window.location.href='jsp/course_information.jsp';</script>");
        }
        else{
            userDao.addCourse(stuid,couid);
            out.print("<script language='javascript'>alert('选择课程成功');window.location.href='jsp/delete_course.jsp';</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
