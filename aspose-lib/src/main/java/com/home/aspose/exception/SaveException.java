package com.home.aspose.exception;

/**
 * This exception will be thrown if there is a trouble with
 * saving document
 */
public class SaveException extends RuntimeException{
    public SaveException(String message) {
        super(message);
    }
}
