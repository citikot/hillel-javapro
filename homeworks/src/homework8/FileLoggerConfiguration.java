package homework8;

public class FileLoggerConfiguration {
    /*
    Клас представляє конфігурацію для логування.
    Складається з властивостей:
    файл, куди буде записуватися інформація,
    поточний рівень логування,
    максимальний розмір файлу (в байтах),
    формат для запису в файл.
    */
    String fileName;
    LoggingLevel loggingLevel;
    int maxFileSize;
    String fileFormat;

}
