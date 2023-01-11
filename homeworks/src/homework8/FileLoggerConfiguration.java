package homework8;

import java.nio.charset.Charset;

public class FileLoggerConfiguration {
    /*
    Клас представляє конфігурацію для логування.
    Складається з властивостей:
    файл, куди буде записуватися інформація,
    поточний рівень логування,
    максимальний розмір файлу (в байтах),
    формат для запису в файл.
    */
    private String fileName;
    private LoggingLevel loggingLevel;
    private int maxFileSize;
    private Charset fileFormat;

    public FileLoggerConfiguration(String fileName, LoggingLevel loggingLevel, int maxFileSize, Charset fileFormat) {
        this.fileName = fileName;
        this.loggingLevel = loggingLevel;
        this.maxFileSize = maxFileSize;
        this.fileFormat = fileFormat;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public void setLoggingLevel(LoggingLevel loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    public int getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(int maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public Charset getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(Charset fileFormat) {
        this.fileFormat = fileFormat;
    }
}
