import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.File;

public class PostRequestGetAuthBooking {
    /*
    *
{
    "username" : "admin",
    "password" : "password123"
}
* */
    String jsonString = "{\"username\" : \"admin\",\"password\" : \"password123\"}";

    @Test
    public String postAuth_NonBDD() {
        /*
        We can pass body as a String or a JSON file or a XML file or a Java Object or a byte array.
         * */
        RequestSpecification request = RestAssured.given();
        request.body(jsonString);
        request.contentType(ContentType.JSON);
        //Adding URI
        request.baseUri("https://restful-booker.herokuapp.com/auth");
        Response response = request.post();
        System.out.println(response.asString());


        ValidatableResponse validatableResponse = response.then();

        validatableResponse.statusCode(200);
        validatableResponse.body("token", Matchers.notNullValue());
        validatableResponse.body("token.length()", Matchers.is(15));
        String token = response.jsonPath().getString("token");
        return token;


    }

    @Test
    public void postAuth_BDD() {
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/auth").body(jsonString).contentType(ContentType.JSON)
                .when()
                .post()
                .then()
                .assertThat()
                .body("token", Matchers.notNullValue());
    }
    //XML is the same as json file but change content type to ContentType.XML
    @Test
    public void getJsonDataFromFile() {
        File jsonFile = new File("E:\\Material_For_Interviews\\RestAssured\\Learning-RestAssured\\RestAssuredLearning\\src\\main\\resources\\data.json");
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/auth").contentType(ContentType.JSON).body(jsonFile).when().post().then().log().all();
    }
}
