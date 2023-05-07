package tubes2;
import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<ElmtOfBill> listBelanja;

    public Bill() {
        this.listBelanja = new ArrayList<>();
    }

    public List<ElmtOfBill> getListBelanja() {
        return this.listBelanja;
    }

    public void tambahBarang(Barang barang, int jumlah) {
        this.listBelanja.add(new ElmtOfBill(barang.getNamaBarang(), jumlah));
    }
    public void tambahBarang(String namaBarang,int jumlah,int harga){
        this.listBelanja.add(new ElmtOfBill(namaBarang,jumlah,harga));
    }

    public void hapusBarang(int idx) {
        this.listBelanja.remove(idx);
    }

    public void ubahBarang(Barang barang, int idx, int jumlah) {
        this.listBelanja.get(idx).setNama(barang.getNamaBarang());
        this.listBelanja.get(idx).setJumlahBarang(jumlah);
    }

    public void clearBill(){
        this.listBelanja.clear();
    }

}
