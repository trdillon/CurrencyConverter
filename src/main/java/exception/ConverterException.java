package exception;

public class ConverterException extends RuntimeException {
    public ConverterException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
