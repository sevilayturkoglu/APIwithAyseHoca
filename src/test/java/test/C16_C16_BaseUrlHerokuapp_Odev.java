package test;

import baseURL.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;

import org.junit.Test;
import testData.TestDataHerokuappPost;
import testData.TestDataJasonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C16_C16_BaseUrlHerokuapp_Odev extends HerokuAppBaseUrl {
   /*
   C16_BaseUrlHerokuapp
Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin
1- https://restful-booker.herokuapp.com/booking endpointine bir GET request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve
Response’ta 12 booking oldugunu test edin
{
"firstname" : "Ahmet",
"lastname" : “Bulut",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" : {
"checkin" : "2021-06-01",
"checkout" : "2021-06-10"
},
"additionalneeds" : "wi-fi"
}
2- https://restful-booker.herokuapp.com/booking
endpointine asagidaki body’ye sahip bir POST
request gonderdigimizde donen response’un
status code’unun 200 oldugunu ve “firstname”
degerinin “Ahmet” oldugunu test edin
      */
    @Test
    public void get(){
       /* Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin
        1- https://restful-booker.herokuapp.com/booking endpointine bir GET request
        gonderdigimizde donen response’un status code’unun 200 oldugunu ve
        Response’ta 12 booking oldugunu test edin
        {
            "firstname" : "Ahmet",
                "lastname" : “Bulut",
            "totalprice" : 500,
                "depositpaid" : false,
                "bookingdates" : {
            "checkin" : "2021-06-01",
                    "checkout" : "2021-06-10"
        },
            "additionalneeds" : "wi-fi"
        }*/
       // specHerokuApp.pathParam("pp1","booking");
       // Response response=given().spec(specHerokuApp).when().get("/{pp1}");
        Response response=given().when().get("/booking");//bunu ben yaptim
       response.prettyPrint();
       // response.prettyPeek();
        TestDataJasonPlaceHolder status=new TestDataJasonPlaceHolder();
        response.then().assertThat().statusCode(status.basariliStatusCode).body("bookingid", Matchers.hasItems(12));
    }
    @Test
    public void get1(){
       /* 2- https://restful-booker.herokuapp.com/booking
        endpointine asagidaki body’ye sahip bir POST
        request gonderdigimizde donen response’un
        status code’unun 200 oldugunu ve “firstname”
        degerinin “Selda” oldugunu test edin

         {
                "firstname" : "Selda",
                "lastname" : “Bulut",
               "totalprice" : 500,
                "depositpaid" : false,
                "bookingdates" : {
                    "checkin" : "2021-06-01",
                    "checkout" : "2021-06-10"
        },
              "additionalneeds" : "wi-fi"
        }
                */
        //Url Requestbody hazirla
        specHerokuApp.pathParam("pp1","booking");
        TestDataHerokuappPost hero=new TestDataHerokuappPost();
        //request body hazirla
        JSONObject reqBody=hero.reqdBodyOlusturJson();

        //expected body hazirla
        JSONObject expBody=hero.expectedBodyOlusturJson();
        System.out.println(expBody);

        //responseyi kaydet
        Response response=given().spec(specHerokuApp).contentType(ContentType.JSON).body(reqBody.toString()).post("/{pp1}");
        response.prettyPeek();

        //responseyi body elemanlarina get ile ulasmak icin JSpath e cevir
        JsonPath actualData = response.jsonPath();
     //expected data ve actual datayi karsilastir
       assertEquals(200,response.statusCode());
       assertEquals(expBody.getJSONObject("booking").get("firstname"),actualData.get("booking.firstname"));

 response
        .then()
        .assertThat().statusCode(200)
        .body("booking.firstname",Matchers.equalTo("Selda"));
    }
}
