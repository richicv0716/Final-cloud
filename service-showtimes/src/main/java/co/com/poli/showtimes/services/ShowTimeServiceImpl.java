package co.com.poli.showtimes.services;

import co.com.poli.showtimes.clientFeign.movieClient;
import co.com.poli.showtimes.entities.ShowTime;
import co.com.poli.showtimes.model.Movie;
import co.com.poli.showtimes.repositories.ShowTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShowTimeServiceImpl implements ShowTimeService {
    private final movieClient movieClient;

    @Autowired
    private ShowTimeRepository showTimeRepository;

    @Override
    //@Transactional(rollbackFor = Exception.class)
    public ResponseEntity<ShowTime> save(ShowTime showTime) {
        showTimeRepository.save(showTime);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("uri", "/showTime");

        ResponseEntity response = new ResponseEntity<ShowTime>(showTime, headers, HttpStatus.CREATED);
        return response;
    }


    @Override
    public void deleteById(Long id) {
        showTimeRepository.deleteById(id);
    }

    public Optional<ShowTime> findByID(Long id) {




        return showTimeRepository.findById(id);
    };

    @Override
    public ResponseEntity<ShowTime> delete(Long id) {
        Optional<ShowTime> optionalShowTime = findByID(id);
        if (optionalShowTime.isPresent()){
            ShowTime showTime = optionalShowTime.get();
            deleteById(id);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("uri", "/users");
            ModelMapper modelMapper = new ModelMapper();
            Movie movie =  modelMapper.map(movieClient.findById(showTime.getMovie_id()).getData(),Movie.class);
            showTime.setDate(movieClient.findById(showTime.getMovie_id()).getData().toString());
            ResponseEntity response = new ResponseEntity<ShowTime>( showTime, headers, HttpStatus.OK);
            return response;
        }else{
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "No existe el showTime");
            errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<ShowTime> update(ShowTime showTime, Long id) {
        Optional<ShowTime> optionalShowTime = findByID(id);
        if (optionalShowTime.isPresent()){
            ShowTime showTime2 = optionalShowTime.get();
            showTime2.setDate(showTime.getDate());
            showTimeRepository.save(showTime2);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("uri", "/users");
            ResponseEntity response = new ResponseEntity<ShowTime>( showTime2, headers, HttpStatus.OK);
            return response;
        }else{
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "No existe el showTime");
            errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public List<ShowTime> findAll() {
        return showTimeRepository.findAll();
    }





    @Override
    public ResponseEntity<ShowTime> findById(Long id) {
        Optional<ShowTime> optionalShowTime = findByID(id);
        if(optionalShowTime.isPresent()){
            ShowTime showTime = optionalShowTime.get();

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("uri", "/Movie");
            ResponseEntity response = new ResponseEntity<ShowTime>( showTime, headers, HttpStatus.OK);
            return response;
        }else{
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "No existe la movie");
            errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
        }
    }



}
