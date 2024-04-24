package assignments;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class RestAssuredAssign9 {

    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12

    Note: Print using JsonPath: response.jsonPath().prettyPrint();

*/


    @Test
    public void apiTest(){

        // Set the url
        String url = "https://automationexercise.com/api/productsList";

        // Sends a GET request
        Response response = given().get(url);
        response.jsonPath().prettyPrint();

        // Assert that the number of "Women" user type is 12
        JsonPath jsonPath = response.jsonPath();
        int typeWomen = jsonPath.setRootPath("products.category.usertype").get("findAll{it.usertype == 'Women'}.size()");

        System.out.println("typeWomen = " + typeWomen);
        assertEquals(typeWomen,12);



    }
}
