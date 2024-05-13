package tests.post_requests;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.data_serialization.JSON_Serialization;
import utils.request_builder.RequestBuilder;
import utils.response_parser.ResponseParser;

import java.util.HashMap;
import java.util.Map;

public class PostBooking extends TestBase {
    @Test
    public void createBooking() {
        Map<String, Object> createBookingObject = new HashMap<>();
        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2019-01-01");

        createBookingObject.put("firstname", "Kim");
        createBookingObject.put("lastname", "Kardashian");
        createBookingObject.put("totalprice", 111);
        createBookingObject.put("depositpaid", true);
        createBookingObject.put("bookingdates", bookingDates);
        createBookingObject.put("additionalneeds", "Breakfast");

        System.out.println(createBookingObject);

        Response response = RequestBuilder.postResponse("booking", JSON_Serialization.serializeObjectAsJson(createBookingObject));

        String responseBody = ResponseParser.getResponseAsString(response);
        System.out.println(responseBody);

        Assert.assertEquals(response.statusCode(),200);

    }


}
