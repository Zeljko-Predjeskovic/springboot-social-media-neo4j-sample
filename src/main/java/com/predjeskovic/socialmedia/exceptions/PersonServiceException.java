package com.predjeskovic.socialmedia.exceptions;

public class PersonServiceException extends RuntimeException{

    public PersonServiceException(){
        super();
    }

    public PersonServiceException(String message){
        super(message);
    }

    public PersonServiceException(String message, Exception innerException){
        super(message, innerException);
    }

}
