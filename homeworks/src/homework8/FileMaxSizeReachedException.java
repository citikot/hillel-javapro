package homework8;

public class FileMaxSizeReachedException extends Exception {
    public FileMaxSizeReachedException(){
        super("Maximum size of log file reached!");
    }
}
