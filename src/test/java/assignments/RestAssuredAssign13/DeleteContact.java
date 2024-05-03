package assignments.RestAssuredAssign13;

import baseUrls.DocumenterContactBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.DocumenterCreateContactPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;

public class DeleteContact extends DocumenterContactBaseUrl {

    @Test
    public void apiTest() {

        // https://thinking-tester-contact-list.herokuapp.com/users/me
        spec.pathParams("first", "users", "second", "me");


        // Sent the request and get the response
        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

    }
}
