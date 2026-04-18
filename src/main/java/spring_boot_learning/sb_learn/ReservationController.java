package spring_boot_learning.sb_learn;

import org.apache.juli.logging.Log;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class ReservationController {

private static final Logger log = (Logger) LoggerFactory.getLogger(ReservationController.class);

    public final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(
           @PathVariable("id") Long id
    ){
       log.info("Called getReservationById: id= "+id);
        return  reservationService.getReservationById(id);
    }

    @GetMapping()
    public List<Reservation> getAllReservation() {
        log.info("Called getAllReservation");
        return reservationService.findAllReservations();
    }

}
