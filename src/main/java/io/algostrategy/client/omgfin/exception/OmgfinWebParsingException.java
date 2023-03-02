package io.algostrategy.client.omgfin.exception;

/**
 * The exception is thrown when the parsing of the web page fails.
 */
public class OmgfinWebParsingException extends RuntimeException {

    private static final long serialVersionUID = -6110560729965054821L;

    public OmgfinWebParsingException(String message) {
        super(message);
    }

    public OmgfinWebParsingException(Throwable cause) {
        super(cause);
    }

    public OmgfinWebParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}