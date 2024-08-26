package org.backend.session.lld2.designpatterns.singelton.logger;

public class LoggerSolution {

import org.springframework.boot.logging.LogLevel;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerImpl implements Logger {
    private static LoggerImpl instance;
    private PrintWriter writer;
    private String logFilePath;

    private LoggerImpl() {
        // Private constructor to prevent instantiation
    }

    public static synchronized LoggerImpl getInstance() {
        if (instance == null) {
            instance = new LoggerImpl();
        }
        return instance;
    }

    public static synchronized void resetInstance() {
        if (instance != null) {
            instance.close();
            instance = null;
        }
    }

    @Override
    public void setLogFile(String filePath) {
        if (writer != null) {
            writer.close();
        }
        try {
            writer = new PrintWriter(new FileWriter(filePath, true), true);
            logFilePath = filePath;
        } catch (IOException e) {
            throw new IllegalStateException("Failed to set log file", e);
        }
    }

    @Override
    public void log(LogLevel level, String message) {
        if (writer == null) {
            throw new IllegalStateException("Logger not initialized. Call setLogFile() first.");
        }
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        writer.println("[" + timestamp + "] [" + level + "] " + message);
    }

    @Override
    public String getLogFile() {
        return logFilePath;
    }

    @Override
    public void flush() {
        if (writer != null) {
            writer.flush();
        }
    }

    @Override
    public void close() {
        if (writer != null) {
            writer.close();
            writer = null;
        }
    }
}

}
