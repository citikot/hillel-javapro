package homework8;

/**
 * Таблиця видимості:
 * | LEVEL | INFO | DEBUG |
 * | INFO  |   X  |       |
 * | DEBUG |   X  |   X   |
 *
 * Тобто, якщо активовано рівень DEBUG, то його також включається INFO, але не навпаки.
 */
public enum LoggingLevel {
    INFO,
    DEBUG;

}
