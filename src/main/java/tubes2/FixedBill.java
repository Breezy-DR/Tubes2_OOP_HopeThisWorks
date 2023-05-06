package tubes2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class FixedBill {
    @XmlElement(name = "listBelanja")
    private List<ElmtOfBill> listBelanja;

    public FixedBill() {
        this.listBelanja = new ArrayList<>();
    }

    public List<ElmtOfBill> getlistBelanja() {
        return this.listBelanja;
    }
    public void addListBelanja(ElmtOfBill elmtOfBill){this.listBelanja.add(elmtOfBill);}
    public void clearListBelanja(){this.listBelanja.clear();}
}
