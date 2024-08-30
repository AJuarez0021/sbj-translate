package com.work.traductor.exception;

import org.springframework.http.HttpStatus;


/**
 * 
 * @author linux
 */
public interface ErrorResponse {

    /**
     * Gets the msg error.
     *
     * @return the msg error
     */
    String getMsgError();

    /**
     * Gets the status.
     *
     * @return the status
     */
    HttpStatus getStatus();

   
        
}
