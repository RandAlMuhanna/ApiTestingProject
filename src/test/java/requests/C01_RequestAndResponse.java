package requests;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class C01_RequestAndResponse {

    public static void main(String[] args) {


        // Using RestAssured to send request and get response
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();

        // To Check the status code = 200
        int statusCode = response.statusCode();
        System.out.println("response = " + statusCode);

        // To check the content type = json
        String contentType = response.contentType();
        System.out.println("response = " + contentType);

        // To check status line = HTTP/1.1 200 OK
        String statusLine = response.statusLine();
        System.out.println("response = " + statusLine);


        // Print connections
        String connections = response.header("Connection");
        System.out.println("\nConnection = " + connections);

        // Print Headers
        Headers headers = response.headers();
        System.out.println("\nHeaders = " + headers);

    }
}
