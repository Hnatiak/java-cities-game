package org.example.game;

public class CityRepositoryException
        extends RuntimeException {

    public CityRepositoryException(
            String message,
            Throwable cause
    ) {
        super(message, cause);
    }
}