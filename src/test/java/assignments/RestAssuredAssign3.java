package assignments;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredAssign3 {

       /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

    @Test
    public void apiTest(){

        String url = "https://reqres.in/api/users/23";
        Response response = given().get(url);
        response.prettyPrint();

        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server", "cloudflare")
               // .body("$", Matchers.hasSize(0))
                .body("isEmpty()", Matchers.is(true)

                );

    }
}
