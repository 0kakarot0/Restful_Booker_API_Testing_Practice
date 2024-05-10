package tests.get_requests;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.request_builder.RequestBuilder;
import utils.response_parser.ResponseParser;

public class GetBooking extends TestBase {

    @Test
    public void getBooking() {
        Response response = RequestBuilder.getResponse("booking");
        String responseBody = ResponseParser.getResponseAsString(response);
        Assert.assertTrue(responseBody.contains("bookingid"));

        System.out.println(response.statusCode());
    }

    @Test
    public void getSingleBooking() {
        Response response = RequestBuilder.getResponse("booking/2");
        String responseBody = ResponseParser.getResponseAsString(response);
        System.out.println(responseBody.contains("\"firstname\":\"Jim\""));

        System.out.println(responseBody);
    }
}
