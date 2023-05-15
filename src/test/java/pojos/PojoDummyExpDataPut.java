package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PojoDummyExpDataPut {
    /*
    Response Body
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
        "id": 3787
    },
    "message": "Successfully! Record has been updated."
} */
    private String status;
    private PojoDummyOutherExpData data;
    private String message;

}
