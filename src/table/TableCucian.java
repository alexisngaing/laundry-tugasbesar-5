package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cucian;
/**
 *
 * @author yamacat
 */
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
        return 8;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
//            case 0 :
//                return list.get(rowIndex).;
//            case 1 :
//                return list.get(rowIndex).;
//
            default :
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
//            case 0 :
//                return "Nama Tenaga Medis";
//            case 1 :
//                return "Jenis Tenaga Medis";
//            case 2 :
//                return "Nama Pasien";
//            case 3 :
//                return "Diagnosis";
//            case 4 :
//                return "Total Biaya";
//            case 5 :
//                return "Tindakan";
//            case 6 :
//                return "NPAIDI";
//            case 7 :
//                return "PPNI";
            default :
                return null;
        } 
    }
}
