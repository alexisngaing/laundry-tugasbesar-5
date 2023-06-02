/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Pelanggan;

public class PelangganDAO {

    private DbConnection dbCon = new DbConnection();
    private Connection con;

    public void insertPelanggan(Pelanggan P) {
        con = dbCon.makeConnection();

        String sql = "INSERT INTO pelanggan(nama, noTelp, alamat) "
                + "VALUES ('" + P.getNama() + "', '" + P.getNoTelp() + "', '"
                + P.getAlamat() + "')";

        System.out.println("Adding Pelanggan");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Pelanggan");
            statement.close();
        } catch (Exception e) {
            System.out.println("[!] Error Adding Pelanggan");
            System.out.println(e);
        }
    }

    public List<Pelanggan> showPelanggan() {
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM Pelanggan";
        System.out.println("Mengambil data Pelanggan...");

        List<Pelanggan> list = new ArrayList();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    Pelanggan p = new Pelanggan(
                            rs.getInt("id"),
                            rs.getString("nama"),
                            rs.getString("noTelp"),
                            rs.getString("alamat")
                    );
                    list.add(p);
                }
            }
        } catch (Exception e) {
            System.out.println("Error Reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();

        return list;
    }

}
