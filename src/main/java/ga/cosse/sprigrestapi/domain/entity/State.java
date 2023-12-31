package ga.cosse.sprigrestapi.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
}