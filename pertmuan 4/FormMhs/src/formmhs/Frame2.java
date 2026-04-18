package formmhs;

import javax.swing.*;

public class Frame2 extends JFrame {

    public Frame2() {
        setTitle("Frame Kedua");
        setSize(400, 250);
        setLayout(null);

        JLabel judul = new JLabel("FRAME YANG DIPANGGIL");
        judul.setBounds(100, 20, 200, 25);
        add(judul);

        JLabel lblNim = new JLabel("NIM");
        lblNim.setBounds(50, 70, 100, 25);
        add(lblNim);

        JTextField txtNim = new JTextField();
        txtNim.setBounds(180, 70, 150, 25);
        add(txtNim);

        JLabel lblNama = new JLabel("Nama Mahasiswa");
        lblNama.setBounds(50, 110, 120, 25);
        add(lblNama);

        JTextField txtNama = new JTextField();
        txtNama.setBounds(180, 110, 150, 25);
        add(txtNama);
    }
}