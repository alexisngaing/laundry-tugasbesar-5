/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Transaksi;

public class TableTransaksi extends AbstractTableModel{
    private List<Transaksi> list;

    public TableTransaksi(List<Transaksi> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 5;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 :
                return list.get(rowIndex).getIdTransaksi();
            case 1 :
                return list.get(rowIndex).getPelanggan().getNama();
            case 2 :
                return list.get(rowIndex).getCucian().getTglMasuk();
            case 3 :
                return list.get(rowIndex).getCucian().getBerat();
            case 4 :
                return list.get(rowIndex).getTotalBiaya();
            default :
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 :
                return "ID Transaksi";
            case 1 :
                return "Nama Pelanggan";
            case 2 :
                return "Tanggal Masuk";
            case 3 :
                return "Berat";
            case 4 :
                return "Total Biaya";
            default :
                return null;
        } 
    }
}
