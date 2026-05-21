    package mahasiswa;

import java.util.Scanner;

public class Mahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("NIM   : ");
        String nim = input.nextLine();

        System.out.print("Nama  : ");
        String nama = input.nextLine();

        double uts = inputAngka(input, "Nilai UTS   : ");
        double uas = inputAngka(input, "Nilai UAS   : ");
        double tugas = inputAngka(input, "Nilai Tugas : ");

        double nilaiAkhir = (0.3 * uts) + (0.4 * uas) + (0.3 * tugas);

        System.out.println("\nNilai Akhir : " + nilaiAkhir);
    }

    public static double inputAngka(Scanner input, String pesan) {
        while (true) {
            System.out.print(pesan);
            try {
                String nilaiStr = input.nextLine();
                return Double.parseDouble(nilaiStr);
            } catch (Exception e) {
                System.out.println("❌ Harus angka!");
            }
        }
    }
}