package apkenterprise;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {
public static Connection getConnection() {
try {
String url = "jdbc:mysql://localhost:3306/penjualan";
String user = "root";
String pass = "";
return DriverManager.getConnection(url, user, pass);
} catch (Exception e) {
System.out.println("Koneksi gagal: " + e.getMessage());
return null;
}
}
}
