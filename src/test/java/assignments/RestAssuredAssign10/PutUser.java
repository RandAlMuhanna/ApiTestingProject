package assignments.RestAssuredAssign10;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserPetstorePojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;

public class PutUser {

      /*
    Write an automation test that will create a 'user' then read,
    update and delete the created user using the "https://petstore.swagger.io/" document.
    (Create a classes for each request.)
     */

    @Test
    public void apiTest(){

        String url = "https://petstore.swagger.io/v2/user";

        String createUser = """
                
                {
                  "id": 0,
                  "username": "RAMUH",
                  "firstName": "Rand",
                  "lastName": "AlMuhanna",
                  "email": "Rand.y.almuhanna@gmail.com",
                  "password": "0000000",
                  "phone": "0536608515",
                  "userStatus": 0
                }
                """;

        UserPetstorePojo expectedData = ObjectMapperUtils.convertJsonToJava(createUser, UserPetstorePojo.class);
        System.out.println("expectedData = " + expectedData);

        Response response = given().body(expectedData).put(url);
        response.prettyPrint();


    }
}
