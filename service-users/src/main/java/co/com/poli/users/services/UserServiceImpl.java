package co.com.poli.users.services;

import co.com.poli.users.entities.User;
import co.com.poli.users.repositories.UserRepository;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    //@Transactional(rollbackFor = Exception.class)
    public ResponseEntity<User> save(User user) {
        userRepository.save(user);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("uri", "/users");
        ResponseEntity response = new ResponseEntity<User>(user, headers, HttpStatus.CREATED);
        return response;
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findByID(Long id) {
        return userRepository.findById(id);
    };

    @Override
    public ResponseEntity<User> delete(Long id) {
        Optional<User> optionalUser = findByID(id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            deleteById(id);
            //save(user);
            //user.setStatus("deleted");

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
}
