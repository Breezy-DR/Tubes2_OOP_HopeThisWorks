package tubes2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
        CustomerList customerList=dataStore.readCustomer(filePath);
        return customerList.getCustomerByID(id);
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
        BarangList barangList=dataStore.readBarang(filePath);
        return barangList.getBarang(idBarang);
    }
    public static void updateCustomer(Customer customer){
        CustomerList customerList=dataStore.readCustomer(filePath);
        customerList.updateCustomer(customer);
        dataStore.writeCustomer(filePath,customerList);
    }
    public static void addCustomer(Customer customer){
        CustomerList customerList=dataStore.readCustomer(filePath);
        customerList.addCustomer(customer);
        dataStore.writeCustomer(filePath,customerList);
    }
    public static void addBarang(Barang barang){
        BarangList barangList=dataStore.readBarang(filePath);
        barangList.addBarang(barang);
        dataStore.writeBarang(filePath,barangList);
    }
    public static void updateBarang(Barang barang){
        BarangList barangList=dataStore.readBarang(filePath);
        barangList.updateBarang(barang);
        dataStore.writeBarang(filePath,barangList);
    }
    public static void deleteBarang(int idBarang) {
        BarangList barangList=dataStore.readBarang(filePath);
        barangList.deleteBarang(idBarang);
        dataStore.writeBarang(filePath,barangList);
    }
    public static Fee readFee(){
        return dataStore.readFee(filePath);
    }
    public static void updateFee(Fee fee){
        dataStore.updateFee(filePath,fee);
    }
    public static KursList readKurs(){
        return dataStore.readKurs(filePath);
    }
    public static void writeKurs(KursList kursList){
        dataStore.writeKurs(filePath,kursList);
    }
    public static void updateKurs(Kurs kurs){
        KursList kursList=dataStore.readKurs(filePath);
        kursList.updateKurs(kurs);
        dataStore.writeKurs(filePath,kursList);
    }
    public static void addKurs(Kurs kurs){
        KursList kursList=dataStore.readKurs(filePath);
        kursList.addKurs(kurs);
        dataStore.writeKurs(filePath,kursList);
    }
    public static Kurs getKursByName(String namaMataUang){
        KursList kursList=dataStore.readKurs(filePath);
        return kursList.getKursByName(namaMataUang);
    }
    public static void saveJarPath(String jarPath){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(System.getProperty("user.dir")+"/path.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(jarPath);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String getJarPath(){
        try(ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(System.getProperty("user.dir")+"/path.obj"))){
            String jarPath=(String) objectInputStream.readObject();
            return jarPath;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
