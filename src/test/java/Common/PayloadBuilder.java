package Common;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.put;

public class PayloadBuilder {

    public static JSONObject createEmployeeObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Nkosi");
        jsonObject.put("job", "Tester");


        return jsonObject;
    }

    public static JSONObject createWeatherStationObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", "AL_TEST001");
        jsonObject.put("name", "Nkosi test station");
        jsonObject.put("latitude", 37.76);
        jsonObject.put("longitude", -122.43);
        jsonObject.put("altitude", 150);
        return jsonObject;
    }

    public static JSONObject createWeatherStationWithNoNameObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", "AL_TEST001");
        jsonObject.put("name", "");
        jsonObject.put("latitude", 37.76);
        jsonObject.put("longitude", -122.43);
        jsonObject.put("altitude", 150);
        return jsonObject;
    }

}
