package tubes2;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
public class ElmtOfBill implements Serializable {
    @XmlElement
    private String barang;
    @XmlElement
    private int jumlahBarang;
    @XmlElement
    private int hargaTotal;
    public ElmtOfBill(String barang, int jumlahBarang) {
        this.barang = barang;
        this.jumlahBarang = jumlahBarang;
        //TODO: initialize this.hargaTotal
    }
    public ElmtOfBill(String barang, int jumlahBarang,int hargaTotal) {
        this.barang = barang;
        this.jumlahBarang = jumlahBarang;
        //TODO: initialize this.hargaTotal
        this.hargaTotal=hargaTotal;
    }
    public void setNama(String nama) {
        this.barang = nama;
    }
    public void setJumlahBarang(int n) {
        this.jumlahBarang = n;
    }
    public String getNama() {
        return this.barang;
    }
    public int getJumlah() {
        return this.jumlahBarang;
    }
    public int getHargaTotal() {
        return this.hargaTotal;
    }
    public void applyDiscount(float discountRatio){
        this.hargaTotal=(int) (this.hargaTotal*discountRatio);
    }
}
