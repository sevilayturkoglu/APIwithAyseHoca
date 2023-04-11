package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class C07_Get_BodyTekrarlardanKurtulma {
    /*
                https://restful-booker.herokuapp.com/booking/10 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                   {
    "firstname": "Jim",
    "lastname": "Wilson",
    "totalprice": 609,
    "depositpaid": false,
   "additionalneeds": "Breakfast"
}
                oldugunu test edin
         */

    @Test
    public void test(){
        //url hazirla
        String url="https://restful-booker.herokuapp.com/booking/10";
        //Expected data

      Response response=given().when().get(url);
      response.prettyPrint();
      /*  response.then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200).body("firstname", Matchers.equalTo("Ayse hoca"),
                        "lastname",Matchers.equalTo("cok yasa"),
                        "totalprice",Matchers.equalTo(99),
                        "depositpaid",Matchers.equalTo(true),
                        "additionalsneeds",Matchers.nullValue());*/

       //kisa yol
              response.then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200).body("firstname", equalTo("James"),
                        "lastname",Matchers.equalTo("Brown"),
                        "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "additionalsneeds",equalTo(""));

    }
}
