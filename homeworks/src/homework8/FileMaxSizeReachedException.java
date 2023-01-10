package homework8;

import java.io.File;

public class FileMaxSizeReachedException extends Throwable {
    public FileMaxSizeReachedException(String fileName, int sizeAllowed, File fo){
        String s = String.format("Maximum size of %d of log file %s reached! Actual size is %d, path: %s",
                sizeAllowed, fileName, (int) fo.length(), fo.getAbsolutePath());
        System.out.println(s);
    }
}
