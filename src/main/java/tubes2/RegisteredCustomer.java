package tubes2;
public class RegisteredCustomer extends Customer {
    private static int registeredCustomerCount = 0;
    private boolean vip; // jika vip == true, maka termasuk vip dan jika vip == false maka termasuk member
    private String nama;
    private String nomorTelepon;
    private int poin;
    private boolean aktif;

    public RegisteredCustomer(String nama, String nomorTelepon, Object transaksiTerakhir) {
        super(++registeredCustomerCount);
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.poin = 0;
        this.aktif = true;
        this.addHistoriTransaksi(transaksiTerakhir);
    }

    public String getNama() {
        return nama;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public int getPoin() {
        return poin;
    }

    public boolean isAktif() {
        return aktif;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public void aktivasiAkun() {
        this.aktif = true;
    }

    public void deaktivasiAkun() {
        this.aktif = false;
    }

    public boolean isVIP() {
        return vip;
    }

    public void setVIP() {
        this.vip = true;
    }

    public void setMember() {
        this.vip = false;
    }

    @Override
    public void pesan(Object historiTransaksi, int hargaTotal) {
        addHistoriTransaksi(historiTransaksi);
        this.poin = hargaTotal;
    }
}
