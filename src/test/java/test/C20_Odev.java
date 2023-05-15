package test;

import baseURL.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataDummy;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C20_Odev extends DummyBaseUrl {
    /*
    C20_Get_TestDataKullanimi
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
} */
    @Test
    public  void get01(){
        TestDataDummy dummy=new TestDataDummy();
        specDummyBase.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);
        JSONObject expBody=dummy.expData();
        Response response=given().spec(specDummyBase).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");
        response.prettyPeek();
        JsonPath respPath = response.jsonPath();
        assertEquals(dummy.basariliStatusCode,response.statusCode());
       assertEquals(dummy.contentType,response.contentType());
       assertEquals(expBody.get("status"),respPath.get("status"));
       assertEquals(expBody.get("message"),respPath.get("message"));
       assertEquals(expBody.getJSONObject("data").get("id"),respPath.get("data.id"));
       assertEquals(expBody.getJSONObject("data").get("employee_name"),respPath.get("data.employee_name"));
       assertEquals(expBody.getJSONObject("data").get("employee_salary"),respPath.get("data.employee_salary"));
       assertEquals(expBody.getJSONObject("data").get("employee_age"),respPath.get("data.employee_age"));
       assertEquals(expBody.getJSONObject("data").get("profile_image"),respPath.get("data.profile_image"));
    }
}
