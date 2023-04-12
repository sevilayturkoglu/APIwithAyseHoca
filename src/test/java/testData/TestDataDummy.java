package testData;

import org.json.JSONObject;

public class TestDataDummy {
    public int basariliStatusCode = 200;
    /*
    Request Body
{
"status": "success",
"data": {
     "name": "Leyla",
     "salary": "1230",
      "age": "44",
      "id": 41
}
}
     */
    public JSONObject reqBody(){
        JSONObject data=new JSONObject();
        data.put( "name", "Leyla");
        data.put("salary", "1230");
        data.put("age", "44");
        data.put("id", 41);

        JSONObject allData=new JSONObject();
        allData.put("data", data);
        allData.put("status", "success");

        return  allData;
    }

    public JSONObject expBody(){
        /*
    {
    "status": "success",
    "data": {
        "data": {
            "name": "Leyla",
            "id": 41,
            "salary": "1230",
            "age": "44"
        },
        "status": "success",
        "id": 1198
    },
    "message": "Successfully! Record has been updated."
}
         */
        JSONObject data=new JSONObject();
        data.put( "name", "Leyla");
        data.put("salary", "1230");
        data.put("age", "44");
        data.put("id", 41);


        JSONObject dataOut=new JSONObject();
        dataOut.put("status", "success");
        dataOut.put("data", data);

        JSONObject allexpData=new JSONObject();
        allexpData.put("status", "success");
        allexpData.put("data", dataOut);
        allexpData.put("message","Successfully! Record has been updated.");
        return  allexpData;
    }
}
