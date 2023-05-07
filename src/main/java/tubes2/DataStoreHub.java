package tubes2;

public class DataStoreHub {
    private static String filePath="src/main/java/tubes2/data";
    private static IDataStore dataStore=new JSONDataStore();
    public static String getFilePath(){
        return filePath;
    }
    public static void setFilePath(String newFilePath){
        filePath=newFilePath;
    }
    public static void setDataStore(IDataStore newDataStore){
        dataStore=newDataStore;
    }
    public static CustomerList readCustomer(){
        return dataStore.readCustomer(filePath);
    }
    public static Customer getCustomer(int id){
        return dataStore.getCustomer(filePath,id);
    }
    public static void writeCustomer(CustomerList customerList){
        dataStore.writeCustomer(filePath,customerList);
    }
    public static BarangList readBarang(){
        return dataStore.readBarang(filePath);
    }
    public static void writeBarang(BarangList barangList){
        dataStore.writeBarang(filePath,barangList);
    }
    public static Barang getBarang(int idBarang){
        return dataStore.getBarang(filePath,idBarang);
    }
    public static void updateCustomer(Customer customer){
        dataStore.updateCustomer(filePath,customer);
    }
    public static void addBarang(Barang barang){
        dataStore.addBarang(filePath,barang);
    }
    public static void updateBarang(Barang barang){
        dataStore.updateBarang(filePath,barang);
    }

    public static Fee readFee(){
        return dataStore.readFee(filePath);
    }
    public static void updateFee(Fee fee){
        dataStore.updateFee(filePath,fee);
    }

    public static void addCustomer(Customer customer){
        dataStore.addCustomer(filePath,customer);
    }

    public static KursList readKurs(){
        return dataStore.readKurs(filePath);
    }
    public static void writeKurs(KursList kursList){
        dataStore.writeKurs(filePath,kursList);
    }
    public static void updateKurs(Kurs kurs){
        dataStore.updateKurs(filePath,kurs);
    }
    public static void addKurs(Kurs kurs){
        dataStore.addKurs(filePath,kurs);
    }
    public static Kurs getKursByName(String namaMataUang){
        return dataStore.getKursByName(filePath,namaMataUang);
    }
}
