package co.com.poli.movies.controller;

import co.com.poli.movies.entities.Movie;
import co.com.poli.movies.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    @Autowired
    MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public  List<Movie> findAll(){
        return movieService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity<Movie> save(@Valid @RequestBody Movie movie) {
        return  movieService.save(movie);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Movie> delete(@PathVariable("id") long id) {
        return  movieService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Movie> findById(@PathVariable("id") long id) {
        return  movieService.findById(id);
    }

}
