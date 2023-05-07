package tubes2;

import com.google.gson.*;

import java.lang.reflect.Type;

public class FeeDeserializer implements JsonDeserializer<Fee> {
    @Override
    public Fee deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject=jsonElement.getAsJsonObject();
        float discount=jsonObject.get("discount").getAsFloat();
        float serviceFee=jsonObject.get("serviceFee").getAsFloat();
        float tax=jsonObject.get("tax").getAsFloat();
        return new Fee(discount,tax,serviceFee);
    }
}
