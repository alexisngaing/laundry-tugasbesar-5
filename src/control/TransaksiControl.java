package control;

import model.Transaksi;
import dao.TransaksiDAO;
import java.util.List;
import table.TableTransaksi;

public class TransaksiControl {
    private TransaksiDAO transaksiDAO = new TransaksiDAO();

    public void insertDataTransaksi(Transaksi transaksi) {
        transaksiDAO.insertTransaksi(transaksi);
    }

//    public String showTransaksi() {
//        List<Transaksi> dataTransaksi = transaksiDAO.showTransaksi();
//        String transaksiString = "";
//        for (int i = 0; i < dataTransaksi.size(); i++) {
//            transaksiString = transaksiString + dataTransaksi.get(i).toString() + "\n";
//        }
//        return transaksiString;
//    }
    
    public TableTransaksi showDataTransaksi(String query) {
        List<Transaksi> dataTransaksi = transaksiDAO.showTransaksi(query);
        TableTransaksi tableTransaksi = new TableTransaksi(dataTransaksi);
        
        return tableTransaksi;
    }

    public Transaksi searchTransaksi(int idTransaksi) {
        Transaksi transaksi = transaksiDAO.searchTransaksi(idTransaksi);
        return transaksi;
    }

    public void updateTransaksi(Transaksi transaksi) {
        transaksiDAO.updateTransaksi(transaksi);
    }

    public void deleteTransaksi(int idTransaksi) {
        transaksiDAO.deleteTransaksi(idTransaksi);
    }
}
