package test;

import baseURL.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.Test;
import pojos.PojoHerokuAppBooking;
import pojos.PojoHerokuappBookingDates;
import pojos.PojoHerokuappExpBody;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C26_Post_Pojo extends HerokuAppBaseUrl {
    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ali",
                        "lastname" : “Bak",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body = Expected Data
                        {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ali",
                        "lastname":"Bak",
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
    public void post01(){
        //url ve body hazirla
       specHerokuApp.pathParam("pp1","booking");
        PojoHerokuappBookingDates bookingDates=new PojoHerokuappBookingDates("2021-06-01","2021-06-10");
        PojoHerokuAppBooking reqBody=new PojoHerokuAppBooking("Ali","Bak",500,false,bookingDates,"wi-fi");
        //Expected body hazirla
        PojoHerokuappExpBody expBody=new PojoHerokuappExpBody(24,reqBody);
        //Responseyi kaydet
        Response response=given().spec(specHerokuApp).contentType(ContentType.JSON).when().body(reqBody).post("/{pp1}");
        response.prettyPeek();

        PojoHerokuappExpBody resPojo = response.as(PojoHerokuappExpBody.class);

        assertEquals(expBody.getBooking().getFirstname(),resPojo.getBooking().getFirstname());
        assertEquals(expBody.getBooking().getLastname(),resPojo.getBooking().getLastname());
        assertEquals(expBody.getBooking().getTotalprice(),resPojo.getBooking().getTotalprice());
        assertEquals(expBody.getBooking().isDepositpaid(),resPojo.getBooking().isDepositpaid());
        assertEquals(expBody.getBooking().getAdditionalneeds(),resPojo.getBooking().getAdditionalneeds());
        assertEquals(expBody.getBooking().getBookingdates().getCheckin(),resPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expBody.getBooking().getBookingdates().getCheckout(),resPojo.getBooking().getBookingdates().getCheckout());


    }
}
