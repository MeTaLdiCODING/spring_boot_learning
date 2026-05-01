package spring_boot_learning.sb_learn;

import org.slf4j.Logger;          // ← правильный импорт
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private static final Logger log = LoggerFactory.getLogger(ReservationController.class);

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") Long id) {
        log.info("Called getReservationById: id={}", id);
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(reservationService.getReservationById(id));
        }catch (NoSuchElementException e){
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservation() {
        log.info("Called getAllReservation");
        return ResponseEntity
                .ok(reservationService.findAllReservations());
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(
            @RequestBody Reservation reservationToCreate) {
        log.info("Called createReservation");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(reservationService.createReservation(reservationToCreate));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(
            @PathVariable("id") Long id,
             @RequestBody Reservation reservationToUpdate) {
        log.info("Called updateReservation: id={}, reservationToUpdate={}", id, reservationToUpdate);
        var updated = reservationService.updateReservation(id,reservationToUpdate);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(
            @PathVariable("id") Long id) {
        log.info("Called deletedReservation: id={}", id);

        try {
            reservationService.deleteReservation(id);
            return ResponseEntity.ok().build();
        }catch (NoSuchElementException e){
            return ResponseEntity.status(404).build();
        }

    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<Reservation> approveReservation(
            @PathVariable("id") long id
            ){
        log.info("Called approveReservation: id={}", id);
        var reservation = reservationService.approveReservation(id);
        return ResponseEntity.ok(reservation);

    }


}