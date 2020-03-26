package edu.eci.arsw.covidApplication.persistence;

public class CovidException extends Exception {
    public CovidException(String message) {
        super(message);
    }

    public CovidException(String message, Throwable cause) {
        super(message, cause);
    }
}
