package co.com.poli.users.controller;

import co.com.poli.users.entities.User;
import co.com.poli.users.repositories.UserRepository;
import co.com.poli.users.services.UserService;
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
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<User> findByID(@PathVariable("id") long id) {
        Optional<User> optionalUser = userService.findByID(id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("uri", "/users");
            ResponseEntity response = new ResponseEntity<User>( user, headers, HttpStatus.OK);
            return response;
        }else{
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "No existe ese proyecto");
            errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public  List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity <User> save(@Valid @RequestBody User user){
        return userService.save(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<User> delete(@PathVariable("id") long id) {
        return  userService.delete(id);
    }



}
