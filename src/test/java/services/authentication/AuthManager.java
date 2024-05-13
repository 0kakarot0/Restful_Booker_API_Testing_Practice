package services.authentication;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthManager {
    private static String token;

    public static String getToken() {
        if (token == null) {
            authenticate();
        }
        return token;
    }

    private static void authenticate() {
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body("{ \"username\": \"user\", \"password\": \"pass\" }")
                .post("https://api.example.com/authenticate");

        token = response.jsonPath().getString("token");
    }
}
