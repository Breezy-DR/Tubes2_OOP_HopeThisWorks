package tubes2;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
@XmlAccessorType(XmlAccessType.FIELD)
public class UnregisteredCustomer extends Customer {
    private static int unregisteredCustomerCount = 0;
    public UnregisteredCustomer() {
        super(++unregisteredCustomerCount);
    }
    public UnregisteredCustomer(int id, List<FixedBill> historiTransaksi){
        super(id,historiTransaksi);
    }

    public RegisteredCustomer daftarMember(String nama, String nomorTelepon) {
        return new RegisteredCustomer(nama, nomorTelepon, getHistoriTransaksi().get(0));
    }

    public RegisteredCustomer daftarVIP (String nama, String nomorTelepon) {
        RegisteredCustomer newVIP = new RegisteredCustomer(nama, nomorTelepon, getHistoriTransaksi().get(0));
        newVIP.setVIP();
        return (newVIP);
    }

    @Override
    public void pesan(FixedBill historiTransaksi, int hargaTotal) {
        this.addHistoriTransaksi(historiTransaksi);
    }
}
