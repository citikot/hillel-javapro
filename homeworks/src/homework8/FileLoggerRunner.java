package homework8;

import java.nio.charset.StandardCharsets;

public class FileLoggerRunner {

    public static void main(String[] args) throws FileMaxSizeReachedException {

        // 1. Создать клас конфигурации

        FileLoggerConfiguration loggerConfiguration = new FileLoggerConfiguration("log.txt", LoggingLevel.DEBUG,
                                                                300, StandardCharsets.UTF_8);

        // 2. Передать класс конфигурации в конструктор, создать файл логгер

        FileLogger logger = new FileLogger(loggerConfiguration);

        logger.info("Mes5");
        logger.info("Mess6");



    }
}
