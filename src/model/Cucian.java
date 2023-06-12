package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Cucian {
    private int id;
    private boolean status;
    private float berat;
    private String tglMasuk;
    private String tglKeluar;
    private Mesin m;
    private Pelanggan p;

    public Cucian(int id, boolean status, float berat, String tglMasuk, String tglKeluar, Mesin m, Pelanggan p) {
        this.id = id;
        this.status = status;
        this.berat = berat;
        this.tglMasuk = tglMasuk;
        this.tglKeluar = tglKeluar;
        this.m = m;
        this.p = p;
    }
    
    public Cucian(float berat, String tglMasuk, String tglKeluar) {
        this.berat = berat;
        this.tglMasuk = tglMasuk;
        this.tglKeluar = tglKeluar;
    }

    public int getId() {
        return id;
    }

    public boolean isStatus() {
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

    public Mesin getM() {
        return m;
    }

    public Pelanggan getP() {
        return p;
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

    public void setM(Mesin m) {
        this.m = m;
    }

    public void setP(Pelanggan p) {
        this.p = p;
    }

}
