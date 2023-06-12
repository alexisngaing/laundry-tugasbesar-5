package control;

import model.Cucian;
import dao.CucianDAO;
import java.util.List;
import table.TableCucian;

public class CucianControl {
    private CucianDAO cucianDAO = new CucianDAO();

    public void insertDataCucian(Cucian cucian) {
        cucianDAO.insertCucian(cucian);
    }

    public TableCucian showCucian(String query) {
        List<Cucian> dataCucian = cucianDAO.showCucian(query);
        TableCucian tableCucian = new TableCucian(dataCucian);
//        String cucianString = "";
//        for (int i = 0; i < dataCucian.size(); i++) {
//            cucianString = cucianString + dataCucian.get(i).toString() + "\n";
//        }
        return tableCucian;
    }

    public Cucian searchCucian(int idCucian) {
        Cucian cucian = cucianDAO.searchCucian(idCucian);
        return cucian;
    }

    public void updateCucian(Cucian cucian) {
        cucianDAO.updateCucian(cucian);
    }

    public void deleteCucian(int idCucian) {
        cucianDAO.deleteCucian(idCucian);
    }
}


