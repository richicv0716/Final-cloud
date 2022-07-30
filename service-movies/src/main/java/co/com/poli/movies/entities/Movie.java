package co.com.poli.movies.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
@Table(name = "movies")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    @Id
    @NotBlank(message = "the id field cannot be empty")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,unique = true,nullable = false)
    private Long id;
    @NotBlank(message = "the title field cannot be empty")
    @Column(name = "title",nullable = false)
    private String title;
    @NotBlank(message = "the director field cannot be empty")
    @Column(name = "director",nullable = false)
    private String director;
    @Size(min = 1, max = 5, message = "The rating of the movie must have between 1 and 5 characters")
    private int rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
