package co.com.mercado.libre.domain.exception;

public class QuasarException extends RuntimeException {
    private ErrorCode code;

    public QuasarException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.code = code;
    }

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }
}

