package co.com.poli.showtimes.services;

import co.com.poli.showtimes.entities.ShowTime;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShowTimeService {

    ResponseEntity<ShowTime> save(ShowTime showTime);
    void deleteById(Long id);
    List<ShowTime> findAll();
    ResponseEntity<ShowTime>findById(Long id);
    ResponseEntity<ShowTime> delete(Long id);
    ResponseEntity<ShowTime> update(ShowTime showTime,Long id);

}
