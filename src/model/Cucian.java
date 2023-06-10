package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author yamacat
 */
public class Cucian {
    private int id;
    private boolean status;
    private float berat;
    private String tglMasuk;
    private String tglKeluar;
    private MesinCuci mc;
    private Dryer dr;
    
    public Cucian(int id, boolean status, float berat, String tglMasuk, String tglKeluar, int idMesin, boolean statusMesin, float kapasitas, Date durasi) {
        mc = new MesinCuci(idMesin, statusMesin, kapasitas, durasi);
        dr = new Dryer(idMesin, statusMesin, kapasitas, durasi);
        this.id = id;
        this.status = status;
        this.berat = berat;
        this.tglMasuk = tglMasuk;
        this.tglKeluar = tglKeluar;
    }
    
    public Cucian(int id, boolean status, float berat, String tglMasuk, String tglKeluar, int idMesin, boolean statusMesin, float kapasitas, Date durasi, boolean statusMesinCuci, boolean statusDryer, float kapasitasMesinCuci, float kapasitasDryer) {
        mc = new MesinCuci(idMesin, statusMesin, kapasitas, durasi, statusMesinCuci, kapasitasMesinCuci);
        dr = new Dryer(idMesin, statusMesin, kapasitas, durasi, statusDryer, kapasitasDryer);
        this.id = id;
        this.status = status;
        this.berat = berat;
        this.tglMasuk = tglMasuk;
        this.tglKeluar = tglKeluar;
    }

    public int getId() {
        return id;
    }

    public boolean getStatus() {
        return status;
    }

    public float getBerat() {
        return berat;
    }

    public String getTglMasuk() {
        return tglMasuk;
    }

    public String getTglKeluar() {
        return tglKeluar;
    }

    public MesinCuci getMesinCuci() {
        return mc;
    }

    public Dryer getDryer() {
        return dr;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setBerat(float berat) {
        this.berat = berat;
    }

    public void setTglMasuk(String tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    public void setTglKeluar(String tglKeluar) {
        this.tglKeluar = tglKeluar;
    }
}
