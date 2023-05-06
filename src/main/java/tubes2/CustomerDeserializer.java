package tubes2;

import com.google.gson.*;
import org.json.simple.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CustomerDeserializer implements JsonDeserializer<Customer> {
    @Override
    public Customer deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        int id=jsonObject.get("id").getAsInt();
        JsonArray historiTransaksiArrJson=jsonObject.get("historiTransaksi").getAsJsonArray();
        List<JsonElement> histtransaksiList=historiTransaksiArrJson.asList();
        List<FixedBill> fixedBillList=new ArrayList<>();
        JsonObject fixedBillJson;
        JsonArray elmtofbillarr;
        List<JsonElement> elmtofbillList;
        FixedBill fixedBill=new FixedBill();
        JsonObject elmtofBillJson;
        for (JsonElement je :
                histtransaksiList) {
            fixedBill.clearListBelanja();
            fixedBillJson=je.getAsJsonObject();
            elmtofbillarr=fixedBillJson.getAsJsonArray("listBelanja");
            elmtofbillList=elmtofbillarr.asList();
            for (JsonElement je2 :
                    elmtofbillList) {
                elmtofBillJson=je2.getAsJsonObject();
                String barang=elmtofBillJson.get("barang").getAsString();
                int jumlahBarang=elmtofBillJson.get("jumlahBarang").getAsInt();
                fixedBill.addListBelanja(new ElmtOfBill(barang,jumlahBarang));
            }
            fixedBillList.add(fixedBill);
        }
        if (jsonObject.has("vip")&&
        jsonObject.has("nama")&&
        jsonObject.has("nomorTelepon")&&
        jsonObject.has("poin")&&
        jsonObject.has("aktif")){
            boolean vip=jsonObject.get("vip").getAsBoolean();
            String nama=jsonObject.get("nama").getAsString();
            String nomorTelepon=jsonObject.get("nomorTelepon").getAsString();
            int poin=jsonObject.get("poin").getAsInt();
            boolean aktif=jsonObject.get("aktif").getAsBoolean();

            return new RegisteredCustomer(id,fixedBillList,vip,nama,nomorTelepon,poin,aktif);
        } else{
            return new UnregisteredCustomer(id,fixedBillList);
        }
    }
}
