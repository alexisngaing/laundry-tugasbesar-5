package model;

import java.util.Date;

public class MesinCuci extends Mesin {
//    private int idMesinCuci;
    private boolean statusMesinCuci;
    private float kapasitasMesinCuci;

    public MesinCuci(int idMesin, boolean status, float kapasitas, String durasi, /* int idMesin,*/ boolean statusMesinCuci, float kapasitasMesinCuci) {
        super(idMesin, status, kapasitas, durasi);
//        this.idMesin = idMesinCuci;
        this.statusMesinCuci = statusMesinCuci;
        this.kapasitasMesinCuci = kapasitasMesinCuci;
    }
    
    public MesinCuci(int idMesin, boolean status, float kapasitas, String durasi) {
        super(idMesin, status, kapasitas, durasi);
    }

//    public int getIdMesinCuci() {
//        return idMesin;
//    }

    public boolean getStatusMesinCuci() {
        return statusMesinCuci;
    }

    public float getKapasitasMesinCuci() {
        return kapasitasMesinCuci;
    }

//    public void setIdMesinCuci(int idMesinCuci) {
//        this.idMesin = idMesin;
//    }

    public void setStatusMesinCuci(boolean statusMesinCuci) {
        this.statusMesinCuci = statusMesinCuci;
    }

    public void setKapasitasMesinCuci(float kapasitasMesinCuci) {
        this.kapasitasMesinCuci = kapasitasMesinCuci;
    }

//    @Override
//    public boolean cekStatusMesin() {
//        if (this.statusMesinCuci == true) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}
