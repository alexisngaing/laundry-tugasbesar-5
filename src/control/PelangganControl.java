/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Pelanggan;
import dao.PelangganDAO;
import java.util.List;

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
    
    public Pelanggan searchPelanggan(String nama){
        Pelanggan p = null;
        p = pDao.searchPelanggan(nama);
        return p;
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
