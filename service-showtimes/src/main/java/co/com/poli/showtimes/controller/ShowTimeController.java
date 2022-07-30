package co.com.poli.showtimes.controller;

import co.com.poli.showtimes.entities.ShowTime;
import co.com.poli.showtimes.repositories.ShowTimeRepository;
import co.com.poli.showtimes.services.ShowTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/showTimes")
@RequiredArgsConstructor
public class ShowTimeController {

    @Autowired
    ShowTimeService showTimeService;
    ShowTimeRepository showRepository;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public  List<ShowTime> findAll(){
        return showTimeService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity <ShowTime> save(@Valid @RequestBody ShowTime showTime){
        return showTimeService.save(showTime);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<ShowTime> delete(@PathVariable("id") long id) {
        return  showTimeService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<ShowTime> findById(@PathVariable("id") long id) {
        return  showTimeService.findById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity <ShowTime> update(@PathVariable("id") long id,@Valid @RequestBody ShowTime showTime){
        return showTimeService.update(showTime,id);
    }

}
