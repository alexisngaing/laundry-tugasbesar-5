package model;

import java.util.Date;
import java.util.ArrayList;

public abstract class Mesin {
    protected int id;
    protected boolean status;
    protected float kapasitas;
    protected Date durasi;
    protected ArrayList<MesinCuci> mesincuci;
    protected ArrayList<Dryer> dryer;

    public Mesin(int id, boolean status, float kapasitas, Date durasi) {
        this.id = id;
        this.status = status;
        this.kapasitas = kapasitas;
        this.durasi = durasi;
    }

    public Mesin(boolean status, float kapasitas, Date durasi) {
        this.status = status;
        this.kapasitas = kapasitas;
        this.durasi = durasi;
    }

    public int getId() {
        return id;
    }

    public boolean getStatus() {
        return status;
    }

    public float getKapasitas() {
        return kapasitas;
    }

    public Date getDurasi() {
        return durasi;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setKapasitas(float kapasitas) {
        this.kapasitas = kapasitas;
    }

    public void setDurasi(Date durasi) {
        this.durasi = durasi;
    }

    public abstract boolean cekStatusMesin();
}
