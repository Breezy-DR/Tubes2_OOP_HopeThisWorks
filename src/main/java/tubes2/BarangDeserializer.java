package tubes2;

import com.google.gson.*;
import tubes2.Barang;

import java.lang.reflect.Type;

public class BarangDeserializer implements JsonDeserializer<Barang> {

    @Override
    public Barang deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject=jsonElement.getAsJsonObject();
        int idBarang=jsonObject.get("idBarang").getAsInt();
        int stok=jsonObject.get("stok").getAsInt();
        String namaBarang=jsonObject.get("namaBarang").getAsString();
        int hargaJualBarang=jsonObject.get("hargaJualBarang").getAsInt();
        int hargaBeliBarang=jsonObject.get("hargaBeliBarang").getAsInt();
        String kategori=jsonObject.get("kategori").getAsString();
        String gambar=jsonObject.get("gambar").getAsString();
        return new Barang(idBarang,stok,namaBarang,hargaJualBarang,hargaBeliBarang,kategori,gambar);
    }
}
