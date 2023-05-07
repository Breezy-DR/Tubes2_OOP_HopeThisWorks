package tubes2;

public interface IDataStore {
    public Customer getCustomer(String filePath,int id);
    public CustomerList readCustomer(String filePath);
    public void addCustomer(String filePath,Customer customer);
    public void writeCustomer(String filePath,CustomerList customerList);
    public BarangList readBarang(String filePath);
    public void writeBarang(String filePath,BarangList barangList);
    public Barang getBarang(String filePath,int idBarang);
    public void updateCustomer(String filePath,Customer customer);
    public void addBarang(String filePath,Barang barang);
    public void updateBarang(String filePath,Barang barang);
}
