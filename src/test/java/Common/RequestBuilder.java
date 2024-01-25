package Common;

import io.restassured.response.Response;
import static Common.BasePaths.*;
import static Common.ContentTypes.*;
import static Common.PayloadBuilder.*;
import static io.restassured.RestAssured.*;

public class RequestBuilder {

    public static Response createEmployeeResponse() {
        return given().
                when().
                body(createEmployeeObject()).
                contentType(Json_Content_Type).
                log().all().
                post(ReqRes_BaseURl+"/api/users").
                then().
                log().all().
                extract().response();
    }


}
