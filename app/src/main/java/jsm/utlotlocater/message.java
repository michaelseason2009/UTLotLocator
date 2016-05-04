package jsm.utlotlocater;

/**
 * Created by Jimny on 5/3/2016.
 */
//message class for individual messages
public class message {
    private String message;
    private String username;

    // Required default constructor for Firebase object mapping
    @SuppressWarnings("unused")
    private message() {
    }

    message(String message, String username) {
        this.message = message;
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public String getUsername() {
        return username;
    }
}
