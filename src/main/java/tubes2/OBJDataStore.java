package tubes2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class OBJDataStore implements IDataStore{
    @Override
    public Customer getCustomer(String filePath,int id) {
        CustomerList customerList=this.readCustomer(filePath);
        return customerList.getCustomerByID(id);
    }
    @Override
    public CustomerList readCustomer(String filePath) {
        try(ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(filePath+"/customer.obj"))){
            CustomerList customerList=(CustomerList) objectInputStream.readObject();
            return customerList;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addCustomer(String filePath,Customer customer) {
        CustomerList cl=this.readCustomer(filePath);
        cl.addCustomer(customer);
        this.writeCustomer(filePath,cl);
    }

    @Override
    public void writeCustomer(String filePath,CustomerList customerList) {
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(filePath+"/customer.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(customerList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public BarangList readBarang(String filePath) {
        try(ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(filePath+"/barang.obj"))){
            BarangList barangList=(BarangList) objectInputStream.readObject();
            return barangList;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeBarang(String filePath,BarangList barangList) {
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(filePath+"/barang.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(barangList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Barang getBarang(String filePath,int idBarang) {
        BarangList barangList=this.readBarang(filePath);
        return barangList.getBarang(idBarang);
    }

    @Override
    public void updateCustomer(String filePath,Customer customer) {
        CustomerList customerList=this.readCustomer(filePath);
        customerList.updateCustomer(customer);
        this.writeCustomer(filePath,customerList);
    }

    @Override
    public void addBarang(String filePath,Barang barang) {
        BarangList barangList=this.readBarang(filePath);
        barangList.addBarang(barang);
        this.writeBarang(filePath,barangList);
    }

    @Override
    public void updateBarang(String filePath,Barang barang) {
        BarangList barangList=this.readBarang(filePath);
        barangList.updateBarang(barang);
        this.writeBarang(filePath,barangList);
    }

    @Override
    public Fee readFee(String filePath) {
        try(ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(filePath+"/fee.obj"))){
            Fee fee=(Fee) objectInputStream.readObject();
            return fee;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateFee(String filePath, Fee fee) {
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(filePath+"/fee.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(fee);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
