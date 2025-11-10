
import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetAllBookings {
    String BaseURL = "https://restful-booker.herokuapp.com/booking";

    @Test
    public void basicGetTest() {
        RestAssured.get(BaseURL).thenReturn();
        RestAssured.get(BaseURL).then().assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON);
    }

    @Test
    public void GetBookingIds_VerifyStatusCode_NonBDDStyle() {
 /*    Create a request specification
       This initializes a request object where you can set all the request details.
       Think of it like building the request before sending it.
*/
        RequestSpecification request = RestAssured.given();

//        request.header("Content-Type", "application/json");
//        request.queryParam("id", 10);


        //Adding URI
        request.baseUri(BaseURL);

        // Calling GET method on URI. After hitting we get Response. This means: “I want to send my request to this URL.”
        Response response = request.get();

        // Let's print response body.
        String resString = response.asString();
        System.out.println("Response Details : " + resString);

        /*
         * To perform validation on response like status code or value, we need to get
         * ValidatableResponse type of response using then() method of Response
         * interface. ValidatableResponse is also an interface.
         */
        ValidatableResponse valRes = response.then();
        // It will check if status code is 200
        valRes.statusCode(200);
        // It will check if status line is as expected
        valRes.statusLine("HTTP/1.1 200 OK");

    }
    @Test
    public void GetBookingIds_VerifyStatusCode_BDDStyle()
    {
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .when()
                .get("/booking")
                .then()
                .statusCode(200);
    }

}
