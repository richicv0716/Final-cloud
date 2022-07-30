package co.com.poli.bookings.services;

import co.com.poli.bookings.entities.Booking;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {

    ResponseEntity<Booking> save(Booking booking);
    List<Booking> findAll();
    ResponseEntity<Booking> delete(Long id);
    void deleteById(Long id);
    ResponseEntity<Booking>findById(Long id);
    List<Booking> findByUserId(Long id);


}
