package model;

/**
 *
 * @author Vemas
 */
public class Pelanggan {
    private int id;
    private String nama;
    private String noTelp;
    private String alamat;

    public Pelanggan(int id, String nama, String noTelp, String alamat) {
        this.id = id;
        this.nama = nama;
        this.noTelp = noTelp;
        this.alamat = alamat;
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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
                this.id + " | "
                + this.nama + " | "
                + this.noTelp + " | "
                + this.alamat;
    }
}
