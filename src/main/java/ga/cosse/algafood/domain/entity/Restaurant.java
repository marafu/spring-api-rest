package ga.cosse.algafood.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Column(name = "ship_cost")
    BigDecimal shipCost;
    public Restaurant() {
    }
    public Restaurant(String name) {
        this.name = name;
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
