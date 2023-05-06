package tubes2;

public interface IDataStore {
    public String getFilePath();
    public void setFilePath(String path);
    public CustomerList readCustomer();
    public Barang getBarang(String idBarang);
    public void writeCustomer(CustomerList customerList);
    public void updateCustomer(Customer customer);
    public void addBarang(Barang barang);
    public void updateBarang(Barang barang);
}
