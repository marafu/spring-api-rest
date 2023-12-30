package ga.cosse.sprigrestapi.domain.repository;

import ga.cosse.sprigrestapi.domain.entity.Cuisine;

import java.util.List;
import java.util.Optional;

public interface CuisineRepository {
    Optional<Cuisine> listByName(String name);
    List<Cuisine> listAll();
    Cuisine save(Cuisine cuisine);
}
