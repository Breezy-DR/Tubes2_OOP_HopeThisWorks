package tubes2;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Fee implements Serializable {
    float discount=0;
    float tax=0;
    float serviceFee=0;
    public Fee(float discount,float tax,float serviceFee){
        this.discount=discount;
        this.tax=tax;
        this.serviceFee=serviceFee;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(float serviceFee) {
        this.serviceFee = serviceFee;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }
}
