package ua.lviv.iot.exception;

public class ConsultantNotFountException extends RuntimeException {
    public ConsultantNotFountException(Integer id) {
        super("Could not find consultant with id=" + id);
    }
}
