package org.example;

import java.util.List;
import java.io.IOException;

public interface IFileManager {
    String displayDirectoryContents(String directoryPath);

    void copyFile(String sourcePath, String destPath) throws IOException;

    String moveFile(String sourcePath, String destPath) throws IOException;

    void deleteFile(String filePath) throws IOException;

    void createDirectory(String directoryPath) throws IOException;

    void deleteDirectory(String directoryPath) throws IOException;

    List<String> searchFiles(String dirPath, String query);
}


