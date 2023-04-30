public class RegularCustomer extends Customer {
    private static int regularCustomerCount = 0;
    public RegularCustomer(Object historiTransaksi) {
        super(++regularCustomerCount);
        this.addHistoriTransaksi(historiTransaksi);
    }

    public Member daftarMember(String nama, String nomorTelepon) {
        return new Member(nama, nomorTelepon, getHistoriTransaksi().get(0));
    }

    public VIP daftarVIP (String nama, String nomorTelepon) {
        return new VIP(nama, nomorTelepon, getHistoriTransaksi().get(0));
    }

    @Override
    public void pesan() {

    }
}
