package spring_boot_learning.sb_learn;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity,Long> {

}
