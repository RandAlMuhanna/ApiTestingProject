package assignments.RestAssuredAssign12;

import baseUrls.DocumenterUserBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.DocumenterCreateUserPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetUser extends DocumenterUserBaseUrl {

    @Test
    public void aoiTest(){

        // https://thinking-tester-contact-list.herokuapp.com/users/me
        spec.pathParams("first","users", "second", "me");

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

        Response response = given(spec).body(expectedData).get("{first}/{second}");
        response.prettyPrint();

        response
                .then()
                .body("firstName",equalTo(expectedData.getFirstName())
                        ,"lastName",equalTo(expectedData.getLastName())
                        ,"email",equalTo(expectedData.getEmail())) ;

    }

}
