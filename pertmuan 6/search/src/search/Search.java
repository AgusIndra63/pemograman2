package search;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Search extends JFrame {

    private Connection conn;
    private DefaultTableModel model;

    private JLabel jLabel1, lblHasil;
    private JTextField txtSearch;
    private JButton btnSearch, btnReset;
    private JComboBox<String> cmbKategori;
    private JTable jTable1;

    // ===================== CONSTRUCTOR =====================
    public Search() {
        initComponents();
        koneksi();
        tampilData("");
    }

    // ===================== KONEKSI SQL SERVER =====================
    private void koneksi() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            conn = DriverManager.getConnection(
                "jdbc:sqlserver://localhost:1433;databaseName=pemrograman2;encrypt=false",
                "sa",      // ganti jika beda
                "123"      // ganti password kamu
            );

            System.out.println("Koneksi SQL Server berhasil");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal:\n" + e.getMessage());
        }
    }

    // ===================== TAMPIL DATA =====================
    private void tampilData(String keyword) {
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Koneksi belum berhasil!");
            return;
        }

        try {
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            String sql = "SELECT * FROM datamhs";
            PreparedStatement ps;

            if (keyword.isEmpty()) {
                ps = conn.prepareStatement(sql);
            } else {
                sql += " WHERE nim LIKE ? OR nama LIKE ? OR kelas LIKE ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("nim"),
                    rs.getString("nama"),
                    rs.getInt("semester"),
                    rs.getString("kelas")
                });
            }

            lblHasil.setText("Ditemukan: " + model.getRowCount() + " data");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal tampil:\n" + e.getMessage());
        }
    }

    // ===================== CARI DATA =====================
    private void cariData() {
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Koneksi database gagal!");
            return;
        }

        try {
            String keyword  = txtSearch.getText().trim();
            String kategori = cmbKategori.getSelectedItem().toString();

            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            String sql = "SELECT * FROM datamhs";
            PreparedStatement ps;

            if (keyword.isEmpty()) {
                ps = conn.prepareStatement(sql);

            } else if (kategori.equals("Semua")) {
                sql += " WHERE nim LIKE ? OR nama LIKE ? OR kelas LIKE ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");

            } else {
                String kolom = kategori.toLowerCase();
                sql += " WHERE " + kolom + " LIKE ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("nim"),
                    rs.getString("nama"),
                    rs.getInt("semester"),
                    rs.getString("kelas")
                });
            }

            lblHasil.setText("Ditemukan: " + model.getRowCount() + " data");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal cari:\n" + e.getMessage());
        }
    }

    // ===================== UI =====================
    private void initComponents() {

        jLabel1  = new JLabel("Search:");
        txtSearch = new JTextField();
        btnSearch = new JButton("Cari");
        btnReset  = new JButton("Reset");
        lblHasil  = new JLabel("Ditemukan: 0 data");

        String[] kategori = {"Semua", "NIM", "Nama", "Semester", "Kelas"};
        cmbKategori = new JComboBox<>(kategori);

        jTable1 = new JTable();
        jTable1.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"NIM", "Nama", "Semester", "Kelas"}
        ));

        JScrollPane scrollPane = new JScrollPane(jTable1);

        setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints c = new java.awt.GridBagConstraints();
        c.insets = new java.awt.Insets(5, 5, 5, 5);
        c.fill = java.awt.GridBagConstraints.HORIZONTAL;

        c.gridx = 0; c.gridy = 0; add(jLabel1, c);
        c.gridx = 1; add(cmbKategori, c);
        c.gridx = 2; c.weightx = 1.0; add(txtSearch, c);
        c.weightx = 0;
        c.gridx = 3; add(btnSearch, c);
        c.gridx = 4; add(btnReset, c);

        c.gridx = 0; c.gridy = 1; c.gridwidth = 5;
        add(lblHasil, c);
        c.gridwidth = 1;

        c.gridx = 0; c.gridy = 2; c.gridwidth = 5;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 1.0; c.weighty = 1.0;
        add(scrollPane, c);

        btnSearch.addActionListener(e -> cariData());

        btnReset.addActionListener(e -> {
            txtSearch.setText("");
            cmbKategori.setSelectedIndex(0);
            tampilData("");
        });

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent e) {
                cariData();
            }
        });

        setTitle("Search Data Mahasiswa (SQL Server)");
        setSize(650, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Search().setVisible(true));
    }
}