package co.com.poli.movies.repository;

import co.com.poli.movies.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    Movie save(Movie movie);
    void deleteById(Long id);
    List<Movie> findAll();


}
