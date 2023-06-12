package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cucian;

public class CucianDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertCucian(Cucian C){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO cucian(statusCuci, statusDry, berat, tglMasuk, tglKeluar, idPelanggan, idMesin) "
                + "VALUES ('False', 'False', '" + C.getBerat() + "', '" + C.getTglMasuk() +"', '"
                + C.getTglKeluar() +"', '0', '0')";
        
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
    
    public List<Cucian> showCucian(){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM Cucian";
        System.out.println("Mengambil data Cucian...");

        List<Cucian> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    Cucian c = new Cucian(
                            rs.getInt("id"),
                            rs.getBoolean("status"),
                            rs.getFloat("berat"),
                            rs.getString("tglMasuk"),
                            rs.getString("tglKeluar"),
                            rs.getInt("idMesin"),
                            rs.getBoolean("statusMesin"),
                            rs.getFloat("kapasitas"),
                            rs.getDate("durasi")
                    );
                    list.add(c);
                }
            }
        }catch (Exception e) {
            System.out.println("[!] Error Reading Cucian...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
    
    public Cucian searchCucian(int idCucian){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM cucian WHERE idCucian = " +idCucian;
        System.out.println("Searching Cucian...");
        
        Cucian cucian = null;
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null ){
                while(rs.next()){
//                    rs = new Cucian(
//                            Integer.parseInt(rs.getString("id")),
//                            Boolean.parseBoolean(rs.getString("status")),
//                            Float.parseFloat(rs.getString("berat")),
//                            rs.getString("tglMasuk"),
//                            rs.getString("tglKeluar"),
//                            Integer.parseInt(rs.getString("idMesin")),
//                            Boolean.parseBoolean(rs.getString("statusMesin")),
//                            Float.parseFloat(rs.getString("kapasitas")),
//                            rs.getDate("durasi") 
//                    );
                    
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
    
    public void updateCucian(Cucian c){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE cucian SET berat = '" + c.getBerat() + "', "
                + "tglMasuk = '" + c.getTglMasuk() +"', tglKeluar = '" + c.getTglKeluar() +"' "
                + "WHERE id = '" +c.getId()+ "'";
        System.out.println("Update data Cucian");
        
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
