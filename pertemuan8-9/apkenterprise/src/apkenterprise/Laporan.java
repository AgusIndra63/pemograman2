package apkenterprise;

import javax.swing.*;
import java.sql.*;

public class Laporan extends JFrame {


JTextArea area;

public Laporan() {
    setTitle("Laporan Barang");
    setSize(400,300);

    area = new JTextArea();
    add(new JScrollPane(area));

    tampilLaporan();

    setVisible(true);
}

void tampilLaporan() {
    try {
        Connection conn = Koneksi.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM barang");

        while(rs.next()) {
            area.append(
                rs.getString("kode_barang") + " | " +
                rs.getString("nama_barang") + " | " +
                rs.getInt("stok") + "\n"
            );
        }

    } catch(Exception e) {
        area.setText(e.getMessage());
    }
}


}
