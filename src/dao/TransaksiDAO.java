package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Pelanggan;
import model.Cucian;
import model.Transaksi;
import model.Mesin;

public class TransaksiDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertTransaksi(Transaksi t){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO transaksi(idCustomer, totalBiaya) VALUES ('"
                + t.getPelanggan().getIdPelanggan() + "', '" + t.getTotalBiaya() + "')";
        
        System.out.println("Adding Transaksi...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Transaksi");
            statement.close();
        } catch (Exception e) {
            System.out.println("[!] Error Adding Transaksi");
            System.out.println(e);
        }   
    }
    
    public List<Transaksi> showTransaksi(String query) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT t.*, c.*, p.*, m.* FROM transaksi as t JOIN cucian as c ON t.idCucian = c.id JOIN pelanggan as p ON c.idPelanggan = p.id JOIN mesin as m ON c.idMesin = m. id WHERE (t.idTransaksi LIKE "
                + "'%" + query + "%'"
                + "OR p.nama LIKE '%" + query + "%'"
                + "OR c.tglMasuk LIKE '%" + query + "%'"
                + "OR c.berat LIKE '%" + query + "%'"
                + "OR t.totalBiaya LIKE '%" + query + "%')"
                + "ORDER BY t.idTransaksi";
        
        System.out.println("Fetching Transaksi data...");

        List<Transaksi> list = new ArrayList<>();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    Mesin mesin = new Mesin(
                            rs.getInt("m.id"),
                            rs.getBoolean("m.status"),
                            rs.getFloat("m.kapasitas"),
                            rs.getString("m.durasi")
                    );
                    
                    Pelanggan pelanggan = new Pelanggan(
                            rs.getInt("p.id"),
                            rs.getString("p.nama"),
                            rs.getString("p.noTelp"),
                            rs.getString("p.alamat")
                    );
                    
                    Cucian cucian = new Cucian(
                            rs.getInt("c.id"),
                            rs.getBoolean("c.statusCuci"),
                            rs.getBoolean("c.statusDry"),
                            rs.getFloat("c.berat"),
                            rs.getString("c.tglMasuk"),
                            rs.getString("c.tglKeluar"),
                            null, pelanggan
                    );
                    
                    Transaksi transaksi = new Transaksi(
                            rs.getInt("t.idTransaksi"),
                            rs.getFloat("t.totalBiaya"),
                            pelanggan, cucian
                    );
                    list.add(transaksi);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("[!] Error Fetching Transaksi data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
    
    public Transaksi searchTransaksi(int idTransaksi){
        con = dbCon.makeConnection();
        
//        String sql = "SELECT t.*, p.*, c.* FROM transaksi as t "
//                + "JOIN pelanggan as p ON t.idPelanggan = p.id "
//                + "JOIN cucian as c ON t.idCucian = c.id "
//                + "WHERE t.idTransaksi = " + idTransaksi;
        String sql = "SELECT * FROM transaksi WHERE idTransaksi = '" + idTransaksi + "'";

        System.out.println("Searching Transaksi...");
        
        Transaksi transaksi = null;
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null ) {
                while (rs.next()) {
                    Mesin mesin = new Mesin(
                            rs.getInt("id"),
                            rs.getBoolean("status"),
                            rs.getFloat("kapasitas"),
                            rs.getString("durasi")
                    );
                    
                    Pelanggan pelanggan = new Pelanggan(
                            rs.getInt("id"),
                            rs.getString("nama"),
                            rs.getString("noTelp"),
                            rs.getString("alamat")
                    );
                    
                    Cucian cucian = new Cucian(
                            rs.getInt("id"),
                            rs.getBoolean("statusCuci"),
                            rs.getBoolean("statusDry"),
                            rs.getFloat("berat"),
                            rs.getString("tglMasuk"),
                            rs.getString("tglKeluar"),
                            null,
                            pelanggan
                    );
                    
                    transaksi = new Transaksi(
                            rs.getInt("idTransaksi"),
                            rs.getFloat("totalBiaya"),
                            pelanggan,
                            cucian
                    );
                }       
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("[!] Error Searching Transaksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();

        return transaksi;
    }
    
    public void updateTransaksi(Transaksi t){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE transaksi SET "
                + "totalBiaya = '" + t.getTotalBiaya() + "', "
                + "idPelanggan = " + t.getPelanggan().getIdPelanggan() + ", "
                + "idCucian = " + t.getCucian().getId() + " "
                + "WHERE idTransaksi = " + t.getIdTransaksi();
        
        System.out.println("Updating Transaksi...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Updated " + result + " Transaksi " + t.getIdTransaksi());
            statement.close();
        } catch (Exception e) {
            System.out.println("[!] Error updating Transaksi...");
            System.out.println(e);
        }
    }
    
    public void deleteTransaksi(int idTransaksi) {
        con = dbCon.makeConnection();

        String sql = "DELETE FROM transaksi WHERE idTransaksi = " + idTransaksi;
        
        System.out.println("Deleting Transaksi...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + " Transaksi " + idTransaksi);
            statement.close();
        } catch (Exception e) {
            System.out.println("[!] Error deleting Transaksi...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
}
