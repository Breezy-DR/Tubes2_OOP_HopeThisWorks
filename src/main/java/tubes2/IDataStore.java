package tubes2;

public interface IDataStore {
    public String getFilePath();
    public void setFilePath(String path);
    public Customer getCustomer(int id);
    public CustomerList readCustomer();
    public void writeCustomer(CustomerList customerList);
    public BarangList readBarang();
    public void writeBarang(BarangList barangList);
    public Barang getBarang(int idBarang);
    public void updateCustomer(Customer customer);
    public void addBarang(Barang barang);
    public void updateBarang(Barang barang);
}
