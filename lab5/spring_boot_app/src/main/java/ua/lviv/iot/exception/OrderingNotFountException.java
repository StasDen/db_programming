package ua.lviv.iot.exception;

public class OrderingNotFountException extends RuntimeException {
    public OrderingNotFountException(Integer id) {
        super("Could not find ordering with id=" + id);
    }
}
