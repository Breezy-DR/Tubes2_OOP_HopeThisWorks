package tubes2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.json.XML;
import org.json.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import java.io.File;
import java.io.FileReader;

public class XMLDataStore implements IDataStore {
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
        try (FileReader reader=new FileReader(this.getFilePath()+"/customer.xml")){
            Gson gson=new GsonBuilder()
                    .registerTypeAdapter(Customer.class,new CustomerDeserializer())
                    .create();
            JSONObject jsonObject= XML.toJSONObject(reader);
            JsonParser parser=new JsonParser();
            JsonObject root=parser.parse(jsonObject.toString()).getAsJsonObject();
//            System.out.println(root);
            JsonObject customlist=root.getAsJsonObject("customerListClass");
//            System.out.println(customlist);
            CustomerList cl=gson.fromJson(customlist,new TypeToken<CustomerList>(){}.getType());
            return cl;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeCustomer(CustomerList customerList) {
        try{
            JAXBContext jaxbContext=JAXBContext.newInstance(CustomerList.class);
            Marshaller marshaller=jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(customerList,new File(this.getFilePath()+"/customer.xml"));
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
