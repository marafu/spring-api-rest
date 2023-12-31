package ga.cosse.sprigrestapi.integration;

import ga.cosse.sprigrestapi.domain.entity.Cuisine;
import ga.cosse.sprigrestapi.domain.repository.CuisineRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Cuisine")
public class CuisineTest {
    @Autowired private CuisineRepository cuisineRepository;
    @Test
    @DisplayName("List all cuisines")
    void listAllCuisine() {
        var cuisines = cuisineRepository.listAll();
        Assertions.assertThat(cuisines).isNotEmpty();
        System.out.println(cuisines);
    }

    @Test
    @DisplayName("Add a cuisine")
    void addCuisine() {
        var result = cuisineRepository.save(new Cuisine("Coreana"));
        Assertions.assertThat(result).isNotNull();
    }
}

