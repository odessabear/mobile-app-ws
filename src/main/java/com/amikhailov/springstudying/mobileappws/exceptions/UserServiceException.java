package com.amikhailov.springstudying.mobileappws.exceptions;

public class UserServiceException extends RuntimeException {


    private static final long serialVersionUID = 2160140917426191985L;

    public UserServiceException(String message) {
        super(message);
    }

}
