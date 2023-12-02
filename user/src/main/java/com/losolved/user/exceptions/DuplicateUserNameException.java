package com.losolved.user.exceptions;

public class DuplicateUserNameException extends RuntimeException {

    public DuplicateUserNameException() {
        super("Already exist an user with this username ");
    }
}
