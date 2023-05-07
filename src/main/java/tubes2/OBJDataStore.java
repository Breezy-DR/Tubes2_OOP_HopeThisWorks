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
        CustomerList customerList=this.readCustomer();
        return customerList.getCustomerByID(id);
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
        CustomerList cl=this.readCustomer();
        cl.addCustomer(customer);
        this.writeCustomer(cl);
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
        try(ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(this.getFilePath()+"/barang.obj"))){
            BarangList barangList=(BarangList) objectInputStream.readObject();
            return barangList;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeBarang(BarangList barangList) {
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(this.filePath+"/barang.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(barangList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Barang getBarang(int idBarang) {
        BarangList barangList=this.readBarang();
        return barangList.getBarang(idBarang);
    }

    @Override
    public void updateCustomer(Customer customer) {
        CustomerList customerList=this.readCustomer();
        customerList.updateCustomer(customer);
        this.writeCustomer(customerList);
    }

    @Override
    public void addBarang(Barang barang) {
        BarangList barangList=this.readBarang();
        barangList.addBarang(barang);
        this.writeBarang(barangList);
    }

    @Override
    public void updateBarang(Barang barang) {
        BarangList barangList=this.readBarang();
        barangList.updateBarang(barang);
        this.writeBarang(barangList);
    }
}
