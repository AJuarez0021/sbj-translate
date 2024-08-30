package com.work.traductor.exception;


import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author linux
 */
public final class ErrorsUtil {

    /**
     * The Constant map.
     */
    private static final Map<ErrorCode, String> ERROR = new HashMap<>();

    /**
     * Instantiates a new errors util.
     */
    private ErrorsUtil() {

    }

    static {
        ERROR.put(BusinessCode.ERROR_GENERAL, "Error: {0}");
        ERROR.put(BusinessCode.ERROR_VALIDATE, "El campo {0} es requerido.");
    }

    /**
     * Gets the error.
     *
     * @param code the code
     * @return the error
     */
    public static String getError(ErrorCode code) {
        return getErrorAsString(code);
    }

    /**
     * Gets the error.
     *
     * @param code the code
     * @param args the args
     * @return the error
     */
    public static String getError(ErrorCode code, Object... args) {
        return MessageFormat.format(getErrorAsString(code), args);
    }

    /**
     * Gets the error as string.
     *
     * @param code the code
     * @return the error as string
     */
    private static String getErrorAsString(ErrorCode code) {
        return ERROR.get(code);
    }
}
