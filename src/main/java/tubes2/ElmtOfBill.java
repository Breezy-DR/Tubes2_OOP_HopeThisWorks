package tubes2;
public class ElmtOfBill {
    private String barang;
    private int jumlahBarang;
    ElmtOfBill(String barang, int jumlahBarang) {
        this.barang = barang;
        this.jumlahBarang = jumlahBarang;
    }
    public void setNama(String nama) {
        this.barang = nama;
    }
    public void setJumlahBarang(int n) {
        this.jumlahBarang = n;
    }
    public String getNama() {
        return this.barang;
    }
    public int getJumlah() {
        return this.jumlahBarang;
    }
}
