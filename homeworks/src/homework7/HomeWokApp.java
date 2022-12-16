package homework7;

public class HomeWokApp {
    public static void main(String[] args) {
        printThreeWords();
        System.out.println(checkSumSign());
        printColor();
        compareNumbers();
        System.out.println(isSumInRange(13, 9));
        checkIfPositive(-10);
        System.out.println(isNegative(1));
        printStringNTimes("test", 2);
        System.out.println(isLeapYear(2012));
    }

    public static void printThreeWords(){
        String[] array = {
                "Orange",
                "Banana",
                "Apple"
        };
        for (String elem : array) {
            System.out.println(elem);
        }
    }

    public static String checkSumSign(){
        int a = 45;
        int b = 80;
        if (a + b >= 0) {
            return "Сума позитивна";
        } else {
            return "Сума негативна";
        }
    }

    public static void printColor(){
        int value = 1000;
        if (value <= 0) {
            System.out.println("Червоний");
        } else if (value > 100) {
            System.out.println("Зелений");
        } else {
            System.out.println("Жовтий");
        }
    }

    public static void compareNumbers(){
        int a = 300;
        int b = 300;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean isSumInRange(int a, int b){
        return (a + b) >= 10 && (a + b) <= 20;
    }

    public static void checkIfPositive(int a) {
        System.out.println(a >= 0);
    }

    public static boolean isNegative(int a) {
        return a < 0;
    }

    public static void printStringNTimes(String str, int n){
        for (int i = 1; i <= n; i++){
            System.out.println(str);
        }
    }

    public static boolean isLeapYear(int year){
        if (year % 400 == 0) {
            return true;
        } else if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        return false;
    }
}
