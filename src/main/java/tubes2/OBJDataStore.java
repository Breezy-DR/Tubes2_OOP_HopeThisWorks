package tubes2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class OBJDataStore implements IDataStore{
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
        try(ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(this.getFilePath()+"/customer.obj"))){
            CustomerList customerList=(CustomerList) objectInputStream.readObject();
            return customerList;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public void writeCustomer(CustomerList customerList) {
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(this.filePath+"/customer.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(customerList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
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
