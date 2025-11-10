import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutRequest {
    @Test
    void putRequest_NonBDD() {

        RequestSpecification putRequest = RestAssured.given();
        putRequest.contentType(ContentType.JSON);
        putRequest.baseUri("https://jsonplaceholder.typicode.com");
        String reqBody = "{" + " \"title\": \"tutorial\"}";
        putRequest.body(reqBody);
        Response res = putRequest.put("/posts/1");
        System.out.println(res.asString());
        ValidatableResponse valRes = res.then().log().all();

        valRes.assertThat().statusCode(200);

    }

}
