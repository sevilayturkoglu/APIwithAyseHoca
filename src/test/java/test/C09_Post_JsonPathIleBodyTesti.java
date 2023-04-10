package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C09_Post_JsonPathIleBodyTesti {
    /*
            https://restful-booker.herokuapp.com/booking
             url’ine asagidaki body'ye sahip
            bir POST request gonderdigimizde
                       {
                            "firstname" : "Veli",
                            "lastname" : "Bak",
                            "totalprice" : 500,
                            "depositpaid" : false,
                            "bookingdates" : {
                                            "checkin" : "2021-06-01",
                                            "checkout" : "2021-06-10"
                                             },
                            "additionalneeds" : "wi-fi"
                        }
            donen Response’un,
            status code’unun 200,
            ve content type’inin application-json,
            ve response body’sindeki
                "firstname“in,"Ali",
                ve "lastname“in, "Bak",
                ve "totalprice“in,500,
                ve "depositpaid“in,false,
                ve "checkin" tarihinin 2021-06-01
                ve "checkout" tarihinin 2021-06-10
                ve "additionalneeds“in,"wi-fi"
            oldugunu test edin
     */
    @Test
    public void postJsonPath(){
        //url hazirla ve request body hazirla
        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin" , "2021-06-01");
        bookingDates.put("checkout" , "2021-06-10");

        JSONObject requestBody=new JSONObject();
        requestBody.put( "firstname" , "Veli");
        requestBody.put("lastname" , "Bak");
        requestBody.put("totalprice" , 500);
        requestBody.put("depositpaid" , false);
        requestBody.put("bookingdates",bookingDates);
        requestBody.put("additionalneeds" , "wi-fi");

        Response response=given()
                              .contentType(ContentType.JSON)
                          .when()
                              .body(requestBody.toString())
                              .post(url);
        response.prettyPrint();
       response.then()
                 .assertThat()
                 .statusCode(200)
                 .contentType("application/json; charset=utf-8")
                 .body("booking.firstname", equalTo("Veli"),
                        "booking.lastname",equalTo("Bak"),
                         "booking.totalprice",equalTo(500),
                         "booking.depositpaid",equalTo(false),
                                "booking.bookingdates.checkin",equalTo("2021-06-01"),
                                "booking.bookingdates.checkout",equalTo("2021-06-10"),
                                "booking.additionalneeds",equalTo("wi-fi"));

       //https://jsonpath.com/  bu adres ile response body path  donuslerini kontrol edebilirsin
    }
}
