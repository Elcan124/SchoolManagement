package exception;

public class AppException extends RuntimeException {


    public AppException(EnumException  enumException){

        super(enumException.getMessage());

    }
}
