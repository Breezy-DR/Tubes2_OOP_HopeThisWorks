import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<ElmtOfBill> listBelanja;

    public Bill() {
        this.listBelanja = new ArrayList<>();
    }

    public void tambahBarang(Barang barang, int jumlah) {
        this.listBelanja.add(new ElmtOfBill(barang.getNamaBarang(), jumlah));
    }

    public void hapusBarang(int idx) {
        this.listBelanja.remove(idx);
    }

    public void ubahBarang(Barang barang, int idx, int jumlah) {
        this.listBelanja.get(idx).setNama(barang.getNamaBarang());
        this.listBelanja.get(idx).setJumlahBarang(jumlah);
    }

}
