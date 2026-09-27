/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADVAN
 */
public class Transaksi {

    private String idTransaksi;
    private Pelanggan pelanggan;
    private Layanan layanan;

    private double jumlah;
    private double hargaAwal;
    private double diskon;
    private double totalBayar;

    private String status;

    public Transaksi(
            String idTransaksi,
            Pelanggan pelanggan,
            Layanan layanan,
            double jumlah) {

        this.idTransaksi = idTransaksi;
        this.pelanggan = pelanggan;
        this.layanan = layanan;
        this.jumlah = jumlah;

        this.status = "Diproses";

        hitungTotal();
    }

    public void hitungTotal() {

        hargaAwal =
                layanan.hitungHarga(jumlah);

        if (hargaAwal >= 100000) {

            diskon = hargaAwal * 0.10;

        } else if (hargaAwal >= 50000) {

            diskon = hargaAwal * 0.05;

        } else {

            diskon = 0;
        }

        totalBayar = hargaAwal - diskon;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public Layanan getLayanan() {
        return layanan;
    }

    public double getJumlah() {
        return jumlah;
    }

    public double getHargaAwal() {
        return hargaAwal;
    }

    public double getDiskon() {
        return diskon;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setJumlah(double jumlah) {

        if (jumlah > 0) {

            this.jumlah = jumlah;

            hitungTotal();
        }
    }

    public void tampilkanInfo() {

        System.out.println(
                "----------------------------------------"
        );

        System.out.println(
                "ID Transaksi : " + idTransaksi
        );

        System.out.println(
                "Pelanggan    : "
                + pelanggan.getNama()
        );

        System.out.println(
                "Layanan      : "
                + layanan.getNamaLayanan()
        );

        System.out.println(
                "Jumlah       : "
                + jumlah + " "
                + layanan.getSatuan()
        );

        System.out.println(
                "Harga Awal   : Rp"
                + String.format("%.2f", hargaAwal)
        );

        System.out.println(
                "Diskon       : Rp"
                + String.format("%.2f", diskon)
        );

        System.out.println(
                "Total Bayar   : Rp"
                + String.format("%.2f", totalBayar)
        );

        System.out.println(
                "Status       : " + status
        );

        System.out.println(
                "----------------------------------------"
        );
    }
}