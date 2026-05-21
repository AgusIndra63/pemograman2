package apkenterprise;

import javax.swing.*;
import java.sql.*;

public class FrmCustomer extends JFrame {
JTextField txtId, txtNama;


public FrmCustomer() {
    setTitle("Customer");
    setSize(300,200);
    setLayout(null);

    txtId = new JTextField();
    txtId.setBounds(20,20,200,25);

    txtNama = new JTextField();
    txtNama.setBounds(20,60,200,25);

    JButton btnSimpan = new JButton("Simpan");
    btnSimpan.setBounds(20,100,100,25);

    add(txtId);
    add(txtNama);
    add(btnSimpan);

    btnSimpan.addActionListener(e -> simpan());

    setVisible(true);
}

void simpan() {
    try {
        Connection conn = Koneksi.getConnection();
        String sql = "INSERT INTO customer VALUES (?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, txtId.getText());
        pst.setString(2, txtNama.getText());
        pst.executeUpdate();

        JOptionPane.showMessageDialog(null, "Customer disimpan");
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}

}
