package utils.request_builder;

import io.restassured.response.Response;
import utils.rest_assured_config.RestConfig;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestBuilder {
    public static Response getResponse(String endPoint) {
        return given().when().get(endPoint);
    }

    public static Response postResponse(String endPoint, Object object) {
        return given().spec(RestConfig.getDefaultSpecification()).body(object).when().post(endPoint);
    }

    public static Response putResponse(String endPoint, Object object, Map<String, String> tokenObject) {
        return given().spec(RestConfig.getRequestSpecification(tokenObject)).body(object).when().put(endPoint);
    }

    public static Response patchResponse(String endPoint, Object object, Map<String, String> tokenObject) {
        return given().spec(RestConfig.getRequestSpecification(tokenObject)).body(object).when().patch(endPoint);
    }

    public static Response deleteResponse(String endPoint, Map<String, String> tokenObject) {
        return given().spec(RestConfig.getRequestSpecification(tokenObject)).when().delete(endPoint);
    }

}
