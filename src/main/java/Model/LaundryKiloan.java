/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADVAN
 */
public class LaundryKiloan extends Layanan {

    private double hargaPerKg;

    public LaundryKiloan(
            String idLayanan,
            String namaLayanan,
            double hargaPerKg) {

        super(idLayanan, namaLayanan);

        this.hargaPerKg = hargaPerKg;
    }

    public double getHargaPerKg() {
        return hargaPerKg;
    }

    public void setHargaPerKg(double hargaPerKg) {
        this.hargaPerKg = hargaPerKg;
    }

    @Override
    public double hitungHarga(double jumlah) {

        return hargaPerKg * jumlah;
    }

    @Override
    public String getSatuan() {
        return "Kg";
    }

    @Override
    public void tampilkanInfo() {

        System.out.println(
                "=== LAYANAN KILOAN ==="
        );

        super.tampilkanInfo();

        System.out.println(
                "Harga / Kg : Rp"
                + String.format("%.2f", hargaPerKg)
        );
    }
}