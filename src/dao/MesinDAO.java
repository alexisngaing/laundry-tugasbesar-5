package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Mesin;
import model.MesinCuci;
import model.Dryer;

public class MesinDAO {
    
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertMesin(Mesin mesin) {
        con = dbCon.makeConnection();

        String sql = "INSERT INTO mesin(idMesin, statusMesin, kapasitas, durasi) "
                + "VALUES (" + mesin.getIdMesin() + ", " + mesin.getStatusMesin() + ", "
                + mesin.getKapasitas() + ", '" + mesin.getDurasi() + "')";

        System.out.println("Adding Mesin");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Mesin");
            statement.close();
        } catch (Exception e) {
            System.out.println("[!] Error Adding Mesin");
            System.out.println(e);
        }
    }
    
    public List<Mesin> showMesin() {
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM mesin";
        System.out.println("Fetching Mesin data...");

        List<Mesin> list = new ArrayList<>();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    int idMesin = rs.getInt("idMesin");
                    boolean statusMesin = rs.getBoolean("statusMesin");
                    float kapasitas = rs.getFloat("kapasitas");
                    String durasi = rs.getString("durasi");

                    Mesin mesin = new MesinCuci(idMesin, statusMesin, kapasitas, durasi); // or Dryer
                    list.add(mesin);
                }
            }
        } catch (Exception e) {
            System.out.println("[!] Error Fetching Mesin data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
    
    public Mesin searchMesin(int idMesin) {
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM mesin WHERE idMesin = " + idMesin;
        System.out.println("Searching Mesin...");

        Mesin mesin = null;

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null && rs.next()) {
                boolean statusMesin = rs.getBoolean("statusMesin");
                float kapasitas = rs.getFloat("kapasitas");
                String durasi = rs.getString("durasi");

                mesin = new MesinCuci(idMesin, statusMesin, kapasitas, durasi); // or Dryer
            }
        } catch (Exception e) {
            System.out.println("[!] Error Searching Mesin...");
            System.out.println(e);
        }
        dbCon.closeConnection();

        return mesin;
    }
    
    public void updateMesin(Mesin mesin) {
        con = dbCon.makeConnection();

        String sql = "UPDATE mesin SET statusMesin = " + mesin.getStatusMesin()
                + ", kapasitas = " + mesin.getKapasitas()
                + ", durasi = '" + mesin.getDurasi() + "'"
                + " WHERE idMesin = " + mesin.getIdMesin();

        System.out.println("Updating Mesin...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Updated " + result + " Mesin");
            statement.close();
        } catch (Exception e) {
            System.out.println("[!] Error Updating Mesin...");
            System.out.println(e);
        }
    }
    
    public void deleteMesin(int idMesin) {
        con = dbCon.makeConnection();

        String sql = "DELETE FROM mesin WHERE idMesin = " + idMesin;
        System.out.println("Deleting Mesin...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + " Mesin");
            statement.close();
        } catch (Exception e) {
            System.out.println("[!] Error Deleting Mesin...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
}

