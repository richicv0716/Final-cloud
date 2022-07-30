package co.com.poli.movies.services;

import co.com.poli.movies.entities.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {
    ResponseEntity<Movie> save(Movie movie);
    void deleteById(Long id);
    List<Movie> findAll();
    ResponseEntity<Movie> delete(Long id);
    ResponseEntity<Movie> findById(Long id);




}
