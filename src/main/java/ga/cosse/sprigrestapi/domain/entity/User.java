package ga.cosse.sprigrestapi.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    String password;
    LocalDateTime createdAt;
    @ManyToMany
    @JoinTable(name = "user_group")
    List<Group> groups = new ArrayList<>();
}
