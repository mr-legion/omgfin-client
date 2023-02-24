package io.algostrategy.client.omgfin.exception;

import io.algostrategy.client.omgfin.OmgfinApiError;

/**
 * An exception which can occur while invoking methods of the Omgfin API.
 */
public class OmgfinApiException extends RuntimeException {

    private static final long serialVersionUID = -54234763967383965L;

    private OmgfinApiError error;

    public OmgfinApiException(OmgfinApiError error) {
        this.error = error;
    }

    public OmgfinApiException() {
        super();
    }

    public OmgfinApiException(String message) {
        super(message);
    }

    public OmgfinApiException(Throwable cause) {
        super(cause);
    }

    public OmgfinApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from Omgfin API.
     */
    public OmgfinApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}
