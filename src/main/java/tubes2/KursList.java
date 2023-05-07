package tubes2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
}
