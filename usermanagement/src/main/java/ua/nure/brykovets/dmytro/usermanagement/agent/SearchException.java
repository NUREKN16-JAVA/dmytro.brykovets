package ua.nure.brykovets.dmytro.usermanagement.agent;

public class SearchException extends Exception {
    public SearchException(Throwable cause) {
        super(cause);
    }

    public SearchException(String message) {
        super(message);
    }
}
