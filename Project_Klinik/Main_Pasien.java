package Project_Klinik;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main_Pasien {

    static ArrayList<Model_Pasien> dataPasien = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        loadData();

        if (dataPasien.isEmpty()) {
            dataAwal();
        }

        int pilih;

        do {

            System.out.println("\n================================");
            System.out.println("      SISTEM DATA KLINIK");
            System.out.println("================================");
            System.out.println("1. Tambah Pasien");
            System.out.println("2. Tampilkan Pasien");
            System.out.println("3. Update Pasien");
            System.out.println("4. Hapus Pasien");
            System.out.println("5. Cari Pasien");
            System.out.println("6. Simpan Data");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu : ");

            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {

                case 1:
                    tambahPasien();
                    break;

                case 2:
                    tampilPasien();
                    break;

                case 3:
                    updatePasien();
                    break;

                case 4:
                    hapusPasien();
                    break;

                case 5:
                    cariPasien();
                    break;

                case 6:
                    simpanData();
                    break;

                case 0:
                    simpanData();
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia!");
            }

        } while (pilih != 0);
    }

    static void dataAwal() {

        dataPasien.add(new Model_Pasien(
                "RM001",
                "Andi",
                20,
                "Demam",
                "Dr. Budi"));

        dataPasien.add(new Model_Pasien(
                "RM002",
                "Siti",
                22,
                "Batuk",
                "Dr. Rina"));

        dataPasien.add(new Model_Pasien(
                "RM003",
                "Rizky",
                25,
                "Flu",
                "Dr. Ahmad"));
    }

    static void tambahPasien() {

        System.out.print("No RM     : ");
        String noRM = input.nextLine();

        System.out.print("Nama      : ");
        String nama = input.nextLine();

        System.out.print("Umur      : ");
        int umur = input.nextInt();
        input.nextLine();

        System.out.print("Keluhan   : ");
        String keluhan = input.nextLine();

        System.out.print("Dokter    : ");
        String dokter = input.nextLine();

        dataPasien.add(new Model_Pasien(
                noRM,
                nama,
                umur,
                keluhan,
                dokter));

        System.out.println("Data berhasil ditambahkan.");
    }

    static void tampilPasien() {

        if (dataPasien.isEmpty()) {

            System.out.println("Data pasien kosong.");
            return;
        }

        System.out.println("\n================================================================================");
        System.out.printf("%-10s %-15s %-10s %-20s %-15s\n",
                "No RM",
                "Nama",
                "Umur",
                "Keluhan",
                "Dokter");
        System.out.println("================================================================================");

        for (Model_Pasien p : dataPasien) {

            System.out.printf("%-10s %-15s %-10d %-20s %-15s\n",
                    p.getNoRM(),
                    p.getNama(),
                    p.getUmur(),
                    p.getKeluhan(),
                    p.getDokter());
        }

        System.out.println("================================================================================");
    }

    static void updatePasien() {

        System.out.print("Masukkan No RM : ");
        String cari = input.nextLine();

        for (Model_Pasien p : dataPasien) {

            if (p.getNoRM().equalsIgnoreCase(cari)) {

                System.out.print("Nama Baru     : ");
                p.setNama(input.nextLine());

                System.out.print("Umur Baru     : ");
                p.setUmur(input.nextInt());
                input.nextLine();

                System.out.print("Keluhan Baru  : ");
                p.setKeluhan(input.nextLine());

                System.out.print("Dokter Baru   : ");
                p.setDokter(input.nextLine());

                System.out.println("Data berhasil diupdate.");
                return;
            }
        }

        System.out.println("Data tidak ditemukan.");
    }

    static void hapusPasien() {

        System.out.print("Masukkan No RM : ");
        String cari = input.nextLine();

        for (int i = 0; i < dataPasien.size(); i++) {

            if (dataPasien.get(i).getNoRM().equalsIgnoreCase(cari)) {

                dataPasien.remove(i);

                System.out.println("Data berhasil dihapus.");
                return;
            }
        }

        System.out.println("Data tidak ditemukan.");
    }

    static void cariPasien() {

        if (dataPasien.isEmpty()) {

            System.out.println("Data pasien kosong.");
            return;
        }

        System.out.print("Masukkan Nama Pasien : ");
        String cari = input.nextLine();

        boolean ditemukan = false;

        System.out.println("\n===== HASIL PENCARIAN =====");

        for (Model_Pasien p : dataPasien) {

            if (p.getNama().toLowerCase().contains(cari.toLowerCase())) {

                System.out.println("----------------------------");
                System.out.println("No RM    : " + p.getNoRM());
                System.out.println("Nama     : " + p.getNama());
                System.out.println("Umur     : " + p.getUmur());
                System.out.println("Keluhan  : " + p.getKeluhan());
                System.out.println("Dokter   : " + p.getDokter());

                ditemukan = true;
            }
        }

        if (!ditemukan) {

            System.out.println("Data pasien tidak ditemukan.");
        }
    }

    static void simpanData() {

        try {

            PrintWriter tulis =
                    new PrintWriter(new FileWriter("pasien.txt"));

            for (Model_Pasien p : dataPasien) {

                tulis.println(
                        p.getNoRM() + ";" +
                        p.getNama() + ";" +
                        p.getUmur() + ";" +
                        p.getKeluhan() + ";" +
                        p.getDokter()
                );
            }

            tulis.close();

            System.out.println("Data berhasil disimpan.");

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());
        }
    }

    static void loadData() {

        try {

            File file = new File("pasien.txt");

            if (!file.exists()) {
                return;
            }

            Scanner baca = new Scanner(file);

            while (baca.hasNextLine()) {

                String data = baca.nextLine();

                String[] p = data.split(";");

                if (p.length == 5) {

                    dataPasien.add(
                            new Model_Pasien(
                                    p[0],
                                    p[1],
                                    Integer.parseInt(p[2]),
                                    p[3],
                                    p[4]
                            )
                    );
                }
            }

            baca.close();

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());
        }
    }
}