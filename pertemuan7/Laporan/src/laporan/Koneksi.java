package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {

    public static Connection getConnection() {
        Connection conn = null;

        try {
            // WAJIB BANGET
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/db_mahasiswa";
            String user = "root";
            String pass = "";

            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi MySQL berhasil");

        } catch (Exception e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }

        return conn;
    }
}