import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequest {
    String deletedId="2";

    @Test
    public void deleteRequest() {
        RequestSpecification request = given();
        PostRequestGetAuthBooking postReq=new PostRequestGetAuthBooking();
        String token=postReq.postAuth_NonBDD();
        // Setting a cookie for authentication as per API documentation
        request.cookie("token", token);
        request.baseUri("https://restful-booker.herokuapp.com/booking/");



        Response response = request.delete(deletedId);

        // Printing Response as string
        System.out.println(response.asString());

        ValidatableResponse validatableResponse = response.then();

        validatableResponse.statusCode(201);

        RequestSpecification getRequestSpec = given();

        getRequestSpec.baseUri("https://restful-booker.herokuapp.com/booking/");

        Response res = getRequestSpec.get(deletedId);
        System.out.println(res.asString());
        ValidatableResponse valRes = res.then();

        valRes.statusCode(404);
    }

}