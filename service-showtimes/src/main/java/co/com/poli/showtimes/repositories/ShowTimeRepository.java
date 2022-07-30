package co.com.poli.showtimes.repositories;

import co.com.poli.showtimes.entities.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowTimeRepository extends JpaRepository<ShowTime, Long> {

    ShowTime save(ShowTime user);
    void deleteById(Long id);
    List<ShowTime> findAll();


}
