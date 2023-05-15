package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataDummy {
    public int basariliStatusCode = 200;
    public String contentType = "application/json";

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
    public JSONObject reqBody() {
        JSONObject data = new JSONObject();
        data.put("name", "Leyla");
        data.put("salary", "1230");
        data.put("age", "44");
        data.put("id", 41);

        JSONObject allData = new JSONObject();
        allData.put("data", data);
        allData.put("status", "success");

        return allData;
    }

    public JSONObject expBody() {
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
        JSONObject data = new JSONObject();
        data.put("name", "Leyla");
        data.put("salary", "1230");
        data.put("age", "44");
        data.put("id", 41);


        JSONObject dataOut = new JSONObject();
        dataOut.put("status", "success");
        dataOut.put("data", data);

        JSONObject allexpData = new JSONObject();
        allexpData.put("status", "success");
        allexpData.put("data", dataOut);
        allexpData.put("message", "Successfully! Record has been updated.");
        return allexpData;
    }

    public JSONObject Data() {
        /*
        Response Body
{
"status": "success",
"data": {
   "id": 3,
    "employee_name": "Ashton Cox",
    "employee_salary": 86000,
    "employee_age": 66,
     "profile_image": ""
},
"message": "Successfully! Record has been fetched."
}*/
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 3);
        jsonObject.put("employee_name", "Ashton Cox");
        jsonObject.put("employee_salary", 86000);
        jsonObject.put("employee_age", 66);
        jsonObject.put("profile_image", "");
        return jsonObject;
    }

    public JSONObject expData() {
        JSONObject jsonOuter = new JSONObject();
        jsonOuter.put("status", "success");
        jsonOuter.put("message", "Successfully! Record has been fetched.");
        jsonOuter.put("data", Data());
        return jsonOuter;
    }

    public HashMap<String,Object> DataMap() {
        /*
        Response Body
{
"status": "success",
"data": {
   "id": 3,
    "employee_name": "Ashton Cox",
    "employee_salary": 86000,
    "employee_age": 66,
     "profile_image": ""
},
"message": "Successfully! Record has been fetched."
}*/
        HashMap<String,Object>dataMap=new HashMap<>();
        dataMap.put("id", 3.0);
        dataMap.put("employee_name", "Ashton Cox");
        dataMap.put("employee_salary", 86000.0);
        dataMap.put("employee_age", 66.0);
        dataMap.put("profile_image", "");
        return dataMap;
    }
    public HashMap<String,Object> expDataMap() {
        HashMap<String,Object>outherdataMap=new HashMap<>();
        outherdataMap.put("status", "success");
        outherdataMap.put("message", "Successfully! Record has been fetched.");
        outherdataMap.put("data",DataMap());
        return outherdataMap;
    }
}