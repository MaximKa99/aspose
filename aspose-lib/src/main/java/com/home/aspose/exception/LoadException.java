package com.home.aspose.exception;

/**
 * This exception will be thrown if there is a trouble with
 * loading document
 */
public class LoadException extends RuntimeException{
    public LoadException(String message) {
        super(message);
    }
}
