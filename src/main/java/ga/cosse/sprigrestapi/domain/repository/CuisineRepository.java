package ga.cosse.sprigrestapi.domain.repository;

import ga.cosse.sprigrestapi.domain.entity.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CuisineRepository {
    Optional<Cuisine> listByName(String name);
    List<Cuisine> listAll();
    Cuisine save(Cuisine cuisine);
}
