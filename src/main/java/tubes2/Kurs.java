package tubes2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
public class Kurs implements Serializable {
    private String namaMataUang="idr";
    private float kursToIDR=1f;
    public Kurs(){}
    public Kurs(String namaMataUang,float kursToIDR){
        this.namaMataUang=namaMataUang;
        this.kursToIDR=kursToIDR;
    }

    public float getKursToIDR() {
        return kursToIDR;
    }

    public String getNamaMataUang() {
        return namaMataUang;
    }

    public void setKursToIDR(float kursToIDR) {
        this.kursToIDR = kursToIDR;
    }

    public void setNamaMataUang(String namaMataUang) {
        this.namaMataUang = namaMataUang;
    }
}
