package ga.cosse.algafood;

import ga.cosse.algafood.domain.entity.Cuisine;
import ga.cosse.algafood.domain.repository.CuisineRepository;
import ga.cosse.algafood.domain.service.RegisterCuisine;
import ga.cosse.algafood.infra.repository.CuisineRepositoryDatabaseMySQL;
import ga.cosse.algafood.infra.repository.CuisineRepositoryMemory;
import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CuisineTest {
    static Connection connection;

    @Test
    @DisplayName("Should list all cuisines")
    public void listAllCuisines() {
        Assertions.assertDoesNotThrow(() -> {
//            CuisineRepository cuisineRepository = new CuisineRepositoryMemory();
            CuisineRepositoryDatabaseMySQL cuisineRepository = new CuisineRepositoryDatabaseMySQL(connection);
            List<Cuisine> cuisines = cuisineRepository.listAll();
        });
    }

    @Test
    @DisplayName("Should return an cuisine by name")
    public void listCuisineByName() {
        Assertions.assertDoesNotThrow(() -> {
            CuisineRepository cuisineRepository = new CuisineRepositoryMemory();
//            CuisineRepositoryDatabaseMySQL cuisineRepository = new CuisineRepositoryDatabaseMySQL(connection);
            Optional<Cuisine> cuisineOptional = cuisineRepository.listByName("Cuisine 3");
            Assertions.assertNotNull(cuisineOptional.get().getId());
        });
    }

    @Test
    @DisplayName("Should Register An Unactivated Cuisine")
    public void registerUnactivatedCuisine() {
        String cuisineName = "valid_name";
        CuisineRepository cuisineRepository = new CuisineRepositoryMemory();
//        CuisineRepository cuisineRepository = new CuisineRepositoryDatabaseMySQL(connection);
        RegisterCuisine registerCuisine = new RegisterCuisine(cuisineRepository);
        Cuisine cuisine = registerCuisine.execute(cuisineName);
        Assertions.assertTrue((cuisine.getId() > 0L) && (cuisine.getName().equals(cuisineName)));
    }



    @BeforeAll
    public static void setup() {
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://root:@localhost/algafood?&createDatabaseIfNotExist=true&serverTimezone=UTC");
        } catch (SQLException exception) {
            System.out.println("SQLException: " + exception.getMessage());
            System.out.println("SQLState: " + exception.getSQLState());
            System.out.println("VendorError: " + exception.getErrorCode());
        }
    }

    @AfterAll
    public static void destroy() {
        try {
            connection.close();
        } catch (SQLException exception) {
            System.out.println("SQLException: " + exception.getMessage());
            System.out.println("SQLState: " + exception.getSQLState());
            System.out.println("VendorError: " + exception.getErrorCode());
        }
    }


}
