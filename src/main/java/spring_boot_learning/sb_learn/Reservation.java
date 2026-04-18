package spring_boot_learning.sb_learn;

import java.time.LocalDate;

public record Reservation(
        long id,
        long userId,
        long roomId,
        LocalDate startDate,
        LocalDate endDate,
        ReservationStatus status
) {
}
