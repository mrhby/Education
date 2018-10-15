package com.action;

import com.util.CodeUtil;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

@WebServlet("/CodeServlet")

public class CodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> codeMap = CodeUtil.generateCodeAndPic();
        HttpSession session = request.getSession();
        session.setAttribute("code", codeMap.get("code").toString());
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", -1);
        response.setContentType("image/jpg");
        ServletOutputStream servletOutputStream;
        try {
            servletOutputStream = response.getOutputStream();
            ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpg", servletOutputStream);
            servletOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
