package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PojoDummyReqBodyPut {
    /* Request Body
    {
        "status": "success",
         "data": {
              "name": “Leyla",
              "salary": "1230",
              "age": "44",
              "id": 41
    }
    }*/
    private String status;
    private PojoDummyDataPut data;
}
