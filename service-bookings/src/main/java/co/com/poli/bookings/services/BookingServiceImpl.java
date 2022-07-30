package co.com.poli.bookings.services;

import co.com.poli.bookings.client.MovieClient;
import co.com.poli.bookings.client.UserClient;
import co.com.poli.bookings.entities.Booking;
import co.com.poli.bookings.model.User;
import co.com.poli.bookings.repositories.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final UserClient userClient;
    private final MovieClient movieClient;

    Object reserva;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    //@Transactional(rollbackFor = Exception.class)
    public ResponseEntity<Booking> save(Booking booking) {
        bookingRepository.save(booking);



        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("uri", "/bookings");
        ResponseEntity response = new ResponseEntity<Booking>(booking, headers, HttpStatus.CREATED);
        return response;
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<Booking> delete(Long id) {
        Optional<Booking> optionalUser = findByID(id);
        if (optionalUser.isPresent()){
            Booking booking= optionalUser.get();
            deleteById(id);
            //save(booking);
            //user.setStatus("deleted");

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("uri", "/Booking");
            ResponseEntity response = new ResponseEntity<Booking>( booking, headers, HttpStatus.OK);
            return response;
        }else{
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "No existe booking");
            errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    public Optional<Booking> findByID(Long id) {
        return bookingRepository.findById(id);
    };

    @Override
    public ResponseEntity<Booking> findById(Long id) {
        Optional<Booking> optionalBooking = findByID(id);
        if(optionalBooking.isPresent()){
            Booking booking = optionalBooking.get();

            reserva = booking;
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("uri", "/Booking");
            ResponseEntity response = new ResponseEntity<Booking>( booking, headers, HttpStatus.OK);
            return response;
        }else{
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "No existe  booking");
            errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Booking> findByUserId(Long id) {
        List<Booking> list=new ArrayList<Booking>();
        for (Booking p: findAll()) {
            if(id.equals(p.getUserId())) {
                list.add(p);
            }
        }
        return list;
    }


}
