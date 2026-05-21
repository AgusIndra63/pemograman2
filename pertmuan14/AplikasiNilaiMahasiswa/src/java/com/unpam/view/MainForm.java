package com.unpam.view;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MainForm")
public class MainForm extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");

            out.println("<head>");
            out.println("<title>Aplikasi Nilai Mahasiswa</title>");
            out.println("</head>");

            out.println("<body>");

            out.println("<center>");

            out.println("<h1>INFORMASI NILAI MAHASISWA</h1>");
            out.println("<h2>UNIVERSITAS PAMULANG</h2>");

            out.println("<hr>");

            out.println("<a href='MahasiswaController'>Mahasiswa</a><br><br>");
            out.println("<a href='MataKuliahController'>Mata Kuliah</a><br><br>");

            out.println("</center>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Main Form";
    }
}