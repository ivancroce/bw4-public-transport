package bw4_team5.exceptions;

public class UuidNotFoundException extends RuntimeException {
    public UuidNotFoundException(String uuid) {
        super("UUID '" + uuid + "' not found.");
    }
}
