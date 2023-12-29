package ga.cosse.algafood.unit.domain.service;

import ga.cosse.algafood.domain.exception.DuplicateCuisine;
import ga.cosse.algafood.domain.repository.CuisineRepository;
import ga.cosse.algafood.domain.service.RegisterCuisine;
import ga.cosse.algafood.infra.repository.CuisineRepositoryDatabaseMySQL;
import ga.cosse.algafood.infra.repository.CuisineRepositoryMemory;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RegisterServiceTest {
    static Connection connection;

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

    @Test
    @DisplayName("should return a cuisine when it does not exist")
    public void registerAnCuisineIfNotExist() {
        String cuisineName = "valid_name"+Math.random();
//        CuisineRepository cuisineRepository = new CuisineRepositoryMemory();
        CuisineRepository cuisineRepository = new CuisineRepositoryDatabaseMySQL(connection);
        RegisterCuisine registerCuisine = new RegisterCuisine(cuisineRepository);
        Assertions.assertDoesNotThrow(() -> registerCuisine.execute(cuisineName));
    }

    @Test
    @DisplayName("should throw an exception when cuisine exists")
    public void throwExceptionWhenCuisineExists() {
        String cuisineName = "Cuisine 3";
        CuisineRepository cuisineRepository = new CuisineRepositoryMemory();
//        CuisineRepository cuisineRepository = new CuisineRepositoryDatabaseMySQL(connection);
        RegisterCuisine registerCuisine = new RegisterCuisine(cuisineRepository);
        Assertions.assertThrows(DuplicateCuisine.class,() -> registerCuisine.execute(cuisineName));
    }


}
