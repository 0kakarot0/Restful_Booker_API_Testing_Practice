package tests.put_request;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.data_serialization.JSON_Serialization;
import utils.file_utils.BookingConfigUtils;
import utils.request_builder.RequestBuilder;
import utils.response_parser.ResponseParser;

import java.util.HashMap;
import java.util.Map;

public class UpdateBooking extends TestBase {

    @Test
    public void updateBooking() {
        Map<String, Object> userCredentials = new HashMap<>();
        userCredentials.put("username", "admin");
        userCredentials.put("password", "password123");
        String token = ResponseParser.getJsonValueAsString(RequestBuilder.postResponse("auth", JSON_Serialization.serializeObjectAsJson(userCredentials)), "token");

        Map<String, String> addCookieHeader = new HashMap<>();
        addCookieHeader.put("Cookie", "token=" + token);

        Map<String, Object> mapObject = new HashMap<>();
        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2019-01-01");

        mapObject.put("firstname", "David");
        mapObject.put("lastname", "Martin");
        mapObject.put("totalprice", 123);
        mapObject.put("depositpaid", true);
        mapObject.put("bookingdates", bookingDates);
        mapObject.put("additionalneeds", "Breakfast");


        Response response = RequestBuilder.putResponse("booking/" + BookingConfigUtils.getProperty("bookingid"), JSON_Serialization.serializeObjectAsJson(mapObject), addCookieHeader);

        String responseBody = ResponseParser.getResponseAsString(response);
        System.out.println(responseBody);
    }
}
