package test;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.JsonPlaceHolderReqBodyPojo;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_PojoClass extends JsonPlaceHolderBaseURL {

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
    Expected Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */
    @Test
    public void put01(){
        //Url ve body hazirla
        specJsonPlace.pathParams("pp1","posts","pp2",70);
        JsonPlaceHolderReqBodyPojo reqBody=new JsonPlaceHolderReqBodyPojo("Ahmet","Merhaba",10,70);
        System.out.println(reqBody.toString());
     //ExpectedBody olustur
        JsonPlaceHolderReqBodyPojo expBody=new JsonPlaceHolderReqBodyPojo("Ahmet","Merhaba",10,70);
        //Responseyi kaydet
Response response=given()
        .spec(specJsonPlace)
        .contentType(ContentType.JSON)
        .when()
        .body(reqBody)//toString yapmadik cunki zaten cons sayfasinda to string methodu yaptik,ayrica jason degil java degerleri girdik
        .put("/{pp1}/{pp2}");
response.prettyPrint();
//Assertion
        JsonPath jsonPath = response.jsonPath();//Json da donusturduk
        HashMap <String,Object>as = response.as(HashMap.class);//Map te yapiyoruz
        JsonPlaceHolderReqBodyPojo resPojo = response.as(JsonPlaceHolderReqBodyPojo.class);//responsemizi hazirladigimiz constructor yardimi ile objemize donusturduk

        assertEquals(expBody.getTitle(),resPojo.getTitle());
        assertEquals(expBody.getBody(),resPojo.getBody());
        assertEquals(expBody.getId(),resPojo.getId());
        assertEquals(expBody.getUserId(),resPojo.getUserId());

    }
}
