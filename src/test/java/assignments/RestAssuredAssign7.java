package assignments;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserPetstorePojo;

import static io.restassured.RestAssured.given;

public class RestAssuredAssign7 {

    /*
Write an automation test that will create a 'user' using the "https://petstore.swagger.io/" document
*/

    @Test
    public void apiTest(){

        // Set the url
        String url = "https://petstore.swagger.io/";


        // Create a 'user'
        UserPetstorePojo pojoData = new UserPetstorePojo(1, "RandMuh", "Rand", "AlMuhanna"
                , "Rand@gmail.com", "123445", "05500000", 0);
        System.out.println("pojoData = " + pojoData);

        // Get response
        Response response = given()
                .body(pojoData)
                .contentType(ContentType.JSON)
                .post(url);
        response.prettyPrint();


    }
}
