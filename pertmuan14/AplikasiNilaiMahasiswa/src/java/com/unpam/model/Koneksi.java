package com.unpam.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {

    public Connection getConnection() {
        Connection koneksi = null;

        try {
         Class.forName("com.mysql.jdbc.Driver");

            koneksi = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dbaplikasipenilaianmahasiswa",
                "root",
                ""
            );

            System.out.println("Koneksi Berhasil");

        } catch (Exception e) {
            System.out.println("Koneksi Gagal");
            System.out.println(e);
        }

        return koneksi;
    }
}