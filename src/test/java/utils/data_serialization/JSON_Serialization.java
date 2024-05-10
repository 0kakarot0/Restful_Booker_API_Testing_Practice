package utils.data_serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSON_Serialization {
    private static final Gson gson = new Gson();
    private static final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

    public static String serializeObjectAsJson(Object object){
        return gson.toJson(object);
    }
}
