package ga.cosse.algafood.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotNull
    String name;
    @Column(name = "ship_cost")
    BigDecimal shipCost;
    Boolean active;
    Boolean open;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    public Restaurant() {
    }
    public Restaurant(String name) {
        this.name = name;
        this.shipCost = BigDecimal.ZERO;
    }
    public Restaurant(String name, BigDecimal shipCost) {
        this.name = name;
        this.shipCost = shipCost;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getShipCost() {
        return shipCost;
    }
    public void setShipCost(BigDecimal shipCost) {
        this.shipCost = shipCost;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(shipCost, that.shipCost);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, shipCost);
    }
}
