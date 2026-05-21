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

@WebServlet("/NilaiController")
public class NilaiController extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String nim = request.getParameter("nim");
        String kode = request.getParameter("kode");
        String nilai = request.getParameter("nilai");

        try (PrintWriter out = response.getWriter()) {

            Koneksi k = new Koneksi();
            Connection con = k.getConnection();

            if (nim != null && kode != null && nilai != null
                    && !nim.equals("")
                    && !kode.equals("")
                    && !nilai.equals("")) {

                try {

                    String sql = "INSERT INTO tbnilai(nim,kode,nilai) VALUES(?,?,?)";

                    PreparedStatement pst = con.prepareStatement(sql);

                    pst.setString(1, nim);
                    pst.setString(2, kode);
                    pst.setInt(3, Integer.parseInt(nilai));

                    pst.executeUpdate();

                    out.println("<h3>DATA NILAI BERHASIL DISIMPAN</h3>");

                } catch (Exception e) {

                    out.println(e);

                }
            }

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Nilai Mahasiswa</title>");
            out.println("</head>");

            out.println("<body>");

            out.println("<center>");

            out.println("<h1>FORM NILAI MAHASISWA</h1>");

            out.println("<form method='post'>");

            out.println("NIM : <br>");
            out.println("<input type='text' name='nim'><br><br>");

            out.println("Kode Mata Kuliah : <br>");
            out.println("<input type='text' name='kode'><br><br>");

            out.println("Nilai : <br>");
            out.println("<input type='text' name='nilai'><br><br>");

            out.println("<input type='submit' value='Simpan'>");

            out.println("</form>");

            out.println("<br><br>");

            out.println("<a href='ViewNilaiController'>View Data Nilai</a>");

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