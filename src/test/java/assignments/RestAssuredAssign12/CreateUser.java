package assignments.RestAssuredAssign12;

import baseUrls.DocumenterUserBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.DocumenterCreateUserPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateUser extends DocumenterUserBaseUrl {

    //Write an automation test that will create a 'user' then read,
    // update and delete the created user using
    // the "https://documenter.getpostman.com/view/4012288/TzK2bEa8" document.

    /*
   --data-raw '{
   {
                     "firstName": "Rand",
                     "lastName": "AlMuhanna",
                     "email": "RaMuh@fake.com",
                     "password": "0000000"
                 }
}
    */

    public static String Token;
    @Test
    public void apiTest(){

        spec.pathParams("first","users");

        String userData = """
                {
                     "firstName": "Rand",
                     "lastName": "AlMuhanna",
                     "email": "RYMUH@fake.com",
                     "password": "0000000"
                 }
                """;

        DocumenterCreateUserPojo expectedData = ObjectMapperUtils.convertJsonToJava(userData, DocumenterCreateUserPojo.class);
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();


        response
                .then()
                .statusCode(200)
                .body("user.firstName", equalTo("Rand"),
                        "user.lastName", equalTo("AlMuhanna"),
                        "user.email", equalTo("RYMUH@fake.com"),
                        "user.password", equalTo("0000000")
                        );


        Token = response.jsonPath().getString("token");
        System.out.println(Token);
    }
}
