package com.work.traductor.exception;

import com.work.traductor.dto.ErrorDTO;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author effit
 */
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle service exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(ServiceException.class)
    protected ResponseEntity<ErrorDTO> handleServiceException(final ServiceException ex) {
        return new ResponseEntity<>(new ErrorDTO(ex.getStatus().value(), ex.getMsgError()), ex.getStatus());
    }

}
