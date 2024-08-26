package org.backend.session.lld2.designpatterns.singelton.logger;

import org.springframework.boot.logging.LogLevel;

public interface Logger {

    void log(LogLevel level, String message);

    void setLogFile(String filePath);

    String getLogFile();

    // Flush the log entries to the file
    void flush();

    // Close the logger and release any resources
    void close();
}
