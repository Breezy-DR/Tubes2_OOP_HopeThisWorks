package tubes2;

public interface IDataStore {
    public String getFilePath();
    public void setFilePath(String path);
    public Customer getCustomer(String uid);
    public Barang getBarang(String idBarang);
    public void addCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void addBarang(Barang barang);
    public void updateBarang(Barang barang);
}
