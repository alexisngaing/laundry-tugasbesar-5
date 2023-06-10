package model;

import java.util.Date;
//import java.util.ArrayList;

public abstract class Mesin {
    protected int idMesin;
    protected boolean statusMesin;
    protected float kapasitas;
    protected Date durasi;
//    protected ArrayList<MesinCuci> mesincuci;
//    protected ArrayList<Dryer> dryer;

    public Mesin(int idMesin, boolean statusMesin, float kapasitas, Date durasi) {
        this.idMesin = idMesin;
        this.statusMesin = statusMesin;
        this.kapasitas = kapasitas;
        this.durasi = durasi;
    }

    public Mesin(boolean statusMesin, float kapasitas, Date durasi) {
        this.statusMesin = statusMesin;
        this.kapasitas = kapasitas;
        this.durasi = durasi;
    }

    public int getIdMesin() {
        return idMesin;
    }

    public boolean getStatusMesin() {
        return statusMesin;
    }

    public float getKapasitas() {
        return kapasitas;
    }

    public Date getDurasi() {
        return durasi;
    }

    public void setIdMesin(int idMesin) {
        this.idMesin = idMesin;
    }

    public void setStatusMesin(boolean statusMesin) {
        this.statusMesin = statusMesin;
    }

    public void setKapasitas(float kapasitas) {
        this.kapasitas = kapasitas;
    }

    public void setDurasi(Date durasi) {
        this.durasi = durasi;
    }

    public abstract boolean cekStatusMesin();
}
