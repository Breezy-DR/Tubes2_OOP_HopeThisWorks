package tubes2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Fee implements Serializable {
    private float discount=0;
    private float tax=0;
    private float serviceFee=0;
    public Fee(){

    }
    public Fee(float discount,float tax,float serviceFee){
        this.discount=discount;
        this.tax=tax;
        this.serviceFee=serviceFee;
    }
    @XmlElement
    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
    @XmlElement
    public float getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(float serviceFee) {
        this.serviceFee = serviceFee;
    }
    @XmlElement
    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }
}
