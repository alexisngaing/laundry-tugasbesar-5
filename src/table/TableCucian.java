package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cucian;

public class TableCucian extends AbstractTableModel {
    private List<Cucian> list;

    public TableCucian(List<Cucian> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }
    
    @Override
    public int getColumnCount() {
        return 6;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 :
                return list.get(rowIndex).getId();
            case 1 :
                return list.get(rowIndex).getBerat();
            case 2 :
                return list.get(rowIndex).getTglMasuk();
            case 3 :
                return list.get(rowIndex).getTglKeluar();
            case 4 :
                return list.get(rowIndex).getMesin().getIdMesin();
            case 5 :
                return list.get(rowIndex).getPelanggan().getNama();
            default :
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 :
                return "ID Cucian";
            case 1 :
                return "Berat";
            case 2 :
                return "Tanggal Masuk";
            case 3 :
                return "Estimasi Keluar";
            case 4 :
                return "Mesin Cuci";
            case 5 :
                return "Nama";
            default :
                return null;
        } 
    }
}
