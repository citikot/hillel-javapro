package homework6;

public class ArraySizeException extends Exception {
    private static String errorMessage;

    public ArraySizeException(String errorMessage) {
        ArraySizeException.errorMessage = errorMessage;
    }

    public static String getErrorMessage() {
        return errorMessage;
    }
}
