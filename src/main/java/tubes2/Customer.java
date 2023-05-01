package tubes2;
import java.util.ArrayList;
import java.util.List;

public abstract class Customer {
    private final int id;
    private List<Object> historiTransaksi;
    public Customer(int id) {
        this.id = id;
        this.historiTransaksi = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public void addHistoriTransaksi(Object historiTransaksi) {
        this.historiTransaksi.add(historiTransaksi);
    }

    public List<Object> getHistoriTransaksi() {
        return this.historiTransaksi;
    }

    public abstract void pesan(Object historiTransaksi, int hargaTotal);
}
