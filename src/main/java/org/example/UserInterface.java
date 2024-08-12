package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

import java.io.IOException;

public class UserInterface {

    @FXML
    private TextField dirPathField;  // TextField for directory path input

    @FXML
    private TextField sourcePathField;  // TextField for source file path input

    @FXML
    private TextField destPathField;  // TextField for destination file path input

    @FXML
    private TextField searchQueryField;  // TextField for search query input

    @FXML
    private TextArea outputArea;  // TextArea for displaying output messages

    private final FileManager fileManager = new FileManager();  // Instance of FileManager for file operations

    @FXML
    public void initialize() {
        // Set tooltip for the outputArea programmatically
        Tooltip outputTooltip = new Tooltip("Displays the result of operations such as directory contents, file copy status, etc.");
        Tooltip.install(outputArea, outputTooltip);
    }

    @FXML
    public void handleDisplayContents() {
        String dirPath = dirPathField.getText();  // Get the directory path from the TextField
        String contents = fileManager.displayDirectoryContents(dirPath);  // Get the directory contents
        outputArea.setText(contents);  // Display the contents in the output TextArea
    }

    @FXML
    public void handleCopyFile() {
        String sourcePath = sourcePathField.getText();  // Get the source file path from the TextField
        String destPath = destPathField.getText();  // Get the destination path from the TextField
        try {
            fileManager.copyFile(sourcePath, destPath);  // Perform the copy operation
            outputArea.setText("File copied successfully.");  // Display success message
        } catch (IOException ex) {
            outputArea.setText("Error copying file: " + ex.getMessage());  // Display error message
        }
    }

    @FXML
    public void handleMoveFile() {
        String sourcePath = sourcePathField.getText();  // Get the source file path from the TextField
        String destPath = destPathField.getText();  // Get the destination path from the TextField
        try {
            String movedTo = fileManager.moveFile(sourcePath, destPath);  // Perform the move operation and get the destination path
            outputArea.setText("File moved successfully to: " + movedTo);  // Display the destination path in the output TextArea
        } catch (IOException ex) {
            outputArea.setText("Error moving file: " + ex.getMessage());  // Display error message
        }
    }

    @FXML
    public void handleDeleteFile() {
        String filePath = dirPathField.getText();  // Get the file path from the TextField
        try {
            fileManager.deleteFile(filePath);  // Perform the delete operation
            outputArea.setText("File deleted successfully.");  // Display success message
        } catch (IOException ex) {
            outputArea.setText("Error deleting file: " + ex.getMessage());  // Display error message
        }
    }

    @FXML
    public void handleCreateDirectory() {
        String dirPath = dirPathField.getText();  // Get the directory path from the TextField
        try {
            fileManager.createDirectory(dirPath);  // Perform the create directory operation
            outputArea.setText("Directory created successfully.");  // Display success message
        } catch (IOException ex) {
            outputArea.setText("Error creating directory: " + ex.getMessage());  // Display error message
        }
    }

    @FXML
    public void handleDeleteDirectory() {
        String dirPath = dirPathField.getText();  // Get the directory path from the TextField
        try {
            fileManager.deleteDirectory(dirPath);  // Perform the delete directory operation
            outputArea.setText("Directory deleted successfully.");  // Display success message
        } catch (IOException ex) {
            outputArea.setText("Error deleting directory: " + ex.getMessage());  // Display error message
        }
    }

    @FXML
    public void handleSearchFiles() {
        String dirPath = dirPathField.getText();  // Get the directory path from the TextField
        String query = searchQueryField.getText();  // Get the search query from the TextField
        outputArea.setText(String.join("\n", fileManager.searchFiles(dirPath, query)));  // Display the search results
    }
}

