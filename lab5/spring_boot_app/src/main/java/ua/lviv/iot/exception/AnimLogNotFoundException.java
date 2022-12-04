package ua.lviv.iot.exception;

public class AnimLogNotFoundException extends RuntimeException {
    public AnimLogNotFoundException(Integer id) {
        super("Could not find animator log with id=" + id);
    }
}
