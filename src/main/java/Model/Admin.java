/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADVAN
 */
public class Admin extends Pengguna {

    private String username;

    public Admin(
            String id,
            String nama,
            String noHp,
            String username) {

        super(id, nama, noHp);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getRole() {
        return "Admin";
    }

    @Override
    public void tampilkanInfo() {

        System.out.println("=== DATA ADMIN ===");

        super.tampilkanInfo();

        System.out.println(
                "Username : " + username
        );
    }
}