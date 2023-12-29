package ga.cosse.algafood.domain.service;

import ga.cosse.algafood.domain.entity.Cuisine;
import ga.cosse.algafood.domain.exception.DuplicateCuisine;
import ga.cosse.algafood.domain.repository.CuisineRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterCuisine {
    private CuisineRepository cuisineRepository;
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
        if(cuisineOptional.get().getId() != null)  {
            throw new DuplicateCuisine();
        }
    }
}
