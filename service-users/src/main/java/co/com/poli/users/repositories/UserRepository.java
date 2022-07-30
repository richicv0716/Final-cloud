package co.com.poli.users.repositories;

import co.com.poli.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);
    void deleteById(Long id);
    List<User> findAll();

}
