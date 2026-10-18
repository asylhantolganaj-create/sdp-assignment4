package com.pattern.facade.exception;

public class MediaConversionException extends RuntimeException {
    public MediaConversionException(String message, Throwable cause) {
        super(message, cause);
    }
}