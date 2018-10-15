package com.action;

import com.entity.Student;
import com.exception.SeException;
import com.service.Impl.UserServiceImpl;
import com.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String stunam = request.getParameter("stunam");
        String password = request.getParameter("password");
        Student student = new Student();
        student.setStunam(stunam);
        student.setPassword(password);
        UserService userService = new UserServiceImpl();
        try {
            if (userService.register(student)) {
                out.print(true);
            } else {
                out.print(false);
            }
        }catch (SeException e){
            String msg = e.getMessage();
            request.setAttribute("msg", msg);
            out.print("用户已被注册");
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
