package org.example;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger implements ILogger {
    private static final String LOG_FILE_PATH = "logs/file_manager.log";  // Path to the log file

    // Constructor to ensure the logs directory exists
    public Logger() {
        File logDir = new File("logs");  // Create a File object for the logs directory
        if (!logDir.exists()) {
            logDir.mkdirs();  // Create the logs directory if it doesn't exist
        }
    }

    @Override
    public void log(String level, String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE_PATH, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            // Create a timestamp for the log entry
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            // Write the log entry to the file
            out.println(timestamp + " [" + level + "]: " + message);
        } catch (IOException e) {
            e.printStackTrace();  // Print the stack trace if an IOException occurs
        }
    }
}

