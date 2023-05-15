package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PojoDummyDataPut {
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
    private String name;
    private String salary;
    private String age;
    private int id;
}
