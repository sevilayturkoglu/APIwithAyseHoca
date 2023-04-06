package test;

import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class C03_JsonObjesiOlusturma {
    /*
   Asagidaki JSON Objesini olusturup konsolda yazdirin.
   {
       "title":"Ahmet",
       "body":"Merhaba",
       "userId":1
   }
   */
    @Test
    public void jsonObje1() {
        JSONObject ilkJsonObje = new JSONObject();
        ilkJsonObje.put("title", "Ahmet");
        ilkJsonObje.put("body", "Merhaba");
        ilkJsonObje.put("userId", 1);
        System.out.println(ilkJsonObje);


//Bunu ben yaptim Json yerine map e attim
    Map<String,Object> dene=new HashMap<>();
    dene.put("title","Ahmet");
    dene.put("body","Merhaba");
    dene.put("userId",1);
    System.out.println(dene);
    }


    /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */
    @Test
    public void jsonObje2() {
        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2019-01-01");


        JSONObject outerJson = new JSONObject();
        outerJson.put("firstname","Jim");
        outerJson.put("additionalneeds","Breakfast");
        outerJson.put("bookingdates",bookingDates);
        outerJson.put("totalprice",111);
        outerJson.put("depositpaid",true);
        outerJson.put("lastname","Brown");

        System.out.println(outerJson);

     /*   {"firstname":"Jim",
           "additionalneeds":"Breakfast",
           "bookingdates":{
                    "checkin":"2018-01-01",
                    "checkout":"2019-01-01"
        },
           "totalprice":111,
           "depositpaid":true,
           "lastname":"Brown"}

            */
    }
}