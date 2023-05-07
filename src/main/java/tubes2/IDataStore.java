package tubes2;

public interface IDataStore {
    public CustomerList readCustomer(String filePath);
    public void writeCustomer(String filePath,CustomerList customerList);
    public BarangList readBarang(String filePath);
    public void writeBarang(String filePath,BarangList barangList);
    public Fee readFee(String filePath);
    public void updateFee(String filePath,Fee fee);
    public KursList readKurs(String filePath);
    public void writeKurs(String filePath,KursList kursList);

}
