package page;

public class LoadPropertiesException extends Exception {

    public LoadPropertiesException() {
        super();
    }

    public LoadPropertiesException(String message) {
        super(message);
    }

    public LoadPropertiesException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoadPropertiesException(Throwable cause) {
        super(cause);
    }

    protected LoadPropertiesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
