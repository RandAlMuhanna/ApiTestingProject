package requests;

import baseUrls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C11_PostRequestWithMap extends JsonPlaceHolderBaseUrl {

    /*
     Given
       1) https://jsonplaceholder.typicode.com/todos
       2)  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
          }
    When
        I send POST Request to the Url

    Then
        Status code is 201
    And
        response body is like {
                                "userId": 55,
                                "title": "Tidy your room",
                                "completed": false,
                                "id": 201
                                }
*/
    @Test
    public void postRequestTest(){

        //Set the Url
        spec.pathParams("first", "todos");

        //Set the expected data(Payload) --> Prepare it as a Map.
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId",55);
        expectedData.put("title","Tidy your room");
        expectedData.put("completed",false);

        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec)
                //.contentType(ContentType.JSON)//For serialization we need to declare content type. This process is repetitive action, to avoid repeation we will put this in spec object.
                .body(expectedData)
                .post("{first}");

        response.prettyPrint();

        //Do assertion
        response
                .then()
                .statusCode(201)
                .body("userId", equalTo(55),
                        "title", equalTo("Tidy your room"),
                        "completed", equalTo(false));


    }
}
