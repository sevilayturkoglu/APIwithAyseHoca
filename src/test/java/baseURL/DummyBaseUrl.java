package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyBaseUrl {

   protected RequestSpecification specDummyBase;


    @Before
    public  void setup(){
        specDummyBase=new RequestSpecBuilder().setBaseUri("https://dummy.restapiexample.com").build();
    }
}
