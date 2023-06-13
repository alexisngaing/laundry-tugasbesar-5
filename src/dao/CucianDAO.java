package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import model.Cucian;
import model.Pelanggan;
import model.Mesin;

public class CucianDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    private String bool;
    
    public void insertCucian(Cucian c){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO cucian(statusCuci, statusDry, berat, tglMasuk, tglKeluar, idPelanggan, idMesin) "
                + "VALUES ('"+c.isStatusCuci()+"', 'False', '" + c.getBerat() + "', '" + c.getTglMasuk() +"', '"
                + c.getTglKeluar() +"', '"+ c.getPelanggan().getIdPelanggan() +"', '"+ c.getMesin().getIdMesin() +"')";
        
        System.out.println("Adding Cucian");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Cucian");
            statement.close();
        } catch (Exception e) {
            System.out.println("[!] Error Adding Cucian");
            System.out.println(e);
        }   
    }
    
    public List<Cucian> showCucian(String query) {
        con = dbCon.makeConnection();
        
        bool = "false";
        
        String sql = "SELECT c.*, p.*, m.* FROM cucian as c JOIN mesin as m ON c.idMesin = m.id JOIN pelanggan as p ON c.idPelanggan = p.id WHERE (c.id LIKE "
                + "'%" + query + "%'"
                + "AND c.statusCuci = '" + bool + "'"
//                + "OR c.statusDry LIKE '%" + query + "%'"
                + "AND c.berat LIKE '%" + query + "%'"
                + "AND c.tglMasuk LIKE '%" + query + "%'"
                + "AND m.id LIKE '%" + query + "%'"
                + "AND p.nama LIKE '%" + query + "%')";
        
        System.out.println("Mengambil data Cucian...");
        System.out.println(sql);

        List<Cucian> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    Mesin m = new Mesin(
                            rs.getInt("m.id"),
                            rs.getBoolean("m.status"),
                            rs.getFloat("m.kapasitas"),
                            rs.getString("m.durasi")
                    );
                    
                    Pelanggan p = new Pelanggan(
                            rs.getInt("p.id"),
                            rs.getString("p.nama"),
                            rs.getString("p.noTelp"),
                            rs.getString("p.alamat")
                    );
                    
                    Cucian c = new Cucian(
                            rs.getInt("c.id"),
                            rs.getBoolean("c.statusCuci"),
                            rs.getBoolean("c.statusDry"),
                            rs.getFloat("c.berat"),
                            rs.getString("c.tglMasuk"),
                            rs.getString("c.tglKeluar"),
                            m, p
                    );
                    list.add(c);
                }
            }
        } catch (Exception e) {
            System.out.println("[!] Error Reading Cucian...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
    
    public Cucian searchCucian(int idCucian){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM cucian WHERE id = " + idCucian;
        System.out.println("Searching Cucian...");
        
        Cucian cucian = null;
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null ) {
                while (rs.next()) {
                    Mesin m = new Mesin(
                            rs.getInt("m.id"),
                            rs.getBoolean("m.status"),
                            rs.getFloat("m.kapasitas"),
                            rs.getString("m.durasi")
                    );
                    
                    Pelanggan p = new Pelanggan(
                            rs.getInt("p.id"),
                            rs.getString("p.nama"),
                            rs.getString("p.noTelp"),
                            rs.getString("p.alamat")
                    );
                    
                    Cucian c = new Cucian(
                            rs.getInt("c.id"),
                            rs.getBoolean("c.statusCuci"),
                            rs.getBoolean("c.statusDry"),
                            rs.getFloat("c.berat"),
                            rs.getString("c.tglMasuk"),
                            rs.getString("c.tglKeluar"),
                            m, p
                    );
                }       
            }
            rs.close();
            statement.close();
        }catch (Exception e) {
            System.out.println("[!] Error Searching Cucian...");
            System.out.println(e);
        }
        dbCon.closeConnection();

        return cucian;
    }
    //
    public void updateCucian(Cucian c){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE cucian SET "
                + "statusCuci = '" + c.isStatusCuci() + "', "
//                + "statusDry = '" + c.isStatusDry() + "', "
                + "berat = '" + c.getBerat() + "', "
                + "tglMasuk = '" + c.getTglMasuk() + "', "
                + "tglKeluar = '" + c.getTglKeluar() + "', "
                + "idPelanggan = " + c.getPelanggan().getIdPelanggan() + ", "
                + "idMesin = " + c.getMesin().getIdMesin() + " "
                + "WHERE id = " + c.getId();
        System.out.println("Update data Cucian...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Cucian" + c.getId());
            statement.close();
        } catch (Exception e) {
            System.out.println("[!] Error update Cucian...");
            System.out.println(e);
        }
    }
    
    public void deleteCucian(int id) {
        con = dbCon.makeConnection();

        String sql = "DELETE FROM cucian WHERE id = '" + id + "'";
        System.out.println("Deleting Cucian...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Cucian " + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("[!] Error deleting Cucian...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
    }
    

}
