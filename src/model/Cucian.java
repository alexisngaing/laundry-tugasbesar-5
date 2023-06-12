package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Cucian {
    private int id;
    private boolean statusCuci;
    private boolean statusDry;
    private float berat;
    private String tglMasuk;
    private String tglKeluar;
    private Mesin mesin;
    private Pelanggan pelanggan;

    public Cucian(int id, boolean statusCuci, boolean statusDry, float berat, String tglMasuk, String tglKeluar, Mesin mesin, Pelanggan pelanggan) {
        this.id = id;
        this.statusCuci = statusCuci;
        this.statusDry = statusDry;
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

    public boolean isStatusCuci() {
        return statusCuci;
    }

    public boolean isStatusDry() {
        return statusDry;
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

    public void setStatusCuci(boolean statusCuci) {
        this.statusCuci = statusCuci;
    }

    public void setStatusDry(boolean statusDry) {
        this.statusDry = statusDry;
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
