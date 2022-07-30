package co.com.poli.bookings.controller;

import co.com.poli.bookings.client.MovieClient;
import co.com.poli.bookings.client.UserClient;
import co.com.poli.bookings.entities.Booking;
import co.com.poli.bookings.helpers.ResponseBuilder;
import co.com.poli.bookings.repositories.BookingRepository;
import co.com.poli.bookings.services.BookingService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    @Autowired
    BookingService bookingService;
    MovieClient movieClient;
    UserClient userClient;
    private final ResponseBuilder builder;


    @RequestMapping(method = RequestMethod.GET, value = "")
    public  List<Booking> findAll(){
        return bookingService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity <Booking> save(@Valid @RequestBody Booking booking){
        return  bookingService.save(booking);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Booking> delete(@PathVariable("id") long id) {
        return  bookingService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Booking> findById(@PathVariable("id") long id) {
        return  bookingService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/userid/{id}")
    public List<Booking> findByUserId(@PathVariable("id") long id) {
        return  bookingService.findByUserId(id);
    }






}
