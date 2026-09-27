/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Admin;
import Model.LaundryKiloan;
import Model.LaundrySatuan;
import Model.Layanan;
import Model.Pelanggan;
import Model.Transaksi;
import java.util.ArrayList;
/**
 *
 * @author ADVAN
 */
public class LaundryController {

    private ArrayList<Pelanggan> daftarPelanggan;
    private ArrayList<Layanan> daftarLayanan;
    private ArrayList<Transaksi> daftarTransaksi;

    private Admin admin;

    public LaundryController() {

        daftarPelanggan = new ArrayList<>();
        daftarLayanan = new ArrayList<>();
        daftarTransaksi = new ArrayList<>();

        admin = new Admin(
                "ADM001",
                "Admin Laundry",
                "081234567890",
                "admin"
        );

        daftarPelanggan.add(
                new Pelanggan(
                        "PLG001",
                        "Budi",
                        "085283939283"
                )
        );

        daftarPelanggan.add(
                new Pelanggan(
                        "PLG002",
                        "Siti",
                        "081252766628"
                )
        );

        daftarLayanan.add(
                new LaundryKiloan(
                        "LYN001",
                        "Cuci Kering",
                        7000
                )
        );

        daftarLayanan.add(
                new LaundryKiloan(
                        "LYN002",
                        "Cuci Setrika",
                        10000
                )
        );

        daftarLayanan.add(
                new LaundrySatuan(
                        "LYN003",
                        "Cuci Selimut",
                        25000
                )
        );

        daftarLayanan.add(
                new LaundrySatuan(
                        "LYN004",
                        "Cuci Karpet",
                        50000
                )
        );
    }

    public Admin getAdmin() {
        return admin;
    }

    public void tambahPelanggan(
            Pelanggan pelanggan) {

        daftarPelanggan.add(pelanggan);
    }

    public ArrayList<Pelanggan>
            getDaftarPelanggan() {

        return daftarPelanggan;
    }

    // Overloading
    public Pelanggan cariPelanggan(
            String id) {

        for (Pelanggan pelanggan
                : daftarPelanggan) {

            if (pelanggan.getId()
                    .equalsIgnoreCase(id)) {

                return pelanggan;
            }
        }

        return null;
    }

    // Overloading
    public Pelanggan cariPelanggan(
            String nama,
            String noHp) {

        for (Pelanggan pelanggan
                : daftarPelanggan) {

            if (pelanggan.getNama()
                    .equalsIgnoreCase(nama)
                    && pelanggan.getNoHp()
                    .equals(noHp)) {

                return pelanggan;
            }
        }

        return null;
    }

    public boolean hapusPelanggan(
            String id) {

        Pelanggan pelanggan =
                cariPelanggan(id);

        if (pelanggan != null) {

            daftarPelanggan.remove(
                    pelanggan
            );

            return true;
        }

        return false;
    }

    public void tambahLayanan(
            Layanan layanan) {

        daftarLayanan.add(layanan);
    }

    public ArrayList<Layanan>
            getDaftarLayanan() {

        return daftarLayanan;
    }

    public Layanan cariLayanan(
            String id) {

        for (Layanan layanan
                : daftarLayanan) {

            if (layanan.getIdLayanan()
                    .equalsIgnoreCase(id)) {

                return layanan;
            }
        }

        return null;
    }

    public boolean hapusLayanan(
            String id) {

        Layanan layanan =
                cariLayanan(id);

        if (layanan != null) {

            daftarLayanan.remove(
                    layanan
            );

            return true;
        }

        return false;
    }

    public boolean tambahTransaksi(
            String idTransaksi,
            String idPelanggan,
            String idLayanan,
            double jumlah) {

        Pelanggan pelanggan =
                cariPelanggan(idPelanggan);

        Layanan layanan =
                cariLayanan(idLayanan);

        if (pelanggan == null) {
            return false;
        }

        if (layanan == null) {
            return false;
        }

        if (jumlah <= 0) {
            return false;
        }

        if (cariTransaksi(idTransaksi)
                != null) {

            return false;
        }

        Transaksi transaksi =
                new Transaksi(
                        idTransaksi,
                        pelanggan,
                        layanan,
                        jumlah
                );

        daftarTransaksi.add(transaksi);

        pelanggan.tambahTransaksi();

        return true;
    }

    public ArrayList<Transaksi>
            getDaftarTransaksi() {

        return daftarTransaksi;
    }

    public Transaksi cariTransaksi(
            String id) {

        for (Transaksi transaksi
                : daftarTransaksi) {

            if (transaksi.getIdTransaksi()
                    .equalsIgnoreCase(id)) {

                return transaksi;
            }
        }

        return null;
    }
}