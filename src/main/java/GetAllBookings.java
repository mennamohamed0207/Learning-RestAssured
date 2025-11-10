
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.concurrent.TimeUnit;

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
        long responseTime1 = response.getTimeIn(TimeUnit.SECONDS);
        System.out.println("Response time in ms using getTimeIn():" + responseTime1);
        valRes.time(Matchers.lessThan(2000L));
    }

    @Test
    public void GetBookingIds_VerifyStatusCode_BDDStyle() {
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .when()
                .get("/booking")
                .then()
                .statusCode(200);
    }

    @Test
    public void requestSpecificationsExamples() {
        RequestSpecification requestSpecification =
                RestAssured.given()
                        .baseUri("https://restful-booker.herokuapp.com")
                        .basePath("/booking");

//        RestAssured.given(requestSpecification);
//        OR
//        RestAssured.given().spec(requestSpecification);

        RequestSpecBuilder reqBuild = new RequestSpecBuilder();
        reqBuild.setBaseUri("https://restful-booker.herokuapp.com");
        reqBuild.setBasePath("/booking");
        RequestSpecification reqSpec = reqBuild.build();

        Response res1 = reqSpec.get();
        System.out.println(res1.asString());
        System.out.println("======================");
        //default specifications for requests later
        RestAssured.requestSpecification = requestSpecification;


    }

    @Test
    public void getQueryingRequest() {
        //----------------------------------------------Query Specification------------------------------------
        RequestSpecification request1 = RestAssured.given();
        // I am adding dummy request details for example
        String JsonBody = "{\"firstName\":\"Amod\"}";

        // Setting Base URI
        request1.baseUri("https://restful-booker.herokuapp.com")
                // Setting Base Path
                .basePath("/booking")
                .body(JsonBody)
                .header("header1", "headerValue1")
                .header("header2", "headerValue2");
        QueryableRequestSpecification queryRequest = SpecificationQuerier.query(request1);

        // get base URI
        String retrieveURI = queryRequest.getBaseUri();
        System.out.println("Base URI is : " + retrieveURI);
        System.out.println("Headers are : " + queryRequest.getHeaders());
        Headers allHeaders = queryRequest.getHeaders();

        for (Header h : allHeaders) {
            System.out.println("Header name : " + h.getName() + " Header value is : " + h.getValue());
        }

    }

    @Test
    //Ports used in this function are not the real ports for the url used
    public void usingPortAndHost() {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
//                .port(8181)
                .when()
                .get()
                .then()
                .log()
                .all();
        System.out.println("//------------------------------------------------------------------------------------//");

        // Creating request specification using given()
        RequestSpecification request1 = RestAssured.given();
        // Setting Base URI
        request1.baseUri("https://restful-booker.herokuapp.com");
        // Setting Base Path
        request1.basePath("/ping");
        request1.port(8181);
        System.out.println("//------------------------------------------------------------------------------------//");
        // Creating request specification using given()
        RequestSpecification request1_1 = RestAssured.given();
        // Setting Base URI
        request1_1.baseUri("https://restful-booker.herokuapp.com");
        // Setting Base Path
        request1_1.basePath("/ping");
        request1_1.port(8181);
        System.out.println("//------------------------------------------------------------------------------------//");
        // Using RestAssured static property to make default port
        RestAssured.port = 9191;
    }

}
