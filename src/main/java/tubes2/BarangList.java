package tubes2;

import java.util.ArrayList;
import java.util.List;

public class BarangList {
    private List<Barang> barangList;
    public BarangList(){
        this.barangList=new ArrayList<>();
    }

    public List<Barang> getBarangList() {
        return barangList;
    }

    public void setBarangList(List<Barang> barangList) {
        this.barangList = barangList;
    }

    public void addBarang(Barang barang){
        this.barangList.add(barang);
    }
}
