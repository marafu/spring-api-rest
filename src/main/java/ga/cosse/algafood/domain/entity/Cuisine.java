package ga.cosse.algafood.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
public class Cuisine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotNull
    String name;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuisine cuisine = (Cuisine) o;
        return Objects.equals(id, cuisine.id) && Objects.equals(name, cuisine.name);
    }
    public Cuisine() {
    }
    public Cuisine(Long id) {
        this.id = id;
    }
    public Cuisine(String name) {
        this.name = name;
    }
    public Cuisine(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
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
}
