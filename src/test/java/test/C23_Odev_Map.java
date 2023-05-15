package test;

import baseURL.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import testData.TestDataDummy;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C23_Odev_Map extends DummyBaseUrl {
    /* C23_Get_DeSerialization
     http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
     gonderdigimizde donen response’un status code’unun 200, content Type’inin
     application/json ve body’sinin asagidaki gibi oldugunu test edin.
     Response Body
     {
         "status": "success",
             "data": {
         "id": 3,
                 "employee_name": "Ashton Cox",
                 "employee_salary": 86000,
                 "employee_age": 66,
                 "profile_image": ""
     },
         "message": "Successfully! Record has been fetched."
     }*/
    @Test
    public void get01() {
        TestDataDummy dummy = new TestDataDummy();
        specDummyBase.pathParams("pp1", "api", "pp2", "v1", "pp3", "employee", "pp4", 3);

        HashMap<String,Object>expData = dummy.expDataMap();

        Response response = given().spec(specDummyBase).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");

        response.prettyPeek();

        HashMap <String,Object>respMap = response.as(HashMap.class);

        assertEquals(dummy.basariliStatusCode,response.statusCode());
        assertEquals(dummy.contentType,response.contentType());
        assertEquals(expData.get("status"),respMap.get("status"));
        assertEquals(expData.get("message"),respMap.get("message"));
        assertEquals(((Map)(expData.get("data"))).get("id"),((Map)(respMap.get("data"))).get("id"));
        assertEquals(((Map)(expData.get("data"))).get("employee_name"),((Map)(respMap.get("data"))).get("employee_name"));
        assertEquals(((Map)(expData.get("data"))).get("employee_salary"),((Map)(respMap.get("data"))).get("employee_salary"));
        assertEquals(((Map)(expData.get("data"))).get("employee_age"),((Map)(respMap.get("data"))).get("employee_age"));
        assertEquals(((Map)(expData.get("data"))).get("profile_image"),((Map)(respMap.get("data"))).get("profile_image"));


    }
}