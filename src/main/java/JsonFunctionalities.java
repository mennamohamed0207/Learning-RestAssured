import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonFunctionalities {

    @Test
    public void convertJavaMapToJson()
    {
        // Step 1: Create JSON body as a Java Map
        //As all types inherit from Object class
        Map<String, Object> booking = new HashMap<>();
        booking.put("firstname", "Jim");
        booking.put("lastname", "Brown");
        booking.put("totalprice", 111);
        booking.put("depositpaid", true);

        // Nested JSON for bookingdates
        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2024-01-01");
        bookingDates.put("checkout", "2024-01-05");

        booking.put("bookingdates", bookingDates);
        booking.put("additionalneeds", "Breakfast");

        System.out.println("//////////"+booking);
        // Step 2: Send POST request
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)   // tells the server we’re sending JSON
                .body(booking)
                .log().body() // ✅ logs the full JSON request body                .when()
                .post()
                .then()
                .log().all()
                .statusCode(200);
    }


    @Test
    public void CreatingNestedJsonObjectTest()
    {

        // JSON Object for first guest
        Map bookingOne = new HashMap();
        bookingOne.put("firstname", "Amod");
        bookingOne.put("lastname", "Mahajan");
        bookingOne.put("totalprice", 222);
        bookingOne.put("depositpaid", true);

        Map bookingDatesMapForAmod = new HashMap<>();
        bookingDatesMapForAmod.put("checkin", "2021-08-01");
        bookingDatesMapForAmod.put("checkout", "2021-08-02");

        bookingOne.put("bookingdates", bookingDatesMapForAmod);
        bookingOne.put("additionalneeds", "Breakfast");

        // JSON Object for second guest
        Map bookingTwo = new HashMap();
        bookingTwo.put("firstname", "Animesh");
        bookingTwo.put("lastname", "Prashant");
        bookingTwo.put("totalprice", 111);
        bookingTwo.put("depositpaid", true);

        Map bookingDatesMapForAnimesh = new HashMap<>();
        bookingDatesMapForAnimesh.put("checkin", "2021-07-01");
        bookingDatesMapForAnimesh.put("checkout", "2021-07-01");

        bookingTwo.put("bookingdates", bookingDatesMapForAnimesh);
        bookingTwo.put("additionalneeds", "Breakfast");

        // Creating JSON array to add both JSON objects
       ArrayList jsonArrayPayload = new ArrayList<>();

        jsonArrayPayload.add(bookingOne);
        jsonArrayPayload.add(bookingTwo);



        //GIVEN
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .contentType(ContentType.JSON)
                .body(jsonArrayPayload)
                .log()
                .all()
                // WHEN
                .when()
                .post()
                // THEN
                .then()
                .assertThat()
                // Asserting status code as 500 as it does not accept json array payload
                .statusCode(500)
                .log()
                .all();
    }

}
