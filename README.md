# Project_IO

A JavaFX-based application that allows users to perform basic file and directory operations such as displaying directory contents, copying, moving, and deleting files, creating and deleting directories, and searching for files within a directory.

## Features

- **Display Directory Contents**: View all files and subdirectories within a specified directory.
- **Copy File**: Copy a file from a source path to a destination path.
- **Move File**: Move a file from a source path to a destination path.
- **Delete File**: Delete a file at a specified path.
- **Create Directory**: Create a new directory at a specified path.
- **Delete Directory**: Delete a directory and all its contents.
- **Search Files**: Search for files in a directory based on a query (e.g., file name or extension).

## Prerequisites

- **Java JDK 11 or higher**: Ensure you have JDK 11 or later installed.
- **Maven**: Make sure Maven is installed and set up properly in your environment.
- **JavaFX**: The program requires JavaFX libraries. These should be managed automatically via Maven.

## Installation

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/yourusername/Project_IO.git
    cd simple-file-manager
    ```

2. **Build the Project**:
    Use Maven to build the project:
    ```bash
    mvn clean install
    ```

3. **Run the Program**:
    After building, run the program using the following command:
    ```bash
    mvn javafx:run
    ```

## Usage

### User Interface

- **Directory Operations**:
  - **Directory Path**: Enter the path to the directory you want to work with.
  - **Display Directory Contents**: Click to view all files and subdirectories in the specified directory.
  - **Create Directory**: Enter a path to create a new directory.
  - **Delete Directory**: Enter the path of the directory to delete it and all its contents.

- **File Operations**:
  - **Source Path**: Enter the path of the file you want to copy or move.
  - **Destination Path**: Enter the target path where the file should be copied or moved.
  - **Copy File**: Click to copy the file from the source path to the destination path.
  - **Move File**: Click to move the file from the source path to the destination path.
  - **Delete File**: Enter the path of the file to delete it.

- **Search Operations**:
  - **Search Query**: Enter a search query (e.g., file name or extension) to search within the specified directory.
  - **Search Files**: Click to search for files that match the query.

- **Output**:
  - The output area displays the result of operations such as directory contents, file copy status, or search results.

### Logging

- The program logs all operations to a log file located in the `logs/file_manager.log` file.

## Troubleshooting

- **Missing JavaFX Libraries**: Ensure the JavaFX libraries are correctly referenced in your `pom.xml` file. If the program fails to start, double-check the module paths specified in the run configuration.
- **Permission Issues**: Ensure you have the necessary permissions to read, write, or delete files and directories on your system.

## Contributing

Contributions are welcome! Please fork this repository and submit a pull request with your improvements or bug fixes.
