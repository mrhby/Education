package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import com.entity.Student;
import com.exception.SeException;
import com.service.Impl.UserServiceImpl;
import com.service.UserService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String stunam = request.getParameter("stunam");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        String sessionCode = request.getSession().getAttribute("code").toString();
        UserService userService = new UserServiceImpl();
        Student student = new Student();
        student.setStunam(stunam);
        student.setPassword(password);
        try{
            Student student1 = userService.login(student);
            if (code != null && !"".equals(code) && sessionCode != null && !"".equals(sessionCode)) {
                if (code.equalsIgnoreCase(sessionCode)) {
                    out.print(true);
                } else {
                    out.print("验证码输入错误");
                }
            } else {
                out.print("验证码为空");
            }
            HttpSession session = request.getSession();
            session.setAttribute("stunam", student1.getStunam());
            session.setAttribute("password",student1.getPassword());
            session.setAttribute("stuid", student1.getStuid());
            session.setAttribute("stusex",student1.getStusex());
            session.setAttribute("stubir",student1.getStubir());
            session.setAttribute("stugra",student1.getStugra());
        }catch (SeException e){
            String msg = e.getMessage();
            request.setAttribute("msg", msg);
            out.print("用户名或密码输入错误");
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
