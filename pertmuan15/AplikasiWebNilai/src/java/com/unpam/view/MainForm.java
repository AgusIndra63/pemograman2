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

            out.println("<html>");

            out.println("<head>");
            out.println("<title>Aplikasi Nilai Mahasiswa</title>");

            out.println("<style>");

            out.println("body{");
            out.println("font-family: Arial;");
            out.println("background:#f2f2f2;");
            out.println("}");

            out.println(".container{");
            out.println("width:800px;");
            out.println("margin:auto;");
            out.println("background:white;");
            out.println("padding:20px;");
            out.println("border-radius:10px;");
            out.println("box-shadow:0px 0px 10px gray;");
            out.println("margin-top:40px;");
            out.println("}");

            out.println("h1{color:darkblue;}");

            out.println(".menu a{");
            out.println("display:inline-block;");
            out.println("padding:10px 20px;");
            out.println("margin:10px;");
            out.println("background:darkblue;");
            out.println("color:white;");
            out.println("text-decoration:none;");
            out.println("border-radius:5px;");
            out.println("}");

            out.println(".menu a:hover{");
            out.println("background:blue;");
            out.println("}");

            out.println("</style>");

            out.println("</head>");

            out.println("<body>");

            out.println("<div class='container'>");

            out.println("<center>");

            out.println("<h1>INFORMASI NILAI MAHASISWA</h1>");
            out.println("<h2>UNIVERSITAS PAMULANG</h2>");

            out.println("<hr>");

            out.println("<div class='menu'>");

            out.println("<a href='MahasiswaController'>Mahasiswa</a>");
            out.println("<a href='MataKuliahController'>Mata Kuliah</a>");
            out.println("<a href='NilaiController'>Nilai</a>");

            out.println("</div>");

            out.println("</center>");

            out.println("</div>");

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