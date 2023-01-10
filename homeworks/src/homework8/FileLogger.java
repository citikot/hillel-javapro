package homework8;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class FileLogger {
    /*
    Клас здійснюватиме логування (протоколування) інформації
    в зазначений файл на підставі конфігураційного об'єкта.
    */
    private FileLoggerConfiguration file;

    public FileLogger(FileLoggerConfiguration file) {
        this.file = file;
    }

    public void info(String message) throws FileMaxSizeReachedException {
        File fo = new File(file.getFileName());
        if ((int )fo.length() > file.maxFileSize) {
            throw new FileMaxSizeReachedException(file.fileName, file.maxFileSize, fo);
        }
        DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy '@' HH:mm:ss");
        String date = dateFormat.format(new Date());
        StringBuilder messageToLog = new StringBuilder();
        messageToLog.append(date);
        messageToLog.append(" ");
        messageToLog.append(LoggingLevel.INFO);
        messageToLog.append(" ");
        messageToLog.append(" messaga: ");
        messageToLog.append(message);
        messageToLog.append("\n");

        try (FileWriter fw = new FileWriter(fo, file.getFileFormat(), true)) {
            fw.write(String.valueOf(messageToLog));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void debug(String message) throws FileMaxSizeReachedException {
        File fo = new File(file.getFileName());
        if ((int )fo.length() > file.maxFileSize) {
            throw new FileMaxSizeReachedException(file.fileName, file.maxFileSize, fo);
        }
        DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy '@' HH:mm:ss");
        String date = dateFormat.format(new Date());
        StringBuilder messageToLog = new StringBuilder();
        messageToLog.append(date);
        messageToLog.append(" ");
        messageToLog.append(LoggingLevel.INFO);
        messageToLog.append(" ");
        messageToLog.append(LoggingLevel.DEBUG);
        messageToLog.append(" ");
        messageToLog.append(" messaga: ");
        messageToLog.append(message);
        messageToLog.append("\n");

        try (FileWriter fw = new FileWriter(fo, file.getFileFormat(), true)) {
            fw.write(String.valueOf(messageToLog));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
