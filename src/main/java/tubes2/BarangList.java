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

    public Barang getBarang(int idBarang){
        for (Barang b :
                this.barangList) {
            if (b.getIDBarang() == idBarang) {
                return b;
            }
        }
        return null;
    }

    public void addBarang(Barang barang){
        this.barangList.add(barang);
    }
    public void updateBarang(Barang barang){
        for (Barang b:this.barangList){
            if (b.getIDBarang()==barang.getIDBarang()){
                this.barangList.remove(b);
                this.barangList.add(barang);
                break;
            }
        }
    }
}
