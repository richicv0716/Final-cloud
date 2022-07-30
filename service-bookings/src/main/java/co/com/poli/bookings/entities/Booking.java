package co.com.poli.bookings.entities;

import co.com.poli.bookings.model.Movie;
import co.com.poli.bookings.model.ShowTime;
import co.com.poli.bookings.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Table(name = "bookings")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {

    @Id
    @NotBlank(message = "the id field cannot be empty")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,unique = true,nullable = false)
    private Long id;
    @Column(name = "userid",nullable = false)
    private Long userId;
    @Column(name = "showTime_Id",nullable = false)
    private Long showTimeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
