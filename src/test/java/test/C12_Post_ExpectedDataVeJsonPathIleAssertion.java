package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {
/*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body
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
                        Response Body--Expected body
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
        */
@Test
    public void postReq(){
    //url ve Request body hazirla
    String url="https://restful-booker.herokuapp.com/booking";
    JSONObject bookingdates=new JSONObject();
    bookingdates.put("checkin","2021-06-01");
    bookingdates.put("checkout","2021-06-10");

    JSONObject reqBody=new JSONObject();
    reqBody.put("firstname","Ahmet");
    reqBody.put("lastname","Bulut");
    reqBody.put("totalprice" , 500);
    reqBody.put("depositpaid",false);
    reqBody.put("bookingdates",bookingdates);
    reqBody.put("additionalneeds","wi-fi");


    //Expected data hazirla

JSONObject expBody=new JSONObject();
expBody.put("bookingid",24);
expBody.put("booking",reqBody);

//Response kaydet
    Response response=given()
            .contentType(ContentType.JSON)
            .body(reqBody.toString()).when()
            .post(url);
response.prettyPrint();


//Assertion
    JsonPath respJSPath = response.jsonPath();

    assertEquals(expBody.getJSONObject("booking").get("firstname"),respJSPath.get("booking.firstname"));
    assertEquals(expBody.getJSONObject("booking").get("lastname"),respJSPath.get("booking.lastname"));
    assertEquals(expBody.getJSONObject("booking").get("totalprice"),respJSPath.get("booking.totalprice"));
    assertEquals(expBody.getJSONObject("booking").get("depositpaid"),respJSPath.get("booking.depositpaid"));
    assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),respJSPath.get("booking.additionalneeds"));
    assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates")
                          .get("checkin"),respJSPath.get("booking.bookingdates.checkin"));
    assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates")
                          .get("checkout"),respJSPath.get("booking.bookingdates.checkout"));
}
}
