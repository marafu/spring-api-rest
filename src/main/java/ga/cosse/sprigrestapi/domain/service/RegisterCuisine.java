package ga.cosse.sprigrestapi.domain.service;

import ga.cosse.sprigrestapi.domain.entity.Cuisine;
import ga.cosse.sprigrestapi.domain.exception.DuplicateCuisine;
import ga.cosse.sprigrestapi.domain.repository.CuisineRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterCuisine {
    private final CuisineRepository cuisineRepository;
    public RegisterCuisine(CuisineRepository cuisineRepository) {
        this.cuisineRepository = cuisineRepository;
    }
    public Cuisine execute(String name) {
        this.verifyDuplication(name);
        Cuisine cuisine = new Cuisine(name);
        return this.cuisineRepository.save(cuisine);
    }

    private void verifyDuplication(String name) {
        Optional<Cuisine> cuisineOptional = this.cuisineRepository.listByName(name);
        if (cuisineOptional.isEmpty()) {
            return;
        }
        throw new DuplicateCuisine();
    }
}
