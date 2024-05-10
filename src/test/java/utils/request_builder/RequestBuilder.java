package utils.request_builder;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestBuilder {
    public static Response getResponse(String endPoint) {
        return given().when().get(endPoint);
    }

    public static Response postResponse(String endPoint, Object object) {
        return given().body(object).when().post(endPoint);
    }

    public static Response putResponse(String endPoint, Object object) {
        return given().body(object).when().put(endPoint);
    }

    public static Response patchResponse(String endPoint, Object object) {
        return given().body(object).when().patch(endPoint);
    }

    public static Response deleteResponse(String endPoint){
        return given().when().delete(endPoint);
    }

}
