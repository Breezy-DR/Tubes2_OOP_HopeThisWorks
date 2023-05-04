package tubes2;
import java.util.ArrayList;
import java.util.List;
public class Kasir {
    private List<Barang> listBarang;

    public Kasir() {
        this.listBarang = new ArrayList<>();
    }

    public void addKasir(Barang barang) {
        this.listBarang.add(barang);
    }

    public Bill tampilkanBarang() {
        Bill resultbill = new Bill();
        for (Barang e : this.listBarang) {
            resultbill.tambahBarang(e, e.getStok());
        }
        return resultbill;
    }

    public FixedBill tampilkanBarang(Bill tempBill) {
        FixedBill resultBill = new FixedBill();
        for (ElmtOfBill e: tempBill.getListBelanja()) {
            resultBill.getlistBelanja().add(e);
        }
        return resultBill;
    }

}
