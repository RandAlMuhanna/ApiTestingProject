package assignments.RestAssuredAssign13;

import baseUrls.DocumenterContactBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.DocumenterCreateContactPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetContact extends DocumenterContactBaseUrl {

    @Test
    public void apiTest(){

        // https://thinking-tester-contact-list.herokuapp.com/users/me
        spec.pathParams("first","users", "second", "me");

        String data = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                    "birthdate": "1970-01-01",
                    "email": "jdoe@fake.com",
                    "phone": "8005555555",
                    "street1": "1 Main St.",
                    "street2": "Apartment A",
                    "city": "Anytown",
                    "stateProvince": "KS",
                    "postalCode": "12345",
                    "country": "USA"
                }
                """;


        DocumenterCreateContactPojo expectedData = ObjectMapperUtils.convertJsonToJava(data, DocumenterCreateContactPojo.class);
        System.out.println("expectedData = " + expectedData);

        // Sent the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();


        // Do Assertions
        DocumenterCreateContactPojo actualData = ObjectMapperUtils.convertJsonToJava(response.toString(), DocumenterCreateContactPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);

        assertEquals(actualData.getFirstName(), expectedData.getFirstName());
        assertEquals(actualData.getLastName(), expectedData.getLastName());
        assertEquals(actualData.getBirthdate(), expectedData.getBirthdate());
        assertEquals(actualData.getEmail(), expectedData.getEmail());
        assertEquals(actualData.getPhone(), expectedData.getPhone());
        assertEquals(actualData.getStreet1(), expectedData.getStreet1());
        assertEquals(actualData.getStreet2(), expectedData.getStreet2());
        assertEquals(actualData.getCity(), expectedData.getCity());
        assertEquals(actualData.getStateProvince(), expectedData.getStateProvince());
        assertEquals(actualData.getPostalCode(), expectedData.getPostalCode());
        assertEquals(actualData.getCountry(), expectedData.getCountry());


    }
}
