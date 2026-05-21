package crud;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class CRUD extends JFrame {

    JTextField txtNim, txtNama, txtSemester, txtKelas;
    JButton btnSimpan, btnHapus, btnUpdate, btnBersih;
    JTable table;
    DefaultTableModel model;

    public CRUD() {
        setTitle("Data Mahasiswa");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // LABEL
        add(new JLabel("NIM")).setBounds(20, 20, 100, 25);
        add(new JLabel("Nama")).setBounds(20, 50, 100, 25);
        add(new JLabel("Semester")).setBounds(20, 80, 100, 25);
        add(new JLabel("Kelas")).setBounds(20, 110, 100, 25);

        // TEXTFIELD
        txtNim = new JTextField(); txtNim.setBounds(120, 20, 150, 25); add(txtNim);
        txtNama = new JTextField(); txtNama.setBounds(120, 50, 150, 25); add(txtNama);
        txtSemester = new JTextField(); txtSemester.setBounds(120, 80, 150, 25); add(txtSemester);
        txtKelas = new JTextField(); txtKelas.setBounds(120, 110, 150, 25); add(txtKelas);

        // BUTTON
        btnSimpan = new JButton("Simpan"); btnSimpan.setBounds(300, 20, 100, 25); add(btnSimpan);
        btnHapus = new JButton("Hapus"); btnHapus.setBounds(410, 20, 100, 25); add(btnHapus);
        btnUpdate = new JButton("Update"); btnUpdate.setBounds(300, 60, 100, 25); add(btnUpdate);
        btnBersih = new JButton("Bersih"); btnBersih.setBounds(410, 60, 100, 25); add(btnBersih);

        // TABLE
        model = new DefaultTableModel();
        model.addColumn("NIM");
        model.addColumn("Nama");
        model.addColumn("Semester");
        model.addColumn("Kelas");

        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 160, 540, 180);
        add(sp);

        // SIMPAN
        btnSimpan.addActionListener(e -> {
            model.addRow(new Object[]{
                txtNim.getText(),
                txtNama.getText(),
                txtSemester.getText(),
                txtKelas.getText()
            });
            bersih();
        });

        // HAPUS
        btnHapus.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                model.removeRow(row);
                bersih();
            } else {
                JOptionPane.showMessageDialog(null, "Pilih data dulu!");
            }
        });

        // UPDATE
        btnUpdate.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                model.setValueAt(txtNim.getText(), row, 0);
                model.setValueAt(txtNama.getText(), row, 1);
                model.setValueAt(txtSemester.getText(), row, 2);
                model.setValueAt(txtKelas.getText(), row, 3);
                bersih();
            } else {
                JOptionPane.showMessageDialog(null, "Pilih data dulu!");
            }
        });

        // KLIK TABEL
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                txtNim.setText(model.getValueAt(row, 0).toString());
                txtNama.setText(model.getValueAt(row, 1).toString());
                txtSemester.setText(model.getValueAt(row, 2).toString());
                txtKelas.setText(model.getValueAt(row, 3).toString());
            }
        });

        // BERSIH
        btnBersih.addActionListener(e -> bersih());
    }

    void bersih() {
        txtNim.setText("");
        txtNama.setText("");
        txtSemester.setText("");
        txtKelas.setText("");
    }

    public static void main(String[] args) {
        new CRUD().setVisible(true);
    }
}