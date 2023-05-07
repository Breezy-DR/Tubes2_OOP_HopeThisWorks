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

    private int hargaTotal;
    ElmtOfBill(String barang, int jumlahBarang) {
        this.barang = barang;
        this.jumlahBarang = jumlahBarang;
        //TODO: initialize this.hargaTotal
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
}
