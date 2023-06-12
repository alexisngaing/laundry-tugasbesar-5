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
        return 5;
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
                return list.get(rowIndex).getMesin().getIdMesin();
            case 4 :
                return list.get(rowIndex).getPelanggan().getIdPelanggan();
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
                return "Masin Cuci";
            case 4 :
                return "Pelanggan";
            default :
                return null;
        } 
    }
}
