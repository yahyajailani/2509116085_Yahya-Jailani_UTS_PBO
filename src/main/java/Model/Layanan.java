/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADVAN
 */
public abstract class Layanan {

    private String idLayanan;
    private String namaLayanan;

    public Layanan(
            String idLayanan,
            String namaLayanan) {

        this.idLayanan = idLayanan;
        this.namaLayanan = namaLayanan;
    }

    public String getIdLayanan() {
        return idLayanan;
    }

    public String getNamaLayanan() {
        return namaLayanan;
    }

    public void setIdLayanan(String idLayanan) {
        this.idLayanan = idLayanan;
    }

    public void setNamaLayanan(String namaLayanan) {
        this.namaLayanan = namaLayanan;
    }

    // dioverride ke kiloan dan satuan
    public abstract double hitungHarga(double jumlah);

    public abstract String getSatuan();

    public void tampilkanInfo() {

        System.out.println(
                "ID Layanan : " + idLayanan
        );

        System.out.println(
                "Nama       : " + namaLayanan
        );

        System.out.println(
                "Satuan     : " + getSatuan()
        );
    }
}