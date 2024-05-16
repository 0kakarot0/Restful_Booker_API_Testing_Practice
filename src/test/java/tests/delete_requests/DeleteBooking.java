package tests.delete_requests;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.data_serialization.JSON_Serialization;
import utils.file_utils.BookingConfigUtils;
import utils.request_builder.RequestBuilder;
import utils.response_parser.ResponseParser;

import java.util.HashMap;
import java.util.Map;

public class DeleteBooking extends TestBase {
    @Test
    public void deleteBooking() {
        Map<String, Object> userCredentials = new HashMap<>();
        userCredentials.put("username", "admin");
        userCredentials.put("password", "password123");
        String token = ResponseParser.getJsonValueAsString(RequestBuilder.postResponse("auth", JSON_Serialization.serializeObjectAsJson(userCredentials)), "token");

        Map<String, String> addCookieHeader = new HashMap<>();
        addCookieHeader.put("Cookie", "token=" + token);


        Response response = RequestBuilder.deleteResponse("booking/" + BookingConfigUtils.getProperty("bookingid"), addCookieHeader);
        String responseBody = ResponseParser.getResponseAsString(response);
        System.out.println(responseBody);
    }
}
