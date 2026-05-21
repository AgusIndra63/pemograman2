package apkenterprise;

import javax.swing.*;

public class MainMenu extends JFrame {


public MainMenu() {
    setTitle("Menu Utama");
    setSize(400,300);
    setLayout(null);

    JButton btnBarang = new JButton("Data Barang");
    btnBarang.setBounds(100,30,200,30);

    JButton btnCustomer = new JButton("Data Customer");
    btnCustomer.setBounds(100,70,200,30);

    JButton btnSupplier = new JButton("Data Supplier");
    btnSupplier.setBounds(100,110,200,30);

    JButton btnTransaksi = new JButton("Transaksi");
    btnTransaksi.setBounds(100,150,200,30);

    JButton btnLaporan = new JButton("Laporan");
    btnLaporan.setBounds(100,190,200,30);

    add(btnBarang);
    add(btnCustomer);
    add(btnSupplier);
    add(btnTransaksi);
    add(btnLaporan);

    btnBarang.addActionListener(e -> new FrmBarang());
    btnCustomer.addActionListener(e -> new FrmCustomer());
    btnSupplier.addActionListener(e -> new FrmSupplier());
    btnTransaksi.addActionListener(e -> new FrmTransaksi());
    btnLaporan.addActionListener(e -> new Laporan());

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
}


}
