public class VIP extends Customer {
    private static int vipCount = 0;
    private String nama;
    private String nomorTelepon;
    private int poin;
    private boolean aktif;

    public VIP(String nama, String nomorTelepon, Object transaksiTerakhir) {
        super(++vipCount);
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

    @Override
    public void pesan() {

    }
}
