package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.lang.reflect.Array;

public class C08_JSONObjectVerileriCagirma {
    /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
    },
    "phoneNumbers": [
        {
            "type": "iPhone",
            "number": "0123-4567-8888"
        },
        {
            "type": "home",
            "number": "0123-4567-8910"
        }
    ]
}
     */
    @Test
    public void test01(){

        JSONObject cepTel=new JSONObject();
        cepTel.put("type", "iPhone");
        cepTel.put("number", "0535-4567-8888");

        JSONObject evTel=new JSONObject();
        evTel.put("type", "home");
        evTel.put("number", "0123-4567-5471");

        JSONArray phoneNumbers=new JSONArray();//JSon Array yaptik
        phoneNumbers.put(0,evTel);
        phoneNumbers.put(1,cepTel);

        JSONObject address=new JSONObject();
        address.put("streetAddress", "naist street");
        address.put( "city", "Nara");
        address.put("postalCode", "630-0192");

        JSONObject kisiselBilgiler=new JSONObject();
        kisiselBilgiler.put("firstName", "John");
        kisiselBilgiler.put("lastName", "doe");
        kisiselBilgiler.put("age", 26);
        kisiselBilgiler.put("address",address);
        kisiselBilgiler.put("phoneNumbers",phoneNumbers);
        /*kisiselBilgiler.put("firstName","John").put("lastName","doe").put("age",26)
                .put("address",address).put("phoneNumbers",phoneNumbers);*/  //seklinde de yazabilirdik

        System.out.println(kisiselBilgiler);
        /*
        {
        "firstName":"John",
        "lastName":"doe",
        "address":{
             "streetAddress":"naist street",
             "city":"Nara","postalCode":"630-0192"},
        "age":26,
        "phoneNumbers":[
        {
             "number":"0123-4567-8888",
             "type":"iPhone"},
        {
              "number":"0123-4567-5471",
              "type":"home"
              }
              ]
         }

         */


        System.out.println("Isim : " + kisiselBilgiler.get("firstName"));
        System.out.println("Soy Isim : " + kisiselBilgiler.get("lastName"));
        System.out.println("Age : " + kisiselBilgiler.get("age"));
        System.out.println("Isim : " + kisiselBilgiler.getJSONObject("address").get("streetAddress"));
        System.out.println(kisiselBilgiler.getJSONObject("address").get("postalCode"));
        System.out.println(kisiselBilgiler.getJSONObject("address").get("city"));

        System.out.println(kisiselBilgiler.getJSONArray("phoneNumbers").getJSONObject(0).get("type"));
        System.out.println(kisiselBilgiler.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
        System.out.println(kisiselBilgiler.getJSONArray("phoneNumbers").getJSONObject(1).get("type"));
        System.out.println(kisiselBilgiler.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));
    }
}
