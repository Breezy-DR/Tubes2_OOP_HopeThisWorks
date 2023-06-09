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
import java.io.FileOutputStream;
import java.io.FileReader;

public class XMLDataStore implements IDataStore {

//    @Override
//    public Customer getCustomer(String filePath,int id) {
//        CustomerList customerList=this.readCustomer(filePath);
//        return customerList.getCustomerByID(id);
//    }

    @Override
    public CustomerList readCustomer(String filePath) {
        try (FileReader reader=new FileReader(filePath+"/customer.xml")){
            Gson gson=new GsonBuilder()
                    .registerTypeAdapter(Customer.class,new CustomerDeserializer())
                    .create();
            JSONObject jsonObject= XML.toJSONObject(reader);
            JsonObject root=JsonParser.parseString(jsonObject.toString()).getAsJsonObject();
            System.out.println(root.toString());
            JsonObject customlist=root.getAsJsonObject("customerListClass");
            System.out.println(customlist.toString());
            CustomerList cl=gson.fromJson(customlist,new TypeToken<CustomerList>(){}.getType());
            cl.removeDummy();
            return cl;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

//    @Override
//    public void addCustomer(String filePath,Customer customer) {
//        CustomerList cl=this.readCustomer(filePath);
//        cl.addCustomer(customer);
//        this.writeCustomer(filePath,cl);
//    }

    @Override
    public void writeCustomer(String filePath,CustomerList customerList) {
//        customerList.setCustomerList(customerList.getCustomerList().add(0,new));
        try{
            customerList.insertDummy();
            JAXBContext jaxbContext=JAXBContext.newInstance(CustomerList.class);
            Marshaller marshaller=jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(customerList,new File(filePath+"/customer.xml"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public BarangList readBarang(String filePath) {
        try (FileReader reader=new FileReader(filePath+"/barang.xml")){
            Gson gson=new GsonBuilder()
                    .registerTypeAdapter(Barang.class,new BarangDeserializer())
                    .create();
            JSONObject jsonObject= XML.toJSONObject(reader);
//            JsonParser parser=new JsonParser();
            JsonObject root=JsonParser.parseString(jsonObject.toString()).getAsJsonObject();
//            System.out.println(root);
            JsonObject baranglist=root.getAsJsonObject("barangListClass");
//            System.out.println(customlist);
            BarangList bl=gson.fromJson(baranglist,new TypeToken<BarangList>(){}.getType());
            bl.removeDummy();
            return bl;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeBarang(String filePath,BarangList barangList) {
        try{
            barangList.insertDummy();
            JAXBContext jaxbContext=JAXBContext.newInstance(BarangList.class);
            Marshaller marshaller=jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(barangList,new File(filePath+"/barang.xml"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

//    @Override
//    public Barang getBarang(String filePath,int idBarang) {
//        BarangList barangList=this.readBarang(filePath);
//        return barangList.getBarang(idBarang);
//    }

//    @Override
//    public void updateCustomer(String filePath,Customer customer) {
//        CustomerList customerList=this.readCustomer(filePath);
//        customerList.updateCustomer(customer);
//        this.writeCustomer(filePath,customerList);
//    }

//    @Override
//    public void addBarang(String filePath,Barang barang) {
//        BarangList barangList=this.readBarang(filePath);
//        barangList.addBarang(barang);
//        this.writeBarang(filePath,barangList);
//    }

//    @Override
//    public void updateBarang(String filePath,Barang barang) {
//        BarangList barangList=this.readBarang(filePath);
//        barangList.updateBarang(barang);
//        this.writeBarang(filePath,barangList);
//    }
//    public void deleteBarang(String filePath,int idBarang){
//        BarangList barangList=this.readBarang(filePath);
//        barangList.deleteBarang(idBarang);
//        this.writeBarang(filePath,barangList);
//    }

    @Override
    public Fee readFee(String filePath) {
        try (FileReader fileReader=new FileReader(filePath+"/fee.xml")){
            JSONObject jsonObject=XML.toJSONObject(fileReader);
            JsonObject jsonObject1=JsonParser.parseString(jsonObject.toString()).getAsJsonObject();
            System.out.println(jsonObject1.toString());
            JsonObject jsonObject2=jsonObject1.getAsJsonObject("fee");
            Gson gson=new GsonBuilder().registerTypeAdapter(Fee.class,new FeeDeserializer()).create();
            Fee fee=gson.fromJson(jsonObject2.toString(),Fee.class);
            return fee;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateFee(String filePath, Fee fee) {
        try {
            JAXBContext jaxbContext =JAXBContext.newInstance(Fee.class);
            Marshaller marshaller=jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(fee,new File(filePath+"/fee.xml"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public KursList readKurs(String filePath) {
        try (FileReader reader=new FileReader(filePath+"/kurs.xml")){
            Gson gson=new GsonBuilder()
                    .registerTypeAdapter(Kurs.class,new KursDeserializer())
                    .create();
            JSONObject jsonObject=XML.toJSONObject(reader);
            JsonObject root=JsonParser.parseString(jsonObject.toString()).getAsJsonObject();
            JsonObject kursListClass=root.getAsJsonObject("kursListClass");
            System.out.println(root.toString());
            KursList kursList=gson.fromJson(kursListClass,new TypeToken<KursList>(){}.getType());
            kursList.removeDummy();
            return kursList;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeKurs(String filePath, KursList kursList) {
        try{
            kursList.insertDummy();
            JAXBContext jaxbContext=JAXBContext.newInstance(KursList.class);
            Marshaller marshaller=jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(kursList,new File(filePath+"/kurs.xml"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
