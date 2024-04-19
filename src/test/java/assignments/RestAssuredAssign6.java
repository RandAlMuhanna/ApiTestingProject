package assignments;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredAssign6 {

    /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

    @Test
    public void apiTest(){

        //Set the Url
        String url = "https://reqres.in/api/users";

        //Set the expected data(Payload)
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("name", "morpheus");
        expectedData.put("job", "leader");
        System.out.println("expectedData = " + expectedData);

        //Send POST Request to the Url
        Response response =
                given().body(expectedData).contentType(ContentType.JSON).post(url);
        response.prettyPrint();

        // Status code is 201
        response
                .then()
                .statusCode(201)
                .body("name", equalTo("morpheus"),
                        "job", equalTo("leader"));
    }
}
