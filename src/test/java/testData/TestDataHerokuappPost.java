package testData;

import org.json.JSONObject;

public class TestDataHerokuappPost {
    public int basariliStatusCode = 200;


    public JSONObject reqdBodyOlusturJson() {

       /*
    "bookingid": 13453,
    "booking": {
        "firstname": "Selda",
        "lastname": "Bagcan",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
    }
                */
        //Url Requestbody hazirla

        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2021-06-01");
        bookingdates.put("checkout", "2021-06-10");

        JSONObject personality = new JSONObject();
        personality.put("firstname", "Selda");
        personality.put("lastname", "Bagcan");
        personality.put("totalprice", 500);
        personality.put("depositpaid", false);
        personality.put("bookingdates", bookingdates);
        personality.put("additionalneeds", "wi-fi");
        return personality;

    }

    public JSONObject expectedBodyOlusturJson() {
       JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2021-06-01");
        bookingdates.put("checkout", "2021-06-10");

        JSONObject personality = new JSONObject();
        personality.put("firstname", "Selda");
        personality.put("lastname", "Bagcan");
        personality.put("totalprice", 500);
        personality.put("depositpaid", false);
        personality.put("bookingdates", bookingdates);
        personality.put("additionalneeds", "wi-fi");

        JSONObject expectedData = new JSONObject();
        // expectedData.put("bookingid", 13453);
        expectedData.put("booking", personality);
       return  expectedData;
    }
}