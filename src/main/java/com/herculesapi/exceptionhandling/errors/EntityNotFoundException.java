package com.herculesapi.exceptionhandling.errors;

@SuppressWarnings("unused")
public class EntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 8015993687394574830L;
    private static final String message = "Can't found the requested entity";
    private Throwable cause;

    public EntityNotFoundException() {

    }

    public EntityNotFoundException(String message) {
	this.cause = null;
    }

}
