package tubes2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class FixedBill implements Serializable {
    @XmlElement(name = "listBelanja")
    private List<ElmtOfBill> listBelanja;

    public FixedBill() {
        this.listBelanja = new ArrayList<>();
    }
    public FixedBill(Bill bill){
        this.listBelanja=new ArrayList<>();
        for (ElmtOfBill e :
                bill.getListBelanja()) {
            this.listBelanja.add(e);
        }
    }

    public List<ElmtOfBill> getlistBelanja() {
        return this.listBelanja;
    }
    public void addListBelanja(ElmtOfBill elmtOfBill){this.listBelanja.add(elmtOfBill);}
    public void clearListBelanja(){this.listBelanja.clear();}

    public int getTotalTransaksi() {
        int totalTransaksi = 0;
        for (int i = 0; i < this.listBelanja.size(); i++) {
            totalTransaksi += this.listBelanja.get(i).getHargaTotal();
        }
        return totalTransaksi;
    }
    public void applyDiscount(float discountRatio){
        for (ElmtOfBill e :
                this.listBelanja) {
            e.applyDiscount(discountRatio);
        }
    }
}
