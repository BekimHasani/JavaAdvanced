package exercises.ushtrimi1;

import java.time.LocalDateTime;

public class BusinessHoursPolicy implements Policy{

    @Override
    public boolean isPermitted(LocalDateTime date) {
        if(date.getHour() < 17){
            return true;
        }
        return false;
    }
}
