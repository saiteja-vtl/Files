import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterApp {

    public static void main(String[] args) {
        FileWriterApp app = new FileWriterApp();
        app.promptForFilePath();
    }

    public void promptForFilePath() {
        Scanner scanner = new Scanner(System.in);
        String filePath;
        boolean validPath = false;

        while (!validPath) {
            System.out.print("Enter the file path: ");
            filePath = scanner.nextLine();

            try {
                System.out.println("Choose an action: ");
                System.out.println("1. Write to file (overwrite)");
                System.out.println("2. Append to file");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume the leftover newline

                switch (choice) {
                    case 1:
                        writeToFile(filePath);
                        break;
                    case 2:
                        appendToFile(filePath);
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose 1 or 2.");
                        break;
                }

                validPath = true;  // If no exception, file writing is successful
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }

    public void writeToFile(String filePath) throws IOException {

        System.out.println("Enter text to write to the file:");
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();


        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("Successfully written to the file using FileWriter.");
        }
    }

    public void appendToFile(String filePath) throws IOException {

        System.out.println("Enter text to append to the file:");
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();


        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(content);
            System.out.println("Successfully appended to the file using FileWriter.");
        }
    }

    public void writeMultipleLines(String filePath) throws IOException {
        String content = "First line of text.\nSecond line of text.\nThird line of text.";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("Successfully written multiple lines to the file.");
        }
    }

    public void writeToFileOverwrite(String filePath) throws IOException {
        String content = "This will overwrite existing content.";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("Successfully overwritten the file content.");
        }
    }

    public void writeToFileWithExceptionHandling(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Sample content.");
            System.out.println("Successfully written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

