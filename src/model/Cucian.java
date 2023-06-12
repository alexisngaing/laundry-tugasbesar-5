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
    private Mesin mesin;
    private Pelanggan pelanggan;

    public Cucian(int id, boolean status, float berat, String tglMasuk, String tglKeluar, Mesin mesin, Pelanggan pelanggan) {
        this.id = id;
        this.status = status;
        this.berat = berat;
        this.tglMasuk = tglMasuk;
        this.tglKeluar = tglKeluar;
        this.mesin = mesin;
        this.pelanggan = pelanggan;
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

    public Mesin getMesin() {
        return mesin;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
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

    public void setMesin(Mesin mesin) {
        this.mesin = mesin;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }



}
