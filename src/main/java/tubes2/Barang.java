package tubes2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Barang {
    private int idBarang;
    private int stok;
    private String namaBarang;
    private int hargaJualBarang;
    private int hargaBeliBarang;
    private String kategori;
    private String gambar;
    public Barang(int idBarang, int stok, String namaBarang, int hargaJualBarang, int hargaBeliBarang, String kategori, String gambar) {
        this.idBarang = idBarang;
        this.stok = stok;
        this.namaBarang = namaBarang;
        this.hargaBeliBarang = hargaBeliBarang;
        this.hargaJualBarang = hargaJualBarang;
        this.kategori = kategori;
        this.gambar = gambar;
    }
    // Getters
    public int getIDBarang() {
        return this.idBarang;
    }
    public int getStok() {
        return this.stok;
    }
    public String getNamaBarang() {
        return this.namaBarang;
    }
    public int getHargaJual() {
        return this.hargaJualBarang;
    }
    public int getHargaBeli() {
        return this.hargaBeliBarang;
    }
    public String getKategori() {
        return this.kategori;
    }
    public String getGambar() {
        return this.gambar;
    }
    // Modify
    public void addStok(int n) {
        // Menambah stok barang sebanyak n
        this.stok += n;
    }
    public void reduceStok(int n) {
        // Mengurangi stok barang sebanyak n
        this.stok -= n;
    }
    public void setKategori(String newKat) {
        this.kategori = newKat;
    }
}
