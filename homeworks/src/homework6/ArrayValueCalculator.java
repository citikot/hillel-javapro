package homework6;

public class ArrayValueCalculator {

    public static void main(String[] args) {

        String[][] arr = {
                {"1", "998", "567", "1234"},
                {"45", "998", "1", "123345"},
                {"45", "998", "567", "1234"},
                {"45", "998", "567", "456"}
        };

        int res = 0;
        boolean err = false;

        try {
            res = doCalc(arr);
        } catch (ArraySizeException ex) {
            System.out.println(ArraySizeException.getErrorMessage());
            err = true;
        } catch (ArrayDataException ex) {
            System.out.println(ArrayDataException.getErrorMessage());
            err = true;
        }

        if (!err) {
            System.out.println("The sum of all integer representations of the array elements is: " + res);
        }

    }

    public static int doCalc(String[][] arr) throws ArraySizeException, ArrayDataException {

        int res = 0;

        if (arr.length == 4) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != 4) {
                    throw new ArraySizeException("Array size error!");
                } else {
                    for (int j = 0; j < arr[i].length; j++) {
                        try {
                            res += Integer.parseInt(arr[i][j]);
                        } catch (NumberFormatException ex) {
                            throw new ArrayDataException(
                                    "Element can not be parsed to integer: " +
                                            arr[i][j] + " indexes i and j : " + i
                                            + " " + j);
                        }
                    }
                }
            }
        } else {
            throw new ArraySizeException("Array size error!");
        }
        return res;
    }
}
