package co.com.poli.showtimes;

import java.util.List;

import co.com.poli.showtimes.clientFeign.movieClient;
import co.com.poli.showtimes.model.Movie;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
public class feingTest {
    @Autowired
    private movieClient movie;


    @Test
    public void shouldLoadAllPosts() {
        int i=1;
        long l=i;

        final String posts = movie.findById(l).toString();

        Assert.assertNotNull(l);
        Assert.assertFalse(posts.isEmpty());
    }

}
