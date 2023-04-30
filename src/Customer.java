import java.util.ArrayList;
import java.util.List;

public abstract class Customer {
    private int id;
    private List<Object> historiTransaksi;
    public Customer(int id) {
        this.id = id;
        this.historiTransaksi = new ArrayList<>();
    }

    public void addHistoriTransaksi(Object historiTransaksi) {
        this.historiTransaksi.add(historiTransaksi);
    }

    public int getId() {
        return this.id;
    }

    public List<Object> getHistoriTransaksi() {
        return this.historiTransaksi;
    }

    public abstract void pesan();
}
