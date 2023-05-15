package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PojoDummyExpBody {
    private  String status;
    private PojoDummyData data;//Class adini cagirdik
    private String message;
}
