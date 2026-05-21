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

@WebServlet("/MataKuliahController")
public class MataKuliahController extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String kode = request.getParameter("kode");
        String nama = request.getParameter("nama");

        try (PrintWriter out = response.getWriter()) {

            Koneksi k = new Koneksi();
            Connection con = k.getConnection();

            if (kode != null && nama != null
                    && !kode.equals("")
                    && !nama.equals("")) {

                try {

                    String sql = "INSERT INTO tbmatakuliah(kode,nama) VALUES(?,?)";

                    PreparedStatement pst = con.prepareStatement(sql);

                    pst.setString(1, kode);
                    pst.setString(2, nama);

                    pst.executeUpdate();

                    out.println("<h3>DATA MATA KULIAH BERHASIL DISIMPAN</h3>");

                } catch (Exception e) {

                    out.println(e);

                }
            }

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Mata Kuliah</title>");
            out.println("</head>");

            out.println("<body>");

            out.println("<center>");

            out.println("<h1>FORM MATA KULIAH</h1>");

            out.println("<form method='post'>");

            out.println("Kode Mata Kuliah : <br>");
            out.println("<input type='text' name='kode'><br><br>");

            out.println("Nama Mata Kuliah : <br>");
            out.println("<input type='text' name='nama'><br><br>");

            out.println("<input type='submit' value='Simpan'>");

            out.println("</form>");

            out.println("<br><br>");

            out.println("<a href='ViewMataKuliahController'>View Data Mata Kuliah</a>");

            out.println("<br><br>");

            out.println("<a href='MainForm'>Kembali</a>");

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
}