package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C11_Get_ExpectedDataOlusturma {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine
    bir GET request yolladigimizda donen response body’sinin
    asagida verilen ile ayni oldugunu test ediniz
   Response body :
    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":""body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */
    @Test
    public void get01(){
        //url hazirla
        String url="https://jsonplaceholder.typicode.com/posts/22";
        Response response=given().when().get(url);
        response.prettyPrint();


        //Expected body hazirla
        JSONObject expBody=new JSONObject();
        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        //Assertion yap
        //Onemli : donen responsenin bodysine ulasmak icin responseyi JsonPath objesine cevirmeliyiz
        JsonPath resJSPath = response.jsonPath();
        assertEquals(expBody.get("userId"),resJSPath.get("userId"));
        assertEquals(expBody.get("id"),resJSPath.get("id"));
        assertEquals(expBody.get("title"),resJSPath.get("title"));
        assertEquals(expBody.get("body"),resJSPath.get("body"));

    }
}
