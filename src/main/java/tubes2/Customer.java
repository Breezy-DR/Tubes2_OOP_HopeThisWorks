package tubes2;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({RegisteredCustomer.class,UnregisteredCustomer.class})
public abstract class Customer implements Serializable {
    @XmlElement
    private final int id;
//    @XmlElementWrapper(name = "historiTransaksi")
    @XmlElement(name = "historiTransaksi")
    private List<FixedBill> historiTransaksi;
    public Customer(int id) {
        this.id = id;
        this.historiTransaksi = new ArrayList<>();
    }
    public Customer(int id, List<FixedBill> historiTransaksi){
        this.id=id;
        this.historiTransaksi=historiTransaksi;
    }

    public int getId() {
        return this.id;
    }
    public void setHistoriTransaksi(List<FixedBill> historiTransaksi){
        this.historiTransaksi=historiTransaksi;
    }

    public void addHistoriTransaksi(FixedBill historiTransaksi) {
        this.historiTransaksi.add(historiTransaksi);
    }
    public List<FixedBill> getHistoriTransaksi() {
        return this.historiTransaksi;
    }

    public abstract void pesan(FixedBill historiTransaksi, int hargaTotal);
}
