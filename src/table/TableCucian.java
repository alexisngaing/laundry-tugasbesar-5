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
                return list.get(rowIndex).getStatus();
            case 2 :
                return list.get(rowIndex).getBerat();
            case 3 :
                return list.get(rowIndex).getTglMasuk();
            case 4 :
                return list.get(rowIndex).getMesinCuci().getIdMesin();
            case 5 :
                return list.get(rowIndex).getDryer().getIdMesin();
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
                return "Status";
            case 2 :
                return "Berat";
            case 3 :
                return "Tanggal Masuk";
            case 4 :
                return "Masin Cuci";
            case 5 :
                return "Mesin Dryer";
            default :
                return null;
        } 
    }
}
