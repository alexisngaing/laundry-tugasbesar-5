package control;

import model.Pelanggan;
import dao.PelangganDAO;
import java.util.List;
import table.TablePelanggan;

public class PelangganControl {
    private PelangganDAO pDao = new PelangganDAO();
    
    public void insertDataPelanggan(Pelanggan p){
        pDao.insertPelanggan(p);
    }
    
    public String showDataPelanggan(){
        List<Pelanggan> dataPelanggan = pDao.showPelanggan();
        String pelangganString = "";
        for (int i = 0; i < dataPelanggan.size(); i++) {
            pelangganString = pelangganString + dataPelanggan.get(i).showDataPelanggan() + "\n";
        }
        return pelangganString;
    }
    
    public TablePelanggan showPelanggan(){
        List<Pelanggan> dataPelanggan = pDao.showPelanggan();
        TablePelanggan tablePelanggan = new TablePelanggan(dataPelanggan);
        
        return tablePelanggan;
    }
    
    public Pelanggan searchPelanggan(String nama){
        Pelanggan p = null;
        p = pDao.searchPelanggan(nama);
        return p;
    }
    
    public TablePelanggan searchDataPelanggan(String query) {
        List<Pelanggan> dataPelanggan = pDao.showPelangganBySearch(query);
        TablePelanggan tablePelanggan = new TablePelanggan(dataPelanggan);
        
        return tablePelanggan;
    }
    
    public void updatePelanggan(Pelanggan p, int id){
        pDao.updatePelanggan(p, id);
    }
    
    public void deletePelanggan(int id){
        pDao.deletePelanggan(id);
    }
    
    public List<Pelanggan> listPelanggan(){
        List<Pelanggan> dataPelanggan = pDao.showPelanggan();
        return dataPelanggan;
    }
}
