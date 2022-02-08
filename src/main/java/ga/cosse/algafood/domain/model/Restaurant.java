package ga.cosse.algafood.domain.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "ship_cost")
    private BigDecimal shipCost;
}
