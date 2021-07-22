package exercises.ushtrimi1;

import java.time.LocalDateTime;

public class RestictedDaysPolicy implements Policy {

    @Override
    public boolean isPermitted(LocalDateTime date) {
        int dayInNum = date.getDayOfWeek().getValue();
        if (dayInNum == 1 || dayInNum == 6 || dayInNum == 7){
            return false;
        }
        return true;
    }
}
