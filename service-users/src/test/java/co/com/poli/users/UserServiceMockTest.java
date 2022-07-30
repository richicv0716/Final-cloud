package co.com.poli.users;

import co.com.poli.users.entities.User;
import co.com.poli.users.repositories.UserRepository;
import co.com.poli.users.services.UserService;
import co.com.poli.users.services.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserServiceMockTest {

    @Mock
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    public void begin(){
        MockitoAnnotations.openMocks(this);
        //userService = new UserServiceImpl(userRepository);

        User user= User.builder()
                .id(4L)
                .name("test")
                .build();
        userRepository.save(user);
        Mockito.when(userRepository.findById(4L))
                .thenReturn(Optional.of(user));

    }

    @Test
    public void when_findById_return_Product(){
        List<User> users = userRepository.findAll();
        Assertions.assertThat(users.size()).isEqualTo(0);
    }

}
