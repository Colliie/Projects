import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

/* Utility class for file scanner */
public class FileInputSc {
    protected static List<String> lines;

    public static List<String> readFile(String fileName) throws IOException {
        lines = new ArrayList<>();
        InputStream inputStream = FileInputSc.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            System.out.println("File not found: " + fileName);
            return lines;
        }
        try (Scanner scanner = new Scanner(inputStream)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        }
        return lines;
    }
}
