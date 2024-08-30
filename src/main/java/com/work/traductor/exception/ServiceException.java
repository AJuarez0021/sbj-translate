package com.work.traductor.exception;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author linux
 */
public class ServiceException extends RuntimeException implements ErrorResponse {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The status.
     */
    private final HttpStatus status;

    /**
     * The message.
     */
    private final String msgError;

    /**
     * Instantiates a new soap exception.
     *
     * @param status the status
     * @param message the message
     */
    public ServiceException(HttpStatus status, String message) {
        super();
        this.status = status;
        this.msgError = message;
    }

    /**
     * Instantiates a new service exception.
     *
     * @param status the status
     * @param errorCode the error code
     */
    public ServiceException(HttpStatus status, ErrorCode errorCode) {
        super();
        this.msgError = ErrorsUtil.getError(errorCode);
        this.status = status;
    }

    /**
     * Instantiates a new service exception.
     * @param status
     * @param errorCode
     * @param args 
     */
    public ServiceException(HttpStatus status, ErrorCode errorCode, Object... args) {
        super();
        this.status = status;
        this.msgError = ErrorsUtil.getError(errorCode, args);
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    @Override
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * Gets the msg error.
     *
     * @return the msg error
     */
    @Override
    public String getMsgError() {
        return msgError;
    }

}
