package base;

import io.cucumber.java.Before;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestContext {
    public RequestSpecification request;
    public Response response;
    @Before
    public void setup(){
        response=null;
        request=null;
    }
}
