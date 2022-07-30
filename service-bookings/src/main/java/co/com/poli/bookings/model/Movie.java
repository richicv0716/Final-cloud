package co.com.poli.bookings.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class Movie {

    private Long id;
    private String title;
    private String director;
    private int rating;
}
