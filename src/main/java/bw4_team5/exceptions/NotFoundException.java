package bw4_team5.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("ID '" + id + "' was not found.");
    }
}
