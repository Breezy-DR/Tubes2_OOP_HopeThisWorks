package tubes2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class JSONDataStore implements IDataStore{
    private String filePath="src/main/java/tubes2/data";
    private File JsonFile;
    @Override
    public String getFilePath() {
        return this.filePath;
    }

    @Override
    public void setFilePath(String path) {
        this.filePath=path;
    }

    @Override
    public CustomerList readCustomer() {
        try (FileReader reader=new FileReader(this.getFilePath()+"/tes.json")){
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
    public void writeCustomer(CustomerList customerList) {
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter fileWriter=new FileWriter(this.getFilePath()+"/tes.json")){
            gson.toJson(customerList,fileWriter);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addCustomer(Customer customer){
        CustomerList customerList=readCustomer();
        customerList.addCustomer(customer);
        writeCustomer(customerList);
    }

    @Override
    public void updateCustomer(Customer customer) {
        CustomerList customerList=readCustomer();
        customerList.updateCustomer(customer);
        writeCustomer(customerList);
    }

    @Override
    public BarangList readBarang() {
        try(FileReader fileReader=new FileReader(this.getFilePath()+"/customer.json")){
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
    public void writeBarang(BarangList barangList) {
        try(FileWriter fileWriter=new FileWriter(this.getFilePath()+"/barang.json")) {
            Gson gson=new GsonBuilder().setPrettyPrinting().create();
//            System.out.println(gson.toJson(barangList));
            gson.toJson(barangList,fileWriter);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Barang getBarang(String idBarang) {
        return null;
    }

    @Override
    public void addBarang(Barang barang) {

    }

    @Override
    public void updateBarang(Barang barang) {

    }

}
