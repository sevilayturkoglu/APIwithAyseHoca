package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class C01_Get_ApiSorgulama {
    /*
     https://restful-booker.herokuapp.com/booking/9856 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
     */
    @Test
    public void get01(){
        //1-Gonderecegimiz request icin gerekli URL ve ihtiyac varsa gerekli request body yi hazirla
        String url="https://restful-booker.herokuapp.com/booking/10";
        //2-Eger soruda verilmisse Expected datayi hazirla
        //3-Bize donen Response yi actual data olarak kayit et
        Response response=given().when().get(url);

         response.prettyPrint();//bununla sonucu yazdirdik

        System.out.println("Status Code: "+response.getStatusCode());
        System.out.println("Content Type: "+response.getContentType());
        System.out.println(("Server Header degeri: "+response.getHeader("Server")));
        System.out.println("Status Line: "+response.getStatusLine());
        System.out.println("Response Suresi: "+response.getTime());

//4-Assertion
    }

}