/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADVAN
 */
public abstract class Pengguna {

    private String id;
    private String nama;
    private String noHp;

    public Pengguna(String id, String nama, String noHp) {
        this.id = id;
        this.nama = nama;
        this.noHp = noHp;
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNoHp() {
        return noHp;
    }

    // Setter
    public void setId(String id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    // Method abstract untuk polymorphism
    public abstract String getRole();

    // Method yang dapat dioverride
    public void tampilkanInfo() {
        System.out.println("ID       : " + id);
        System.out.println("Nama     : " + nama);
        System.out.println("No. HP   : " + noHp);
        System.out.println("Role     : " + getRole());
    }
}