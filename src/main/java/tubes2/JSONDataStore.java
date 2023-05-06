package tubes2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class JSONDataStore implements IDataStore{
    private String filePath="/data";
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
        try (FileReader reader=new FileReader("/home/suisei/Documents/GitHub/Tubes2_OOP_HopeThisWorks/src/main/java/tubes2/data/tes.json")){
            Gson gson=new GsonBuilder()
                    .registerTypeAdapter(Customer.class,new CustomerDeserializer())
                    .create();
            CustomerList cl=gson.fromJson(reader,new TypeToken<CustomerList>(){}.getType());
            return cl;
//            Gson gson1=new GsonBuilder().setPrettyPrinting().create();
//            System.out.println(gson1.toJson(cl));
//            Gson gson=new Gson();
//            CustomerList tes=gson.fromJson(reader,new TypeToken<CustomerList>(){}.getType());
//            Gson gson1=new Gson();
//            System.out.println(gson1.toJson(tes));
//            return gson.fromJson(reader,CustomerList.class);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeCustomer(CustomerList customerList) {
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter fileWriter=new FileWriter("/home/suisei/Documents/GitHub/Tubes2_OOP_HopeThisWorks/src/main/java/tubes2/data/tes.json")){
            gson.toJson(customerList,fileWriter);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {

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
