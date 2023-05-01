package tubes2;
public class UnregisteredCustomer extends Customer {
    private static int unregisteredCustomerCount = 0;
    public UnregisteredCustomer() {
        super(++unregisteredCustomerCount);
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
    public void pesan(Object historiTransaksi, int hargaTotal) {
        this.addHistoriTransaksi(historiTransaksi);
    }
}
