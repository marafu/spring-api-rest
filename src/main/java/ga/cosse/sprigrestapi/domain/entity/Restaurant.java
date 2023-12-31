package ga.cosse.sprigrestapi.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    BigDecimal shipCost;
    Boolean active;
    Boolean open;
    LocalDateTime createdAt;
    LocalDateTime updateAt;
    @ManyToOne
    private Cuisine cuisine;
    @ManyToMany
    @JoinTable(name = "restaurant_payment")
    List<Payment> payments = new ArrayList<Payment>();
    @OneToMany
    List<Product> products = new ArrayList<>();
    @Embedded
    Address address;
}
