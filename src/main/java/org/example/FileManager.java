package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileManager implements IFileManager {

    private final Logger logger = new Logger();  // Logger instance for logging operations

    @Override
    public String displayDirectoryContents(String directoryPath) {
        StringBuilder sb = new StringBuilder();  // StringBuilder to build the directory content string
        File dir = new File(directoryPath);  // Create a File object for the directory

        if (dir.exists() && dir.isDirectory()) {  // Check if the directory exists and is a directory
            File[] files = dir.listFiles();  // List all files in the directory

            if (files != null) {
                for (File file : files) {
                    // Append file details (name, size, last modified date) to the StringBuilder
                    sb.append(String.format("Name: %s | Size: %d bytes | Last Modified: %s%n",
                            file.getName(), file.length(), new java.util.Date(file.lastModified())));
                }
            }
            logger.log("INFO", "Displayed contents of directory: " + directoryPath);  // Log the operation
        } else {
            sb.append("Directory does not exist or is not a directory: ").append(directoryPath);  // Error message
            logger.log("ERROR", "Directory not found or is not a directory: " + directoryPath);  // Log the error
        }
        return sb.toString();  // Return the directory contents as a string
    }

    @Override
    public void copyFile(String sourcePath, String destPath) throws IOException {
        // Copy the file from the source path to the destination path
        Files.copy(Paths.get(sourcePath), Paths.get(destPath), StandardCopyOption.REPLACE_EXISTING);
        logger.log("INFO", "Copied file from " + sourcePath + " to " + destPath);  // Log the operation
    }

    @Override
    public void moveFile(String sourcePath, String destPath) throws IOException {
        // Move the file from the source path to the destination path
        Files.move(Paths.get(sourcePath), Paths.get(destPath), StandardCopyOption.REPLACE_EXISTING);
        logger.log("INFO", "Moved file from " + sourcePath + " to " + destPath);  // Log the operation
    }

    @Override
    public void deleteFile(String filePath) throws IOException {
        // Delete the file at the specified path
        Files.delete(Paths.get(filePath));
        logger.log("INFO", "Deleted file: " + filePath);  // Log the operation
    }

    @Override
    public void createDirectory(String directoryPath) throws IOException {
        // Create a new directory at the specified path
        Files.createDirectories(Paths.get(directoryPath));
        logger.log("INFO", "Created directory: " + directoryPath);  // Log the operation
    }

    @Override
    public void deleteDirectory(String directoryPath) throws IOException {
        // Delete the directory and its contents
        Files.walk(Paths.get(directoryPath))  // Walk through the directory tree
                .sorted(Comparator.reverseOrder())  // Sort files in reverse order to delete contents first
                .map(Path::toFile)  // Convert each Path to a File
                .forEach(File::delete);  // Delete each file
        logger.log("INFO", "Deleted directory: " + directoryPath);  // Log the operation
    }

    @Override
    public List<String> searchFiles(String dirPath, String query) {
        File dir = new File(dirPath);  // Create a File object for the directory
        // Filter files based on the query (file name contains or ends with the query)
        File[] files = dir.listFiles((dir1, name) -> name.contains(query) || name.endsWith(query));
        List<String> results = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                results.add(file.getAbsolutePath());  // Add the file path to the results list
            }
            logger.log("INFO", "Searched for files in directory: " + dirPath + " with query: " + query);  // Log the operation
        } else {
            logger.log("WARNING", "No files found in directory: " + dirPath + " with query: " + query);  // Log the warning
        }
        return results;  // Return the list of matching file paths
    }
}


