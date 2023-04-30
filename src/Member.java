public class Member extends Customer {
    private static int memberCount = 0;
    private String nama;
    private String nomorTelepon;
    private int poin;
    private boolean aktif;

    public Member(String nama, String nomorTelepon, Object transaksiTerakhir) {
        super(++memberCount);
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
