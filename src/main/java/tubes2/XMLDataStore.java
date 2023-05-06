package tubes2;
import org.json.XML;

public class XMLDataStore implements IDataStore {
    private String filePath="src/main/java/tubes2/data";

    @Override
    public String getFilePath() {
        return this.filePath;
    }

    @Override
    public void setFilePath(String path) {
        this.filePath=path;
    }

    @Override
    public Customer getCustomer(int id) {


        return null;
    }

    @Override
    public CustomerList readCustomer() {
        return null;
    }

    @Override
    public void writeCustomer(CustomerList customerList) {

    }

    @Override
    public BarangList readBarang() {
        return null;
    }

    @Override
    public void writeBarang(BarangList barangList) {

    }

    @Override
    public Barang getBarang(int idBarang) {
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void addBarang(Barang barang) {

    }

    @Override
    public void updateBarang(Barang barang) {

    }
}
