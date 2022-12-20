package homework6;

public class ArrayDataException extends Exception {

    private static String errorMessage;

    public ArrayDataException(String errorMessage) {
        ArrayDataException.errorMessage = errorMessage;
    }

    public static String getErrorMessage() {
        return errorMessage;
    }

}
