package tubes2;

import java.util.ArrayList;
import java.util.List;


public class FixedBill {
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
