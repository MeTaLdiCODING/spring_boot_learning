package spring_boot_learning.sb_learn;

import java.time.LocalDate;
import jakarta.validation.constraints.*;

public record Reservation(
       @Null
        Long id,
        @NotNull
        Long userId,
        @NotNull
        Long roomId,
        @FutureOrPresent
        @NotNull
        LocalDate startDate,
        @FutureOrPresent
        @NotNull
        LocalDate endDate,
        ReservationStatus status
) {
}
