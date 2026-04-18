package nilaimhs;

import java.util.Scanner;

public class NilaiMhs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String nim, nama;
        double uts, uas, rata;

        System.out.println("data: ");

        System.out.print("nim: ");
        nim = input.nextLine();

        System.out.print("nama: ");
        nama = input.nextLine(); // bisa pakai spasi

        // input angka aman
        uts = inputAngka(input, "nilai UTS: ");
        uas = inputAngka(input, "nilai UAS: ");

        rata = (uts + uas) / 2;

        System.out.println("\n=================================");
        System.out.println("Nim\tNama\tUTS\tUAS\tRata2");
        System.out.println("=================================");
        System.out.println(nim + "\t" + nama + "\t" + uts + "\t" + uas + "\t" + rata);
    }

    // method input angka anti error
    public static double inputAngka(Scanner input, String pesan) {
        while (true) {
            System.out.print(pesan);
            try {
                String nilai = input.nextLine();
                return Double.parseDouble(nilai);
            } catch (Exception e) {
                System.out.println("❌ Harus angka!");
            }
        }
    }
}