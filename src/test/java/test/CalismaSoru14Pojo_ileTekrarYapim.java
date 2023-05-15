package test;

import baseURL.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoDummyDataPut;
import pojos.PojoDummyExpDataPut;
import pojos.PojoDummyOutherExpData;
import pojos.PojoDummyReqBodyPut;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CalismaSoru14Pojo_ileTekrarYapim extends DummyBaseUrl {
    /*
    C14_Post_SoftAssertIleExpectedDataTesti
//https://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir POST
request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
Request Body
{
"status": "success",
"data": {
     "name": “Leyla",
     "salary": "1230",
      "age": "44",
      "id": 41
}
}
Response Body
{
    "status": "success",
    "data": {
        "data": {
            "name": "Leyla",
            "id": 41,
            "salary": "1230",
            "age": "44"
        },
        "status": "success",
        "id": 3787
    },
    "message": "Successfully! Record has been updated."
}
     */
    @Test
    public void post01(){
        //Url ve body olustur
        specDummyBase.pathParams("pp1","api","pp2","v1","pp3","update","pp4",21);
        PojoDummyDataPut dummyDataPut=new PojoDummyDataPut("Sevgi","50000","40",41);
        PojoDummyReqBodyPut reqBody=new PojoDummyReqBodyPut("success",dummyDataPut);
        //Expected Data olustur
        PojoDummyOutherExpData outher=new PojoDummyOutherExpData("success",dummyDataPut);
        PojoDummyExpDataPut expData=new PojoDummyExpDataPut("success",outher,"Successfully! Record has been updated.");
        System.out.println(expData);
        //Response kaydet
        Response response=given().spec(specDummyBase).contentType(ContentType.JSON).body(reqBody).put("/{pp1}/{pp2}/{pp3}/{pp4}");
        response.prettyPeek();
        //Assertion yap
        PojoDummyExpDataPut respBody = response.as(PojoDummyExpDataPut.class);
        System.out.println(respBody);
        assertEquals(expData.getStatus(),respBody.getStatus());
        assertEquals(expData.getMessage(),respBody.getMessage());
        assertEquals(expData.getData().getStatus(),expData.getData().getStatus());
        assertEquals(expData.getData().getData().getName(),respBody.getData().getData().getName());
        assertEquals(expData.getData().getData().getSalary(),respBody.getData().getData().getSalary());
        assertEquals(expData.getData().getData().getAge(),respBody.getData().getData().getAge());
        assertEquals(expData.getData().getData().getId(),respBody.getData().getData().getId());


    }
}
