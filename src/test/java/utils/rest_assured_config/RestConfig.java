package utils.rest_assured_config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class RestConfig {

    public static void setUp() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";

//        setAuthentication();
    }

    public static void setAuthentication() {
        RestAssured.basic("abc","assa");
    }

    public static RequestSpecification getDefaultSpecification() {
        return RestAssured.given().headers(headers()).log().all();
    }

    public static RequestSpecification getRequestSpecification(Map<String, String> additionalHeaders) {
        RequestSpecBuilder builder = new RequestSpecBuilder()
                .addHeaders(headers()); // Add default headers

        if (additionalHeaders != null) {
            builder.addHeaders(additionalHeaders); // Add provided headers
        }

        return builder.log(LogDetail.ALL).build();
    }

    private static Map<String, String> headers() {
        Map<String, String> allHeaders = new HashMap<>();
        allHeaders.put("Content-Type", "application/json");
        allHeaders.put("Accept", "application/json");
        return allHeaders;
    }
}
