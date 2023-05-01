import java.util.ArrayList;
import java.util.List;

public class Gudang {
    private List<Barang> listBarang;

    public Gudang() {
        this.listBarang = new ArrayList<>();
    }

    public void tambahBarang(Barang barang) {
        this.listBarang.add(barang);
    }

    public void hapusBarang(int idx) {
        this.listBarang.remove(idx);
    }

    public void clearGudang() {
        this.listBarang.clear();
    }
}
