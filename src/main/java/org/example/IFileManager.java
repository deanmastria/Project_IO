package org.example;

import java.util.List;
import java.io.IOException;

public interface IFileManager {
    // Display the contents of the directory at the given path
    String displayDirectoryContents(String directoryPath);

    // Copy a file from the source path to the destination path
    void copyFile(String sourcePath, String destPath) throws IOException;

    // Move a file from the source path to the destination path
    void moveFile(String sourcePath, String destPath) throws IOException;

    // Delete the file at the specified path
    void deleteFile(String filePath) throws IOException;

    // Create a new directory at the specified path
    void createDirectory(String directoryPath) throws IOException;

    // Delete the directory at the specified path
    void deleteDirectory(String directoryPath) throws IOException;

    // Search for files in the directory that match the query string
    List<String> searchFiles(String dirPath, String query);
}
