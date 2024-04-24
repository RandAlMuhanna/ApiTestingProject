package assignments;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.Header;

public class RestAssuredAssign1 {

    /*
          https://reqres.in/api/users/3

          User sends a GET Request to the url

          HTTP Status Code should be 200

          Content Type should be JSON

          Status Line should be HTTP/1.1 200 OK
   */

    public static void main(String[] args) {


        // Sends a GET Request to the url
        Response response = RestAssured.get("https://reqres.in/api/users/3");
        response.prettyPrint();

        // To Check the status code = 200
        int statusCode = response.statusCode();
        System.out.println("Status Code = " + statusCode);

        // To check the content type = json
        String contentType = response.contentType();
        System.out.println("Content Type = " + contentType);

        // To check status line = HTTP/1.1 200 OK
        String statusLine = response.statusLine();
        System.out.println("Status Line = " + statusLine);


    }

}
