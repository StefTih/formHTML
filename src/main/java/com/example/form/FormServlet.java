//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.form;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet({"/formServlet"})
public class FormServlet extends HttpServlet {
    private Enumeration details;
    private List<String> inputValues;
    private Service service = new Service();

    public FormServlet() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        details = request.getParameterNames();
        inputValues = new ArrayList<>();

        while (details.hasMoreElements()){
            Object obj = details.nextElement();
            String parameter = (String) obj;
            String value = request.getParameter(parameter);
            inputValues.add(value);
        }


        service.saveValues(inputValues);

//        HttpSession session = request.getSession();
//        response.sendRedirect("success.html");
        response.sendRedirect("success.jsp");
    }
}
