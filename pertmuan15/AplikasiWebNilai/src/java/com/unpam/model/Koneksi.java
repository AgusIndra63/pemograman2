package com.unpam.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {

    Connection koneksi;

    public Connection getConnection() {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            koneksi = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbnilaiweb",
                    "root",
                    "");

            System.out.println("Koneksi Berhasil");

        } catch (Exception e) {

            System.out.println("Koneksi Gagal");
            System.out.println(e);

        }

        return koneksi;
    }
}