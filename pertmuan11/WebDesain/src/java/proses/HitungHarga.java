package proses;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HitungHarga", urlPatterns = {"/HitungHarga"})
public class HitungHarga extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Membaca parameter dari form
        String namaBarang = request.getParameter("namaBarang");
        String hargaSatuan = request.getParameter("hargaSatuan");
        String jumlah = request.getParameter("jumlah");

        int harga = 0, jumlahBarang = 0, diskon = 0, total;
        
        // Konversi input ke angka
        try {
            if (hargaSatuan != null) harga = Integer.parseInt(hargaSatuan);
            if (jumlah != null) jumlahBarang = Integer.parseInt(jumlah);
        } catch (NumberFormatException ex) {
            // Jika input bukan angka, biarkan 0
        }

        // Menghitung total harga sebelum diskon
        total = harga * jumlahBarang;

        // Logika diskon: 5% jika jumlah >= 100 dan total >= 1.000.000
        if ((jumlahBarang >= 100) && (total >= 1000000)) {
            diskon = (int) (total * 0.05);
            total -= diskon;
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Menghitung Harga (Servlet)</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Hasil Penghitungan Harga</h2>");
            out.println("<form action='index.jsp' method='post'>");
            out.println("<table border='0'>");
            out.println("<tr><td>Nama Barang</td><td>:</td><td>" + (namaBarang != null ? namaBarang : "-") + "</td></tr>");
            out.println("<tr><td>Harga Satuan</td><td>:</td><td>" + harga + "</td></tr>");
            out.println("<tr><td>Jumlah</td><td>:</td><td>" + jumlahBarang + "</td></tr>");
            out.println("<tr><td>Diskon</td><td>:</td><td>" + diskon + "</td></tr>");
            out.println("<tr><td>Total</td><td>:</td><td>" + total + "</td></tr>");
            out.println("<tr><td colspan='3'><br><input type='submit' value='Kembali'></td></tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}