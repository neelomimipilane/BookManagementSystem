import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookStorage {
    private static final String FILE_PATH = "books.txt";

    // Save a book to the file
    public static void saveBook(Book book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(book.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving book: " + e.getMessage());
        }
    }

    // Load all books from the file
    public static List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                books.add(Book.fromString(line));
            }
        } catch (IOException e) {
            System.err.println("Error loading books: " + e.getMessage());
        }
        return books;
    }
}

