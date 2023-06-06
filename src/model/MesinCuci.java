package model;

import java.util.Date;

public class MesinCuci extends Mesin {
    private int idMesin;
    private boolean statusMesinCuci;
    private float kapasitasMesinCuci;

    public MesinCuci(int id, boolean status, float kapasitas, Date durasi, int idMesin, boolean statusMesinCuci, float kapasitasMesinCuci) {
        super(id, status, kapasitas, durasi);
        this.idMesin = idMesin;
        this.statusMesinCuci = statusMesinCuci;
        this.kapasitasMesinCuci = kapasitasMesinCuci;
    }

    public int getIdMesin() {
        return idMesin;
    }

    public boolean getStatusMesinCuci() {
        return statusMesinCuci;
    }

    public float getKapasitasMesinCuci() {
        return kapasitasMesinCuci;
    }

    public void setIdMesin(int idMesin) {
        this.idMesin = idMesin;
    }

    public void setStatusMesinCuci(boolean statusMesinCuci) {
        this.statusMesinCuci = statusMesinCuci;
    }

    public void setKapasitasMesinCuci(float kapasitasMesinCuci) {
        this.kapasitasMesinCuci = kapasitasMesinCuci;
    }

    @Override
    public boolean cekStatusMesin() {
        if (this.statusMesinCuci == true) {
            return true;
        } else {
            return false;
        }
    }
}
