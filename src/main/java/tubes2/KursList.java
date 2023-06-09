package tubes2;

import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "kursListClass")
public class KursList implements Serializable {
    private List<Kurs> kursList;
    public KursList(){
        this.kursList=new ArrayList<>();
    }

    public List<Kurs> getKursList() {
        return kursList;
    }

    public void setKursList(List<Kurs> kursList) {
        this.kursList = kursList;
    }
    public void addKurs(Kurs kurs){
        this.kursList.add(kurs);
    }
    public void updateKurs(Kurs kurs){
        for (Kurs k: this.kursList){
            if (k.getNamaMataUang()==kurs.getNamaMataUang()){
                this.kursList.remove(k);
                this.kursList.add(kurs);
                break;
            }
        }
    }
    public Kurs getKursByName(String namaMataUang){
        return this.kursList.stream()
                .filter(kurs -> kurs.getNamaMataUang()==namaMataUang)
                .findFirst()
                .orElse(null);
    }
    public void insertDummy(){
        Kurs kurs=new Kurs("dummy",-1);
        this.kursList.add(0,kurs);
        this.kursList.add(0,kurs);
    }
    public void removeDummy(){
        List<Kurs> newKursList=new ArrayList<>();
        for (Kurs k :
                this.kursList) {
            if (!k.getNamaMataUang().equals("dummy")) {
                newKursList.add(k);
            }
        }
        this.kursList=newKursList;
    }
}
