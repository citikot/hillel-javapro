package homework8;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger {
    /*
    Клас здійснюватиме логування (протоколування) інформації
    в зазначений файл на підставі конфігураційного об'єкта.
    */
    private FileLoggerConfiguration config;

    public FileLogger(FileLoggerConfiguration file) {
        this.config = file;
    }

    public void info(String message) throws FileMaxSizeReachedException {
        File fo = new File(config.getFileName());
        DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy '@' HH:mm:ss");
        String date = dateFormat.format(new Date());
        StringBuilder messageToLog = new StringBuilder();
        messageToLog.append(date);
        messageToLog.append(" ");
        messageToLog.append(LoggingLevel.INFO);
        messageToLog.append(" ");
        messageToLog.append(" message: ");
        messageToLog.append(message);
        messageToLog.append("\n");

        int messageToLogLengthInBytes = messageToLog.toString().getBytes(config.getFileFormat()).length;

        if (((int )fo.length() + messageToLogLengthInBytes) > config.getMaxFileSize()) {
            throw new FileMaxSizeReachedException(config.getFileName(), config.getMaxFileSize(), fo);
        }

        try (FileWriter fw = new FileWriter(fo, config.getFileFormat(), true)) {
            fw.write(String.valueOf(messageToLog));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void debug(String message) throws FileMaxSizeReachedException {
        File fo = new File(config.getFileName());
        DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy '@' HH:mm:ss");
        String date = dateFormat.format(new Date());
        StringBuilder messageToLog = new StringBuilder();
        messageToLog.append(date);
        messageToLog.append(" ");
        messageToLog.append(LoggingLevel.INFO);
        messageToLog.append(" ");
        messageToLog.append(LoggingLevel.DEBUG);
        messageToLog.append(" ");
        messageToLog.append(" message: ");
        messageToLog.append(message);
        messageToLog.append("\n");

        try (FileWriter fw = new FileWriter(fo, config.getFileFormat(), true)) {
            fw.write(String.valueOf(messageToLog));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
