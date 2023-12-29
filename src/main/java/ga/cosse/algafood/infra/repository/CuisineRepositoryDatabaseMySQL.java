package ga.cosse.algafood.infra.repository;

import ga.cosse.algafood.domain.entity.Cuisine;
import ga.cosse.algafood.domain.repository.CuisineRepository;
import ga.cosse.algafood.infra.exception.DatabaseRepositoryException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Primary
@Repository
public class CuisineRepositoryDatabaseMySQL implements CuisineRepository {
    private DataSource dataSource;
    private Connection connection;

    public CuisineRepositoryDatabaseMySQL() {
    }

    public CuisineRepositoryDatabaseMySQL(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
    public CuisineRepositoryDatabaseMySQL(Connection connection) {
            this.connection = connection;
    }

    @Override
    public Optional<Cuisine> listByName(String name) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM cuisine WHERE name = \""+ name + "\"");
            Cuisine cuisine = new Cuisine();
            while (result.next()) {
                cuisine.setId(result.getLong("id"));
                cuisine.setName(result.getString("name"));
            }
            return Optional.of(cuisine);
        } catch (SQLException ex) {
            return Optional.empty();
        }

    }

    @Override
    public List<Cuisine> listAll() {
        List<Cuisine> cuisines = new ArrayList<Cuisine>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM cuisine");
            while (result.next()) {
                cuisines.add(new Cuisine(result.getLong("id"), result.getString("name")));
            }
            return cuisines;
        } catch (SQLException ex) {
            return cuisines;
        }
    }

    @Override
    public Cuisine save(Cuisine cuisine) {
        try {
            String query = "INSERT INTO cuisine(name) VALUES (\""+cuisine.getName()+"\")";
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.execute();
            ResultSet result = this.connection.createStatement().executeQuery("SELECT * FROM cuisine WHERE name = \"" + cuisine.getName() + "\"");
            while (result.next()) {
                cuisine.setId(result.getLong("id"));
            }
            return cuisine;
        } catch (SQLException exception) {
            System.out.println("SQLException: " + exception.getMessage());
            System.out.println("SQLState: " + exception.getSQLState());
            System.out.println("VendorError: " + exception.getErrorCode());
            throw new DatabaseRepositoryException("Houve um problema no SQL");
        }
    }
}
