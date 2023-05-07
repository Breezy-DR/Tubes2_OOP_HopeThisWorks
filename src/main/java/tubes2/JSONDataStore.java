package tubes2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class JSONDataStore implements IDataStore{
    @Override
    public CustomerList readCustomer(String filePath) {
        try (FileReader reader=new FileReader(filePath+"/customer.json")){
            Gson gson=new GsonBuilder()
                    .registerTypeAdapter(Customer.class,new CustomerDeserializer())
                    .create();
            CustomerList cl=gson.fromJson(reader,new TypeToken<CustomerList>(){}.getType());
            return cl;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeCustomer(String filePath,CustomerList customerList) {
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter fileWriter=new FileWriter(filePath+"/customer.json")){
            gson.toJson(customerList,fileWriter);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomer(String filePath,int id) {
        CustomerList customerList=readCustomer(filePath);
        return customerList.getCustomerByID(id);
    }

    public void addCustomer(String filePath,Customer customer){
        CustomerList customerList=readCustomer(filePath);
        customerList.addCustomer(customer);
        writeCustomer(filePath,customerList);
    }

    @Override
    public void updateCustomer(String filePath,Customer customer) {
        CustomerList customerList=readCustomer(filePath);
        customerList.updateCustomer(customer);
        writeCustomer(filePath,customerList);
    }

    @Override
    public BarangList readBarang(String filePath) {
        try(FileReader fileReader=new FileReader(filePath+"/barang.json")){
            Gson gson=new GsonBuilder()
                    .registerTypeAdapter(Barang.class,new BarangDeserializer())
                    .create();
            BarangList bl=gson.fromJson(fileReader,new TypeToken<BarangList>(){}.getType());
            return bl;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeBarang(String filePath,BarangList barangList) {
        try(FileWriter fileWriter=new FileWriter(filePath+"/barang.json")) {
            Gson gson=new GsonBuilder().setPrettyPrinting().create();
//            System.out.println(gson.toJson(barangList));
            gson.toJson(barangList,fileWriter);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Barang getBarang(String filePath,int idBarang) {
        BarangList barangList=readBarang(filePath);
        return barangList.getBarang(idBarang);
    }

    @Override
    public void addBarang(String filePath,Barang barang) {
        BarangList barangList=readBarang(filePath);
        barangList.addBarang(barang);
        writeBarang(filePath,barangList);
    }

    @Override
    public void updateBarang(String filePath,Barang barang) {
        BarangList barangList=readBarang(filePath);
        barangList.updateBarang(barang);
        writeBarang(filePath,barangList);
    }
}
