/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADVAN
 */
public class Pelanggan extends Pengguna {

    private int jumlahTransaksi;

    public Pelanggan(
            String id,
            String nama,
            String noHp) {

        super(id, nama, noHp);

        jumlahTransaksi = 0;
    }

    public int getJumlahTransaksi() {
        return jumlahTransaksi;
    }

    public void setJumlahTransaksi(
            int jumlahTransaksi) {

        this.jumlahTransaksi = jumlahTransaksi;
    }

    public void tambahTransaksi() {
        jumlahTransaksi++;
    }

    @Override
    public String getRole() {
        return "Pelanggan";
    }

    @Override
    public void tampilkanInfo() {

        System.out.println("=== DATA PELANGGAN ===");

        super.tampilkanInfo();

        System.out.println(
                "Jumlah Transaksi : "
                + jumlahTransaksi
        );
    }
}