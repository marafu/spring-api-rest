package ga.cosse.sprigrestapi.infra.exception;

public class DatabaseRepositoryException extends RuntimeException {
    final String message;
    public DatabaseRepositoryException(String message) {
        super();
        this.message = message;
    }
}
