package co.com.poli.showtimes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ShowTimesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowTimesApplication.class, args);
    }

}
