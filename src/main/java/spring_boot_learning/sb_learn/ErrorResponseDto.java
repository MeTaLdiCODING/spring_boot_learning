package spring_boot_learning.sb_learn;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ErrorResponseDto(
        String message,
        String detailedMessage,
        LocalDateTime errorTime

) {
}
