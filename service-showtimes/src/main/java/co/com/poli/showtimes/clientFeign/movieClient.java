package co.com.poli.showtimes.clientFeign;

import co.com.poli.showtimes.helpers.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-movies", url="localhost:9054/poli/v1")
public interface movieClient {
    @GetMapping("/movies/1")
    Response findById(@PathVariable("id") Long id);
}
