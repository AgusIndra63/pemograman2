package com.unpam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MataKuliahController")
public class MataKuliahController extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Mata Kuliah</title>");
            out.println("</head>");

            out.println("<body>");

            out.println("<h1>FORM MATA KULIAH</h1>");

            out.println("<form>");

            out.println("Kode MK : <br>");
            out.println("<input type='text'><br><br>");

            out.println("Nama MK : <br>");
            out.println("<input type='text'><br><br>");

            out.println("<input type='submit' value='Simpan'>");

            out.println("</form>");

            out.println("<br><a href='MainForm'>Kembali</a>");

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
}