package com.work.traductor.exception;

/**
 * 
 * @author linux
 */
public enum BusinessCode implements ErrorCode {

    /**
     * The error option.
     */
    ERROR_GENERAL(5001),
    
    /** The error validate. */
    ERROR_VALIDATE(4001);

    /**
     * The number.
     */
    private final int number;

    /**
     * Instantiates a new business code.
     *
     * @param number the number
     */
    BusinessCode(int number) {
        this.number = number;
    }

    /**
     * Gets the number.
     *
     * @return the number
     */
    @Override
    public int getNumber() {
        return this.number;
    }

}
