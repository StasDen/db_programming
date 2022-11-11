package ua.lviv.iot.exception;

public class DiscountNotFoundException extends RuntimeException {
    public DiscountNotFoundException(Integer id) {
        super("Could not find discount with id=" + id);
    }
}
