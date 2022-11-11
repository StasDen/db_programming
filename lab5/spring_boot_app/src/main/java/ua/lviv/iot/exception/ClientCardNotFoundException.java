package ua.lviv.iot.exception;

public class ClientCardNotFoundException extends RuntimeException {
    public ClientCardNotFoundException(Integer id) {
        super("Could not find client card with id=" + id);
    }
}
