package utils.rest_assured_config;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class RestConfig {

    public static void setUp(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";

        setAuthentication();
    }

    private static void setAuthentication() {
        RestAssured.basic("admin","password123");
    }

    public static RequestSpecification getRequestSpecification(){
        return RestAssured.
                given().
                headers(headers()).log().all();
    }

    private static Map<String, String> headers(){
        Map<String, String> allHeaders = new HashMap<>();
        allHeaders.put("Content-Type", "application/json");
        allHeaders.put("Accept", "application/json");
        return allHeaders;
    }
}
