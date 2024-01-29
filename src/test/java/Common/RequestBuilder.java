package Common;

import io.restassured.response.Response;

import static Common.BasePaths.*;
import static Common.ContentTypes.*;
import static Common.PayloadBuilder.*;
import static io.restassured.RestAssured.*;

public class RequestBuilder {

    public static String stationID;
    public static String StateProvince;

    public static Response createEmployeeResponse() {
        return given().
                when().
                body(createEmployeeObject()).
                contentType(Json_Content_Type).
                log().all().
                post(ReqRes_BaseURl + "/api/users").
                then().
                log().all().
                extract().response();
    }

    public static Response getBreedListResponse() {
        return given().
                when().
                contentType(Json_Content_Type).
                log().all().
                get(Dogs_BaseURl + "/breeds/list/all").
                then().
                log().all().
                extract().response();
    }

    public static Response createWeatherStationResponse() {
        Response response = given().
                queryParam("appid", "ca50431208ed3954e7c17ddba819480b").
                when().
                body(createWeatherStationObject()).
                contentType(Json_Content_Type).
                log().all().
                post(Weather_BaseURl + "/data/3.0/stations").
                then().
                log().all().
                extract().response();
        stationID = response.jsonPath().getString("ID");
        return response;
    }

    public static Response getWeatherStationResponse() {
        return given().
                queryParam("appid", "ca50431208ed3954e7c17ddba819480b").
                when().
                contentType(Json_Content_Type).
                log().all().
                get(Weather_BaseURl + "/data/3.0/stations/" + stationID).
                then().
                log().all().
                extract().response();
    }

    public static Response createWeatherStationWithNoNameResponse() {
        Response response = given().
                queryParam("appid", "ca50431208ed3954e7c17ddba819480b").
                when().
                body(createWeatherStationWithNoNameObject()).
                contentType(Json_Content_Type).
                log().all().
                post(Weather_BaseURl + "/data/3.0/stations").
                then().
                log().all().
                extract().response();
        stationID = response.jsonPath().getString("ID");
        return response;
    }

    public static Response getSTateProvinceResponse() {
        Response response= given().
                queryParam("country","South Africa").
                when().
                contentType(Json_Content_Type).
                get("http://universities.hipolabs.com/search").
                then().
                log().all().
                extract().response();

        StateProvince=response.jsonPath().getString("[0].state-province");
        return response;
    }


}
