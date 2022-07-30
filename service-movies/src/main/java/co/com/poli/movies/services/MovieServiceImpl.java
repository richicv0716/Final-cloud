package co.com.poli.movies.services;

import co.com.poli.movies.entities.Movie;
import co.com.poli.movies.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public ResponseEntity<Movie> save(Movie movie) {
        movieRepository.save(movie);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("uri", "/movies");
        ResponseEntity response = new ResponseEntity<Movie>(movie, headers, HttpStatus.CREATED);
        return response;
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }



    @Override
    public ResponseEntity<Movie> delete(Long id) {
        Optional<Movie> optionalUser = findByID(id);
        if (optionalUser.isPresent()){
            Movie movie= optionalUser.get();
            deleteById(id);
            //save(movie);
            //user.setStatus("deleted");

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("uri", "/Booking");
            ResponseEntity response = new ResponseEntity<Movie>( movie, headers, HttpStatus.OK);
            return response;
        }else{
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "No existe la movie");
            errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
        }
    }
    public Optional<Movie> findByID(Long id) {
        return movieRepository.findById(id);
    };

    @Override
    public ResponseEntity<Movie> findById(Long id) {
        Optional<Movie> optionalMovie = findByID(id);
        if(optionalMovie.isPresent()){
            Movie movie = optionalMovie.get();

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("uri", "/Movie");
            ResponseEntity response = new ResponseEntity<Movie>( movie, headers, HttpStatus.OK);
            return response;
        }else{
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "No existe la movie");
            errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
        }
    }


}
