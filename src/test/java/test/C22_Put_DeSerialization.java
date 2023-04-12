package test;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJasonPlaceHolder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_Put_DeSerialization extends JsonPlaceHolderBaseURL {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
    body’e sahip bir PUT request yolladigimizda donen response’in
    response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Expected Data :
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */
    @Test
    public void put01(){
        //url ve request body hazirla
        specJsonPlace.pathParams("pp1","posts","pp2",70);
        TestDataJasonPlaceHolder testDataJasonPlaceHolder=new TestDataJasonPlaceHolder();
        HashMap <String,Object> reqBody= testDataJasonPlaceHolder.reqBodyOlusturMap();
        //Expected Data hazirla
        HashMap <String,Object> expBody= testDataJasonPlaceHolder.reqBodyOlusturMap();
        Response response=given()
                .spec(specJsonPlace)
                .contentType(ContentType.JSON)
                .body(reqBody).put("/{pp1}/{pp2}");//map oldugu icin toString yapmadik
        response.prettyPeek();

        //Assertion
        HashMap <String,Object>respMap = response.as(HashMap.class);//responsemizi JasonPathe degilHashMap e cevirdik yani de-serialization yaptik
        assertEquals(testDataJasonPlaceHolder.basariliStatusCode,response.getStatusCode());
        assertEquals(expBody.get("id"),respMap.get("id"));
        assertEquals(expBody.get("title"),respMap.get("title"));
        assertEquals(expBody.get("body"),respMap.get("body"));
        assertEquals(expBody.get("userId"),respMap.get("userId"));//map int ifadeleri double olarak doner bu nedenle 70.0 seklinde yazdik Map e

    }

}
