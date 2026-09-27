/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.LaundryController;
import Model.Layanan;
import Model.Pelanggan;
import Model.Transaksi;
import java.util.Scanner;

/**
 *
 * @author ADVAN
 */
public class LaundryView {

    private Scanner input;
    private LaundryController controller;

    public LaundryView(
            LaundryController controller) {

        this.controller = controller;
        input = new Scanner(System.in);
    }

    public void mulai() {

        int pilihan;

        do {

            tampilkanMenu();

            pilihan = bacaInt(
                    "Pilih menu: ",
                    0,
                    7
            );

            if (pilihan == 1) {

                tampilkanPelanggan();

            } else if (pilihan == 2) {

                tambahPelanggan();

            } else if (pilihan == 3) {

                tampilkanLayanan();

            } else if (pilihan == 4) {

                tambahTransaksi();

            } else if (pilihan == 5) {

                tampilkanTransaksi();

            } else if (pilihan == 6) {

                updateStatus();

            } else if (pilihan == 7) {

                cariPelanggan();

            } else if (pilihan == 0) {

                System.out.println(
                        "\nProgram selesai."
                );
            }

        } while (pilihan != 0);
    }

    private void tampilkanMenu() {

        System.out.println();
        System.out.println(
                "========================================"
        );

        System.out.println(
                "        SISTEM MANAJEMEN LAUNDRY"
        );

        System.out.println(
                "========================================"
        );

        System.out.println(
                "1. Data Pelanggan"
        );

        System.out.println(
                "2. Tambah Pelanggan"
        );

        System.out.println(
                "3. Data Layanan"
        );

        System.out.println(
                "4. Buat Transaksi"
        );

        System.out.println(
                "5. Data Transaksi"
        );

        System.out.println(
                "6. Update Status Laundry"
        );

        System.out.println(
                "7. Cari Pelanggan"
        );

        System.out.println(
                "0. Keluar"
        );

        System.out.println(
                "========================================"
        );
    }

    private void tampilkanPelanggan() {

        System.out.println(
                "\n=== DATA PELANGGAN ==="
        );

        if (controller.getDaftarPelanggan()
                .isEmpty()) {

            System.out.println(
                    "Belum ada data pelanggan."
            );

            return;
        }

        for (Pelanggan pelanggan
                : controller.getDaftarPelanggan()) {

            pelanggan.tampilkanInfo();

            System.out.println();
        }
    }

    private void tambahPelanggan() {

        System.out.println(
                "\n=== TAMBAH PELANGGAN ==="
        );

        String id;

        do {

            id = bacaString(
                    "ID Pelanggan: "
            );

            if (controller.cariPelanggan(id)
                    != null) {

                System.out.println(
                        "ID sudah digunakan."
                );
            }

        } while (
                controller.cariPelanggan(id)
                != null
        );

        String nama = bacaString(
                "Nama Pelanggan: "
        );

        String noHp = bacaNomorHP();

        Pelanggan pelanggan =
                new Pelanggan(
                        id,
                        nama,
                        noHp
                );

        controller.tambahPelanggan(
                pelanggan
        );

        System.out.println(
                "Pelanggan berhasil ditambahkan."
        );
    }

    private void tampilkanLayanan() {

        System.out.println(
                "\n=== DATA LAYANAN ==="
        );

        for (Layanan layanan
                : controller.getDaftarLayanan()) {

            layanan.tampilkanInfo();

            System.out.println();
        }
    }

    private void tambahTransaksi() {

        System.out.println(
                "\n=== BUAT TRANSAKSI ==="
        );

        if (controller.getDaftarPelanggan()
                .isEmpty()) {

            System.out.println(
                    "Belum ada pelanggan."
            );

            return;
        }

        tampilkanPelanggan();

        String idPelanggan = bacaString(
                "ID Pelanggan: "
        );

        if (controller.cariPelanggan(
                idPelanggan) == null) {

            System.out.println(
                    "Pelanggan tidak ditemukan."
            );

            return;
        }

        tampilkanLayanan();

        String idLayanan = bacaString(
                "ID Layanan: "
        );

        Layanan layanan =
                controller.cariLayanan(
                        idLayanan
                );

        if (layanan == null) {

            System.out.println(
                    "Layanan tidak ditemukan."
            );

            return;
        }

        double jumlah =
                bacaDoublePositif(
                        "Jumlah ("
                        + layanan.getSatuan()
                        + "): "
                );

        String idTransaksi;

        do {

            idTransaksi = bacaString(
                    "ID Transaksi: "
            );

            if (controller.cariTransaksi(
                    idTransaksi) != null) {

                System.out.println(
                        "ID transaksi sudah digunakan."
                );
            }

        } while (
                controller.cariTransaksi(
                        idTransaksi
                ) != null
        );

        boolean berhasil =
                controller.tambahTransaksi(
                        idTransaksi,
                        idPelanggan,
                        idLayanan,
                        jumlah
                );

        if (berhasil) {

            System.out.println(
                    "\nTransaksi berhasil dibuat."
            );

            Transaksi transaksi =
                    controller.cariTransaksi(
                            idTransaksi
                    );

            transaksi.tampilkanInfo();

        } else {

            System.out.println(
                    "Transaksi gagal dibuat."
            );
        }
    }

    private void tampilkanTransaksi() {

        System.out.println(
                "\n=== DATA TRANSAKSI ==="
        );

        if (controller.getDaftarTransaksi()
                .isEmpty()) {

            System.out.println(
                    "Belum ada transaksi."
            );

            return;
        }

        for (Transaksi transaksi
                : controller.getDaftarTransaksi()) {

            transaksi.tampilkanInfo();
        }
    }

    private void updateStatus() {

        System.out.println(
                "\n=== UPDATE STATUS LAUNDRY ==="
        );

        String id = bacaString(
                "ID Transaksi: "
        );

        Transaksi transaksi =
                controller.cariTransaksi(id);

        if (transaksi == null) {

            System.out.println(
                    "Transaksi tidak ditemukan."
            );

            return;
        }

        System.out.println();
        System.out.println(
                "1. Diproses"
        );

        System.out.println(
                "2. Dicuci"
        );

        System.out.println(
                "3. Disetrika"
        );

        System.out.println(
                "4. Selesai"
        );

        System.out.println(
                "5. Diambil"
        );

        int pilihan = bacaInt(
                "Pilih status: ",
                1,
                5
        );

        String status;

        if (pilihan == 1) {

            status = "Diproses";

        } else if (pilihan == 2) {

            status = "Dicuci";

        } else if (pilihan == 3) {

            status = "Disetrika";

        } else if (pilihan == 4) {

            status = "Selesai";

        } else {

            status = "Diambil";
        }

        transaksi.setStatus(status);

        System.out.println(
                "Status berhasil diperbarui menjadi: "
                + status
        );
    }

    private void cariPelanggan() {

        System.out.println(
                "\n=== CARI PELANGGAN ==="
        );

        System.out.println(
                "1. Cari berdasarkan ID"
        );

        System.out.println(
                "2. Cari berdasarkan Nama + No HP"
        );

        int pilihan = bacaInt(
                "Pilih metode pencarian: ",
                1,
                2
        );

        if (pilihan == 1) {

            String id = bacaString(
                    "Masukkan ID pelanggan: "
            );

            // MEMANGGIL OVERLOADING 1
            Pelanggan pelanggan =
                    controller.cariPelanggan(
                            id
                    );

            if (pelanggan != null) {

                System.out.println(
                        "\nPelanggan ditemukan:"
                );

                pelanggan.tampilkanInfo();

            } else {

                System.out.println(
                        "Pelanggan tidak ditemukan."
                );
            }

        } else {

            String nama = bacaString(
                    "Masukkan nama pelanggan: "
            );

            String noHp = bacaNomorHP();

            // MEMANGGIL OVERLOADING 2
            Pelanggan pelanggan =
                    controller.cariPelanggan(
                            nama,
                            noHp
                    );

            if (pelanggan != null) {

                System.out.println(
                        "\nPelanggan ditemukan:"
                );

                pelanggan.tampilkanInfo();

            } else {

                System.out.println(
                        "Pelanggan tidak ditemukan."
                );
            }
        }
    }

    private String bacaString(
            String pesan) {

        String hasil;

        do {

            System.out.print(pesan);

            hasil =
                    input.nextLine().trim();

            if (hasil.isEmpty()) {

                System.out.println(
                        "Input tidak boleh kosong."
                );
            }

        } while (hasil.isEmpty());

        return hasil;
    }

    private int bacaInt(
            String pesan,
            int min,
            int max) {

        while (true) {

            try {

                System.out.print(pesan);

                int nilai =
                        Integer.parseInt(
                                input.nextLine()
                        );

                if (nilai < min
                        || nilai > max) {

                    System.out.println(
                            "Masukkan angka "
                            + min
                            + " sampai "
                            + max
                            + "."
                    );

                } else {

                    return nilai;
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Input harus berupa angka."
                );
            }
        }
    }

    private double bacaDoublePositif(
            String pesan) {

        while (true) {

            try {

                System.out.print(pesan);

                double nilai =
                        Double.parseDouble(
                                input.nextLine()
                        );

                if (nilai <= 0) {

                    System.out.println(
                            "Jumlah harus lebih dari 0."
                    );

                } else {

                    return nilai;
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Input harus berupa angka."
                );
            }
        }
    }

    private String bacaNomorHP() {

        while (true) {

            System.out.print(
                    "No. HP: "
            );

            String noHp =
                    input.nextLine().trim();

            if (!noHp.matches("\\d+")) {

                System.out.println(
                        "No. HP hanya boleh berisi angka."
                );

            } else if (
                    noHp.length() < 10
                    || noHp.length() > 13) {

                System.out.println(
                        "No. HP harus 10-13 digit."
                );

            } else {

                return noHp;
            }
        }
    }
}