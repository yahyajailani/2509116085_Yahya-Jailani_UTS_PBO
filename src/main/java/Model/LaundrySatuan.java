/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADVAN
 */
public class LaundrySatuan extends Layanan {

    private double hargaPerItem;

    public LaundrySatuan(
            String idLayanan,
            String namaLayanan,
            double hargaPerItem) {

        super(idLayanan, namaLayanan);

        this.hargaPerItem = hargaPerItem;
    }

    public double getHargaPerItem() {
        return hargaPerItem;
    }

    public void setHargaPerItem(double hargaPerItem) {
        this.hargaPerItem = hargaPerItem;
    }

    @Override
    public double hitungHarga(double jumlah) {

        return hargaPerItem * jumlah;
    }

    @Override
    public String getSatuan() {
        return "Item";
    }

    @Override
    public void tampilkanInfo() {

        System.out.println(
                "=== LAYANAN SATUAN ==="
        );

        super.tampilkanInfo();

        System.out.println(
                "Harga / Item : Rp"
                + String.format("%.2f", hargaPerItem)
        );
    }
}