package co.com.poli.users.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Getter
@Setter
@Table(name = "users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @NotBlank(message = "the id field cannot be empty")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,unique = true,nullable = false, updatable = false)
    private Long id;
    @NotBlank(message = "the name field cannot be empty")
    @Column(name = "name",nullable = false)
    private String name;
    @NotBlank(message = "the lastName field cannot be empty")
    @Column(name = "lastName",nullable = false)
    private String lastName;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
