package baseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class UsersBaseUrl {



    protected RequestSpecification spec ;

    @BeforeMethod
    public void setUp(){

        spec = new RequestSpecBuilder()
                .setBaseUri(" https://reqres.in/api")
                .build();

    }
}
