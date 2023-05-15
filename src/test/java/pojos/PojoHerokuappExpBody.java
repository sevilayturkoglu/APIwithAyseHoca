package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PojoHerokuappExpBody {

    private int bookingid;
    private PojoHerokuAppBooking booking;//Class adini cagirdik

}

