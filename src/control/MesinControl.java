package control;

import model.Mesin;
import dao.MesinDAO;
import java.util.List;

public class MesinControl {
    private MesinDAO mesinDAO = new MesinDAO();

    public void insertMesin(Mesin mesin) {
        mesinDAO.insertMesin(mesin);
    }

    public String showMesin() {
        List<Mesin> dataMesin = mesinDAO.showMesin();
        String mesinString = "";
        for (int i = 0; i < dataMesin.size(); i++) {
            mesinString = mesinString + dataMesin.get(i).toString() + "\n";
        }
        return mesinString;
    }
    
    public List<Mesin> listMesin() {
        List<Mesin> dataMesin = mesinDAO.showMesin();
        return dataMesin;
    }

    public Mesin searchMesin(int idMesin) {
        Mesin mesin = mesinDAO.searchMesin(idMesin);
        return mesin;
    }

    public void updateMesin(Mesin mesin) {
        mesinDAO.updateMesin(mesin);
    }

    public void deleteMesin(int idMesin) {
        mesinDAO.deleteMesin(idMesin);
    }
}

