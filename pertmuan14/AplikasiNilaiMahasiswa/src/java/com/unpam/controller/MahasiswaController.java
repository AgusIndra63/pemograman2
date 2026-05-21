package com.unpam.controller;

import com.unpam.model.Koneksi;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MahasiswaController")
public class MahasiswaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String nim = request.getParameter("nim");
        String nama = request.getParameter("nama");

        try (PrintWriter out = response.getWriter()) {

            // SIMPAN DATA
            if (nim != null && nama != null
                    && !nim.equals("")
                    && !nama.equals("")) {

                try {

                    Koneksi k = new Koneksi();
                    Connection con = k.getConnection();

                    String sql = "INSERT INTO tbmahasiswa(nim,nama) VALUES(?,?)";

                    PreparedStatement pst = con.prepareStatement(sql);

                    pst.setString(1, nim);
                    pst.setString(2, nama);

                    pst.executeUpdate();

                    out.println("<h3>DATA BERHASIL DISIMPAN</h3>");

                } catch (Exception e) {

                    out.println(e);

                }
            }

            // FORM
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Data Mahasiswa</title>");
            out.println("</head>");

            out.println("<body>");

            out.println("<h1>FORM MAHASISWA</h1>");

            out.println("<form method='post'>");

            out.println("NIM : <br>");
            out.println("<input type='text' name='nim'><br><br>");

            out.println("Nama : <br>");
            out.println("<input type='text' name='nama'><br><br>");

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