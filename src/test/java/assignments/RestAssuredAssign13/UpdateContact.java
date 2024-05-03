package assignments.RestAssuredAssign13;

import baseUrls.DocumenterContactBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.DocumenterCreateContactPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UpdateContact extends DocumenterContactBaseUrl {

    @Test
    public void apiTest(){

        // https://thinking-tester-contact-list.herokuapp.com/users/me
        spec.pathParams("first","users", "second", "me");

        String data = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                   
                }
                """;


        DocumenterCreateContactPojo expectedData = ObjectMapperUtils.convertJsonToJava(data, DocumenterCreateContactPojo.class);
        System.out.println("expectedData = " + expectedData);

        // Sent the request and get the response
        Response response = given(spec).put("{first}/{second}");
        response.prettyPrint();


        // Do Assertions
        DocumenterCreateContactPojo actualData = ObjectMapperUtils.convertJsonToJava(response.toString(), DocumenterCreateContactPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getFirstName(), expectedData.getFirstName());
        assertEquals(actualData.getLastName(), expectedData.getLastName());


    }
}
