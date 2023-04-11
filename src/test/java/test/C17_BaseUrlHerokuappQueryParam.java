package test;

import baseURL.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

public class C17_BaseUrlHerokuappQueryParam extends HerokuAppBaseUrl {
// Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
    /*
        1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
        request gonderdigimizde donen response’un status code’unun 200 oldugunu
        ve Response’ta 33071 id'ye sahip bir booking oldugunu test edin
     */
     /*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response’un
        status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin
    */
    /*
        3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
         parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri
         “Jackson” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
         donen response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip
         en az bir booking oldugunu test edin.
    */

    @Test
    public void get01(){
/*
        1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
        request gonderdigimizde donen response’un status code’unun 200 oldugunu
        ve Response’ta 17 id'ye sahip bir booking oldugunu test edin
     */
        //Url hazirla
        specHerokuApp.pathParam("pp1","booking");
        //Expected Data hazirla
        //Responseyi kaydet
        Response response=given().spec(specHerokuApp).when().get("/{pp1}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("bookingid", hasItem(17));

    }
    @Test
    public void get02(){
 /*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response’un
        status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin
    */
        //Url Hazirla
        //path parametreleri                              //Query Parametreleri
        specHerokuApp.pathParam("a","booking").queryParam("firstname","Eric");

        Response response=given().spec(specHerokuApp).when().get("/{a}");
        response.prettyPrint();
//Assertion
        response.then().assertThat().statusCode(200).body("bookingid",Matchers.hasSize(2));

    }
    @Test
    public void get03(){
/*
      3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
         parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri
         “Jackson” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
         donen response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip
         en az bir booking oldugunu test edin.
    */
        //url hazirla
        specHerokuApp
                .pathParam("pp1","booking")
                .queryParams("firstname","Jim","lastname","Jackson");
        //response kaydet
        Response response=given().spec(specHerokuApp).when().get("/{pp1}");
        response.prettyPrint();

        //Assertion
        response.then().assertThat().statusCode(200).body("booking",Matchers.hasSize(1));

    }
}
