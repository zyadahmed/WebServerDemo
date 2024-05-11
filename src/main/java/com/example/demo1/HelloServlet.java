package com.example.demo1;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Enter here");
        PrintWriter out = response.getWriter();
        out.println("\n");
        out.println("\n");

        out.println("<!DOCTYPE html>");
        out.println("<html><body>");
        out.println("<h1>" + "Hello World" + "</h1>");
        out.println("</body></html>");
        System.out.println("finish doGet");
        System.out.println(response.getContentType());


    }

    public void destroy() {
    }
}