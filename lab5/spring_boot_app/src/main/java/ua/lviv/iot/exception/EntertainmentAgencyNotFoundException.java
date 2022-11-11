package ua.lviv.iot.exception;

public class EntertainmentAgencyNotFoundException extends RuntimeException {
    public EntertainmentAgencyNotFoundException(Integer id) {
        super("Could not find entertainment agency with id=" + id);
    }
}
