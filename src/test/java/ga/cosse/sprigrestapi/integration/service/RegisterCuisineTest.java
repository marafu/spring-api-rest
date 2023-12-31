package ga.cosse.sprigrestapi.integration.service;

import ga.cosse.sprigrestapi.domain.repository.CuisineRepository;
import ga.cosse.sprigrestapi.domain.service.RegisterCuisine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;

@SpringBootTest
@DisplayName("Register Cuisine")
public class RegisterCuisineTest {

   @Autowired private CuisineRepository repository;


    @Test
    @DisplayName("Register an cuisine")
    public void registerAnCuisine() {
       RegisterCuisine registerCuisine = new RegisterCuisine(repository);
    }
}
