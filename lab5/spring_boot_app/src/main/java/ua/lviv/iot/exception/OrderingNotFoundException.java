package ua.lviv.iot.exception;

public class OrderingNotFoundException extends RuntimeException {
    public OrderingNotFoundException(Integer id) {
        super("Could not find ordering with id=" + id);
    }
}
