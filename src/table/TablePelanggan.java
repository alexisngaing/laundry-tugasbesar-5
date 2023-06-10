package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Pelanggan;

/**
 *
 * @author yamacat
 */
public class TablePelanggan extends AbstractTableModel {
     private List<Pelanggan> list;

    public TablePelanggan(List<Pelanggan> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 :
                return list.get(rowIndex).getIdPelanggan();
            case 1 :
                return list.get(rowIndex).getNama();
            case 2 :
                return list.get(rowIndex).getNoTelp();
            case 3 :
                return list.get(rowIndex).getAlamat();
            default :
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 :
                return "ID Pelanggan";
            case 1 :
                return "Nama Pelanggan";
            case 2 :
                return "No. Telepon";
            case 3 :
                return "Alamat";
            default :
                return null;
        } 
    }
}
