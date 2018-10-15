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

@WebServlet("/ChangeServlet")
public class ChangeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action.equals("changePassword")){
            this.changPassword(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void changPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String oldpassword = request.getParameter("oldpassword");
        String newpassword = request.getParameter("newpassword");
        HttpSession session = request.getSession();
        String stunam = (String)session.getAttribute("stunam");
        if(session.getAttribute("password").equals(oldpassword)){
            UserDao userDao = new UserDaoImpl();
            userDao.updateByName(stunam,newpassword);
            session.setAttribute("password",newpassword);
            out.print(true);
        }
        else{
            out.print(false);
        }
        out.flush();
        out.close();
    }
}
