package ua.lviv.iot.exception;

public class PartyAnimatorNotFoundException extends RuntimeException {
    public PartyAnimatorNotFoundException(Integer id) {
        super("Could not find party animator with id=" + id);
    }
}
