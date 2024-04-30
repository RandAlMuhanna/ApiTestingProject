package assignments;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RestAssuredAssign11 {

    /*
    Given
        https://dummy.restapiexample.com/api/v1/employees
    When
        User sends Get Request to the Url
    Then
        Status code is 200
    And
        There are 24 employees
    And
        "Tiger Nixon" and "Garrett Winters" are among the employees
    And
        The greatest age is 66
    And
        The name of the lowest age is "Tatyana Fitzpatrick"
    And
        Total salary of all employees is 6,644,770
 */

    @Test
    public void apiTest(){

        String url = "https://dummy.restapiexample.com/api/v1/employees";
        Response response = given().get(url);
        response.prettyPrint();

        /*
        - collect – collect the return value of calling a closure on each item in a collection
        - sum – Sum all the items in the collection
        - max/min – returns the max/min values of the collection
         */

        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", hasSize(24),
                        "data.employee_name", hasItems("Tiger Nixon", "Garrett Winters"),
                        "data.employee_age.max()", equalTo(66),
                        "data.min(){it.employee_age}.employee_name", equalTo("Tatyana Fitzpatrick"),
                        "data.employee_salary.sum()", equalTo(6644770)
                        );



        // Using Json Path

//        // The greatest age is 66 path of user age ["data.employee_age"]


//        int userAgeMaxValue = response.jsonPath().get("data.employee_age.max()");
//        System.out.println( "The greatest age is: " + userAgeMaxValue);
//        assertThat(userAgeMaxValue, equalTo(66));
//
//
//        // The name of the lowest age is "Tatyana Fitzpatrick"


//        int userAgeMinValue = response.jsonPath().getInt("data.employee_age.min()");
//        String nameOfLowestAge = response.jsonPath().getList("data.findAll { it.employee_age == "+userAgeMinValue+" }.employee_name").getFirst().toString();
//        System.out.println("The name of the lowest age is: " + nameOfLowestAge);
//
//        // Total salary of all employees is 6,644,770


//        int totalSalary = response.jsonPath().get("data.employee_salary.sum()");
//        System.out.println("Total salary of all employees is: " + totalSalary);
//        assertThat(totalSalary, equalTo(6644770));


    }
}
