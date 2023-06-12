package model;

/**
 *
 * @author Vemas
 */
public class Pelanggan {
    private int idPelanggan;
    private String nama;
    private String noTelp;
    private String alamat;

    public Pelanggan(int idPelanggan, String nama, String noTelp, String alamat) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.noTelp = noTelp;
        this.alamat = alamat;
    }

    public Pelanggan(String nama, String noTelp, String alamat) {
        this.nama = nama;
        this.noTelp = noTelp;
        this.alamat = alamat;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setId(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String showDataPelanggan(){
        return
                this.idPelanggan + " | "
                + this.nama + " | "
                + this.noTelp + " | "
                + this.alamat;
    }
    
    @Override
    public String toString(){
        return nama;
    }
}
