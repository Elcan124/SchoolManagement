package exception;

public enum EnumException {
    USER_NOT_FOUND_EXCEPTION("There is no user in this system"),
    CLASSES_NOT_FOUND_EXCEPTION("Class not founded");

    private String message;

    EnumException(String message) {
        this.message = message;

    }

    public String getMessage() {
        return message;
    }
}
