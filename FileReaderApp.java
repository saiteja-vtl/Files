import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileReaderApp {

    public void readFile(String filePath) throws IOException {
        // Read all lines from the file
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("The file does not exist.");
        }

        if (!file.canRead()) {
            throw new IOException("The file cannot be read.");
        }

        System.out.println("Reading file: " + filePath);
        Files.lines(Paths.get(filePath)).forEach(System.out::println);
    }

    public void promptForFilePath() {
        Scanner scanner = new Scanner(System.in);
        String filePath;
        boolean validFile = false;

        while (!validFile) {
            System.out.print("Enter the file path: ");
            filePath = scanner.nextLine();

            try {
                readFile(filePath);
                validFile = true;
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please try again.");
            } catch (IOException e) {
                System.out.println("Error reading the file. Please try again.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        FileReaderApp app = new FileReaderApp();
        app.promptForFilePath();
    }


}
