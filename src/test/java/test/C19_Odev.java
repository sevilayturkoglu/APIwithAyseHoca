package test;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJasonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C19_Odev extends JsonPlaceHolderBaseURL {
    /*
    C19_Put_TestDataClassKullanimi
https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir
PUT request yolladigimizda donen response’in
status kodunun 200, content type’inin “application/json; charset=utf-8”,
Connection header degerinin “keep-alive”
ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
TEST DATA CLASS KULLANIMI
Expected Data :
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
Request Body
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
} */
    @Test
    public void put01(){
        TestDataJasonPlaceHolder testDataJasonPlaceHolder=new TestDataJasonPlaceHolder();
        specJsonPlace.pathParams("pp1","posts","pp2",70);
        JSONObject reqBody=testDataJasonPlaceHolder.reqBodyOlusturJson();
        System.out.println(reqBody.toString());
        JSONObject expBody=testDataJasonPlaceHolder.reqBodyOlusturJson();
        Response response=given().spec(specJsonPlace).contentType(ContentType.JSON).body(reqBody.toString()).when().put("/{pp1}/{pp2}");
        response.prettyPeek();
        JsonPath respPath = response.jsonPath();
        assertEquals(testDataJasonPlaceHolder.basariliStatusCode,response.statusCode());
        assertEquals(testDataJasonPlaceHolder.contentType,response.contentType());
        assertTrue(response.header("Connection").equals(testDataJasonPlaceHolder.ConnectionHeader));
        assertEquals(expBody.get("title"),respPath.get("title"));
        assertEquals(expBody.get("body"),respPath.get("body"));
        assertEquals(expBody.get("userId"),respPath.get("userId"));
        assertEquals(expBody.get("id"),respPath.get("id"));

    }
}
