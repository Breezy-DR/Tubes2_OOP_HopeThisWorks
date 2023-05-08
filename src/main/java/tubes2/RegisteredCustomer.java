package tubes2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class RegisteredCustomer extends Customer implements Serializable {
    private static int registeredCustomerCount = countRegistered();
    private boolean vip; // jika vip == true, maka termasuk vip dan jika vip == false maka termasuk member
    private String nama;
    private String nomorTelepon;
    private int poin;
    @XmlElement
    private boolean aktif;

    public static int countRegistered(){
        int count = 0;
        DataStoreHub datastore = new DataStoreHub();
        for(Customer customer: datastore.readCustomer().getCustomerList()){
            if(customer instanceof RegisteredCustomer){
                count++;
            }
        }

        return  count;
    }

    public RegisteredCustomer(String nama, String nomorTelepon, FixedBill transaksiTerakhir) {
        super(++registeredCustomerCount);
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.poin = 0;
        this.aktif = true;
        this.addHistoriTransaksi(transaksiTerakhir);
    }
    public RegisteredCustomer(int id, List<FixedBill> historiTransaksi, boolean vip, String nama, String nomorTelepon,int poin,boolean aktif){
        super(id,historiTransaksi);
        this.vip=vip;
        this.nama=nama;
        this.nomorTelepon=nomorTelepon;
        this.poin=poin;
        this.aktif=aktif;
    }
//    @XmlElement
    public String getNama() {
        return nama;
    }
//    @XmlElement
    public String getNomorTelepon() {
        return nomorTelepon;
    }
//    @XmlElement
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
//    @XmlElement
    public boolean isVIP() {
        return vip;
    }

    public void setVIP() {
        this.vip = true;
    }

    public void setMember() {
        this.vip = false;
    }
    public void setPoin(int poin){
        this.poin=poin;
    }

    @Override
    public void pesan(FixedBill historiTransaksi, int hargaTotal) {
        addHistoriTransaksi(historiTransaksi);
        this.poin = hargaTotal;
    }
}
