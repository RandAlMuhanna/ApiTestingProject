package assignments;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class RestAssuredAssign5 {
     /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */

    @Test
    public void apiTest(){

        String url = "https://reqres.in/api/unknown/";
        Response response = given().get(url);
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        // 1)Status code is 200
        response.then().statusCode(200);

        //2)Print all pantone_values
        List<Object> getPantoneValues = jsonPath.getList("data.pantone_value");
        System.out.println("getPantoneValues = " + getPantoneValues);

        // 3)Print all ids greater than 3 on the console And Assert that there are 3 ids greater than 3
        List<Integer> ids = jsonPath.setRootPath("data").getList("findAll{it.id>3}.id");

        assertEquals(ids.size() , 3);

        //4)Print all names whose ids are less than 3 on the console Assert that the number of names whose ids are less than 3 is 2
        List<String> names = jsonPath.setRootPath("data").getList("findAll{it.id<3}.name");
        System.out.println("names = " + names);
        assertEquals(names.size(),2 );


    }
}
