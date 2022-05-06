package org.patika.fourthweekhomeworkbatuhanunverdi.exception;

/**
 * @author Mert Batuhan UNVERDI
 * @since 23.04.2022
 */
public class BaseException extends RuntimeException{
    private final String message;

    public BaseException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
