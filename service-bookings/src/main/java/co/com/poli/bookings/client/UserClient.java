package co.com.poli.bookings.client;
import co.com.poli.bookings.helpers.*;
import co.com.poli.bookings.entities.Booking;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "service-user")
public interface UserClient {

    @GetMapping("/poli/v1/users/{id}")
    ResponseEntity findById(@PathVariable("id") Long id);

}
