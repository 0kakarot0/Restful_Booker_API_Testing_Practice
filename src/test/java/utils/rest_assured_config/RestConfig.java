package utils.rest_assured_config;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

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
                header("Content-Type", "application/json").log().all();
    }
}
