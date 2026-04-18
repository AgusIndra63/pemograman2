package formmhs;

import javax.swing.*;
import java.awt.event.*;

public class FormMhs extends JFrame {

    JButton btnPanggil;

    public FormMhs() {
        setTitle("Frame Utama");
        setSize(400, 200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lbl = new JLabel("MEMANGGIL - MENAMPILKAN FRAME LAIN");
        lbl.setBounds(50, 30, 300, 25);
        add(lbl);

        btnPanggil = new JButton("PANGGIL FRAME");
        btnPanggil.setBounds(100, 80, 180, 30);
        add(btnPanggil);

        btnPanggil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Frame2().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new FormMhs().setVisible(true);
    }
}