package exercises.ushtrimi1;

import java.time.LocalDateTime;

public interface Policy {
    boolean isPermitted(LocalDateTime date);
}
