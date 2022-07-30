package co.com.poli.bookings.repositories;

import co.com.poli.bookings.entities.Booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    Booking save(Booking user);
    void deleteById(Long id);
    List<Booking> findAll();


}
