package apkenterprise;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class FrmBarang extends JFrame {
JTextField txtKode, txtNama, txtHarga, txtStok;
JTable table;
DefaultTableModel model;


public FrmBarang() {
    setTitle("Data Barang");
    setSize(500,400);
    setLayout(null);

    txtKode = new JTextField(); txtKode.setBounds(20,20,100,25);
    txtNama = new JTextField(); txtNama.setBounds(140,20,100,25);
    txtHarga = new JTextField(); txtHarga.setBounds(260,20,100,25);
    txtStok = new JTextField(); txtStok.setBounds(380,20,80,25);

    JButton btnSimpan = new JButton("Simpan");
    btnSimpan.setBounds(20,60,100,25);

    add(txtKode); add(txtNama); add(txtHarga); add(txtStok);
    add(btnSimpan);

    model = new DefaultTableModel();
    model.addColumn("Kode");
    model.addColumn("Nama");
    model.addColumn("Harga");
    model.addColumn("Stok");

    table = new JTable(model);
    JScrollPane sp = new JScrollPane(table);
    sp.setBounds(20,100,440,200);
    add(sp);

    tampilData();

    btnSimpan.addActionListener(e -> simpan());

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
}

void tampilData() {
    model.setRowCount(0);
    try {
        Connection conn = Koneksi.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM barang");
        while(rs.next()) {
            model.addRow(new Object[]{
                rs.getString(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(4)
            });
        }
    } catch(Exception e) {
        System.out.println(e);
    }
}

void simpan() {
    try {
        Connection conn = Koneksi.getConnection();
        String sql = "INSERT INTO barang VALUES (?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, txtKode.getText());
        pst.setString(2, txtNama.getText());
        pst.setInt(3, Integer.parseInt(txtHarga.getText()));
        pst.setInt(4, Integer.parseInt(txtStok.getText()));
        pst.executeUpdate();
        tampilData();
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}

}
