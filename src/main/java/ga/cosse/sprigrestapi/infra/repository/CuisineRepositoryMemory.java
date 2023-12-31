package ga.cosse.sprigrestapi.infra.repository;


import ga.cosse.sprigrestapi.domain.entity.Cuisine;
import ga.cosse.sprigrestapi.domain.repository.CuisineRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//@Repository
public class CuisineRepositoryMemory /** implements CuisineRepository */{
    private final List<Cuisine> cuisines = new ArrayList<>();

    public CuisineRepositoryMemory() {
        this.save(new Cuisine("Cuisine 1"));
        this.save(new Cuisine("Cuisine 2"));
        this.save(new Cuisine("Cuisine 3"));
    }

    public Optional<Cuisine> listByName(String name) {
        return this.cuisines.stream().filter(cuisine -> cuisine.getName().equals(name)).findFirst();
    }

    public List<Cuisine> listAll() {
        return this.cuisines;
    }

    public Cuisine save(Cuisine cuisine) {
        cuisine.setId(Long.valueOf(this.cuisines.size()) > 1L ? Long.valueOf(this.cuisines.size()) : (Long.valueOf(this.cuisines.size()) + 1L));
        this.cuisines.add(cuisine);
        return cuisine;
    }
}
