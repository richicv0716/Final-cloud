package co.com.poli.bookings.client;

import co.com.poli.bookings.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "service-movie")
public interface MovieClient {


    @RequestMapping(method = RequestMethod.GET, value = "/movies/{id}")
    public ResponseEntity<Movie> findById(@PathVariable("id") long id);

}
