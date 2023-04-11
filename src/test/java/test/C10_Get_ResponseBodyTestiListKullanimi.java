package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_Get_ResponseBodyTestiListKullanimi {
    /*
            http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request yolladigimizda
            donen Response'in
            status code'unun 200,
            ve content type'inin application/json,
            ve response body'sindeki
                employees sayisinin 24
                ve employee'lerden birinin "Ashton Cox"
                ve girilen yaslar icinde 61,40 ve 30 degerlerinin oldugunu test edin
            test edin.
     */
    @Test
    public void get01(){
        //url hazirla
        String url="http://dummy.restapiexample.com/api/v1/employees";
        //Expected data hazirla
        //Response yi kaydet
        Response response=given().when().get(url);
        response.prettyPrint();

        //https://jsonpath.com/  bu adres ile response body path  donuslerini kontrol edebilirsin

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON).body(
                             "data.id", hasSize(24),
                        "data.employee_name",hasItem("Bradley Greer"),
                                "data.employee_age",hasItems(61,43,30),
                                "status",containsString("success"));
    }

}
