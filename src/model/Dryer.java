package model;

import java.util.Date;

public class Dryer extends Mesin {
//    private int idDryer;
    private boolean statusDryer;
    private float kapasitasDryer;

    public Dryer(int id, boolean status, float kapasitas, Date durasi, /*int idDryer,*/ boolean statusDryer, float kapasitasDryer) {
        super(id, status, kapasitas, durasi);
//        this.idDryer = idDryer;
        this.statusDryer = statusDryer;
        this.kapasitasDryer = kapasitasDryer;
    }
    
    public Dryer(int idMesin, boolean status, float kapasitas, Date durasi) {
        super(idMesin, status, kapasitas, durasi);
    }

//    public int getIdDryer() {
//        return idDryer;
//    }

    public boolean getStatusDryer() {
        return statusDryer;
    }

    public float getKapasitasDryer() {
        return kapasitasDryer;
    }

//    public void setIdDryer(int idDryer) {
//        this.idDryer = idDryer;
//    }

    public void setStatusDryer(boolean statusDryer) {
        this.statusDryer = statusDryer;
    }

    public void setKapasitasDryer(float kapasitasDryer) {
        this.kapasitasDryer = kapasitasDryer;
    }

    @Override
    public boolean cekStatusMesin() {
        if (this.statusDryer == true) {
            return true;
        } else {
            return false;
        }
    }
}
