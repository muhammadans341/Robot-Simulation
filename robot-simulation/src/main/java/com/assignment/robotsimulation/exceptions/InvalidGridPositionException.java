package com.assignment.robotsimulation.exceptions;

public class InvalidGridPositionException extends RuntimeException{
    public InvalidGridPositionException(String message, Throwable cause)
    {
        super(message, cause);

    }
    public InvalidGridPositionException(String message)
    {
        super(message);

    }
    public InvalidGridPositionException(){
        super();
    }
}
