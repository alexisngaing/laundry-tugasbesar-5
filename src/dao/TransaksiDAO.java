package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Transaksi;
import model.Pelanggan;
import model.Cucian;

public class TransaksiDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;

    public void insertTransaksi(Transaksi transaksi) {
        con = dbCon.makeConnection();

        String sql = "INSERT INTO transaksi(idTransaksi, totalBiaya, idPelanggan, idCucian) "
                + "VALUES (" + transaksi.getIdTransaksi() + ", " + transaksi.getTotalBiaya() + ", "
                + transaksi.getPelanggan().getIdPelanggan()+ ", " + transaksi.getCucian().getId() + ")";

        System.out.println("Adding Transaksi");

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

    public List<Transaksi> showTransaksi() {
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM transaksi";
        System.out.println("Fetching Transaksi data...");

        List<Transaksi> list = new ArrayList<>();

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    int idTransaksi = rs.getInt("idTransaksi");
                    float totalBiaya = rs.getFloat("totalBiaya");
                    int idPelanggan = rs.getInt("idPelanggan");
                    int idCucian = rs.getInt("idCucian");

                    PelangganDAO pelangganDAO = new PelangganDAO();
                    Pelanggan pelanggan = pelangganDAO.searchPelanggan(sql);

                    CucianDAO cucianDAO = new CucianDAO();
//                    Cucian cucian = cucianDAO.searchCucianById(idCucian);

//                    Transaksi transaksi = new Transaksi(idTransaksi, totalBiaya, pelanggan, cucian);
//                    list.add(transaksi);
                }
            }
        } catch (Exception e) {
            System.out.println("[!] Error Fetching Transaksi data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }

    public Transaksi searchTransaksi(int idTransaksi) {
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM transaksi WHERE idTransaksi = " + idTransaksi;
        System.out.println("Searching Transaksi...");

        Transaksi transaksi = null;

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null && rs.next()) {
                float totalBiaya = rs.getFloat("totalBiaya");
                int idPelanggan = rs.getInt("idPelanggan");
                int idCucian = rs.getInt("idCucian");

                PelangganDAO pelangganDAO = new PelangganDAO();
                Pelanggan pelanggan = pelangganDAO.searchPelanggan("nama");

                CucianDAO cucianDAO = new CucianDAO();
//                Cucian cucian = cucianDAO(idCucian);

//                transaksi = new Transaksi(idTransaksi, totalBiaya, pelanggan, cucian);
            }
        } catch (Exception e) {
            System.out.println("[!] Error Searching Transaksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();

        return transaksi;
    }

    public void updateTransaksi(Transaksi transaksi) {
        con = dbCon.makeConnection();

        String sql = "UPDATE transaksi SET totalBiaya = " + transaksi.getTotalBiaya()
                + ", idPelanggan = " + transaksi.getPelanggan().getIdPelanggan()
                + ", idCucian = " + transaksi.getCucian().getId()
                + " WHERE idTransaksi = " + transaksi.getIdTransaksi();

        System.out.println("Updating Transaksi...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Updated " + result + " Transaksi");
            statement.close();
        } catch (Exception e) {
            System.out.println("[!] Error Updating Transaksi...");
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
            System.out.println("Deleted " + result + " Transaksi");
            statement.close();
        } catch (Exception e) {
            System.out.println("[!] Error Deleting Transaksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
}
