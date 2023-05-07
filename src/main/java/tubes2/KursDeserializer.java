package tubes2;

import com.google.gson.*;

import java.lang.reflect.Type;

public class KursDeserializer implements JsonDeserializer<Kurs> {

    @Override
    public Kurs deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject=jsonElement.getAsJsonObject();
        String namaMataUang=jsonObject.get("namaMataUang").getAsString();
        float kursToIDR =jsonObject.get("kursToIDR").getAsFloat();
        return new Kurs(namaMataUang,kursToIDR);
    }
}
