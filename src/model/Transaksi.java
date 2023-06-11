/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Transaksi {
    private int idTransaksi;
    private float totalBiaya;
    private Pelanggan pelanggan;
    private Cucian cucian;

    public Transaksi(int idTransaksi, float totalBiaya, Pelanggan pelanggan, Cucian cucian) {
        this.idTransaksi = idTransaksi;
        this.totalBiaya = totalBiaya;
        this.pelanggan = pelanggan;
        this.cucian = cucian;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public float getTotalBiaya() {
        return totalBiaya;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public Cucian getCucian() {
        return cucian;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public void setTotalBiaya(float totalBiaya) {
        this.totalBiaya = totalBiaya;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public void setCucian(Cucian cucian) {
        this.cucian = cucian;
    }
    
}
