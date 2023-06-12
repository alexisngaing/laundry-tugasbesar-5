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
            System.out.println("[!] Error Reading Pelanggan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }

    public Pelanggan searchPelanggan(String nama) {
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM pelanggan WHERE nama LIKE '%" + nama + "%'";
        System.out.println("Searching Pelanggan...");
        Pelanggan p = null;

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    p = new Pelanggan(
                            rs.getInt("id"),
                            rs.getString("nama"),
                            rs.getString("noTelp"),
                            rs.getString("alamat")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println("[!] Error Search Pelanggan...");
            System.out.println(e);
        }
        dbCon.closeConnection();

        return p;
    }
    
    public List<Pelanggan> showPelangganBySearch(String query) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM pelanggan WHERE (id LIKE "
                + "'%" + query + "%'"
                + "OR nama LIKE '%" + query + "%'"
                + "OR noTelp LIKE '%" + query + "%'"
                + "OR alamat LIKE '%" + query + "%')";
        
        System.out.println("Mengambil data Pasien...");
        
        List<Pelanggan> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null) {
                while (rs.next()) {
                    Pelanggan p = new Pelanggan(
                            Integer.parseInt(rs.getString("id")),
                            rs.getString("nama"),
                            rs.getString("noTelp"),
                            rs.getString("alamat")
                    );
                    list.add(p);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.err.println("Error reading database!");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }

    public void updatePelanggan(Pelanggan p, int id) {
        con = dbCon.makeConnection();

        String sql = "UPDATE pelanggan SET nama = '" + p.getNama() + "', "
                + "noTelp = '" + p.getNoTelp() + "', alamat = '" + p.getAlamat() + "' "
                + "WHERE id = '" + id + "'";
        System.out.println("Update data pelanggan");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Pelanggan " + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("[!] Error update Pelanggan...");
            System.out.println(e);
        }
    }

    public void deletePelanggan(int id) {
        con = dbCon.makeConnection();

        String sql = "DELETE FROM pelanggan WHERE id = '" + id + "'";
        System.out.println("Deleting Pelanggan...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Pelanggan " + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("[!] Error deleting Pelanggan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

}
