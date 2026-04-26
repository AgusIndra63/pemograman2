package apkenterprise;

import javax.swing.*;
import java.sql.*;

public class FrmTransaksi extends JFrame {
JTextField txtKodeBarang, txtJumlah;


public FrmTransaksi() {
    setTitle("Transaksi");
    setSize(300,200);
    setLayout(null);

    txtKodeBarang = new JTextField();
    txtKodeBarang.setBounds(20,20,200,25);

    txtJumlah = new JTextField();
    txtJumlah.setBounds(20,60,200,25);

    JButton btnProses = new JButton("Proses");
    btnProses.setBounds(20,100,100,25);

    add(txtKodeBarang);
    add(txtJumlah);
    add(btnProses);

    btnProses.addActionListener(e -> transaksi());

    setVisible(true);
}

void transaksi() {
    try {
        Connection conn = Koneksi.getConnection();

        String sql = "UPDATE barang SET stok = stok - ? WHERE kode_barang=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, Integer.parseInt(txtJumlah.getText()));
        pst.setString(2, txtKodeBarang.getText());
        pst.executeUpdate();

        JOptionPane.showMessageDialog(null, "Transaksi berhasil");
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}


}
