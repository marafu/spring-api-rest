package ga.cosse.sprigrestapi.infra.repository;

import ga.cosse.sprigrestapi.domain.entity.Cuisine;
import ga.cosse.sprigrestapi.domain.repository.CuisineRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class CuisineRepositoryDatabase implements CuisineRepository {
    @PersistenceContext
    private EntityManager manager;
    @Override
    public Optional<Cuisine> listByName(String name) {
        return Optional.ofNullable(manager.find(Cuisine.class, name));
    }

    @Override
    public List<Cuisine> listAll() {
        return manager.createQuery("from Cuisine", Cuisine.class).getResultList();
    }

    @Override
    @Transactional
    public Cuisine save(Cuisine cuisine) {
        return manager.merge(cuisine);
    }
}
