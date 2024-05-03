package assignments.RestAssuredAssign12;

import baseUrls.DocumenterUserBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class DeleteUser extends DocumenterUserBaseUrl {

    @Test
    public void apiTest(){

        // https://thinking-tester-contact-list.herokuapp.com/users/me
        spec.pathParams("first","users", "second", "me");

        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

        assertEquals(response.statusCode(), 200);



    }
}
