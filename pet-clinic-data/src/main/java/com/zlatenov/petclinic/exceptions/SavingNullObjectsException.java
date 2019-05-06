package com.zlatenov.petclinic.exceptions;

/**
 * @author Angel Zlatenov
 */

public class SavingNullObjectsException extends RuntimeException {

    public SavingNullObjectsException() {
        super("We cannot save null object");
    }

    public SavingNullObjectsException(final String message) {
        super(message);
    }
}
