import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.FileWriter;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.TextField;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileReader;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;


public class BookManagementController {

    @FXML private TableView<Book> bookTableView;
    @FXML private TableColumn<Book, String> titleColumn;
    @FXML private TableColumn<Book, String> authorColumn;
    @FXML private TextField searchTextField;

    // FXML event handler methods for various actions
    @FXML
    private void handleAddBook(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddBookScreen.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Add Book");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleDeleteBook(ActionEvent event) {
        System.out.println("Delete Book clicked");
    }

    @FXML
    private void handleProcessSale(ActionEvent event) {
        System.out.println("Process Sale clicked");
    }

    @FXML
    private void handleRevenueSummary(ActionEvent event) {
        System.out.println("Revenue Summary clicked");
    }

    @FXML
    private void handleSaleRecords(ActionEvent event) {
        System.out.println("Sale Records clicked");
    }

    @FXML
    private void handleSearchBook(ActionEvent event) {
        ObservableList<Book> results = FXCollections.observableArrayList();
        String keyword = searchTextField.getText().toLowerCase();

        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(keyword)) {
                    String[] parts = line.split(",");
                    Book book = new Book(
                            parts[0], // ISBN
                            parts[1], // Title
                            parts[2], // Author
                            parts[3], // Genre
                            Double.parseDouble(parts[4]), // Price
                            Integer.parseInt(parts[5])    // Quantity
                    );
                    results.add(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        bookTableView.setItems(results);
    }

    @FXML
    public void initialize() {
        // Ensure the columns are not null
        if (titleColumn == null || authorColumn == null) {
            System.out.println("Columns are not properly initialized.");
        } else {
            // Set the cell value factories to link the columns with Book properties
            titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
            authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        }
    }

    @FXML
    private void handleViewInventory(ActionEvent event) {
        System.out.println("View Inventory clicked");
    }

    @FXML private TextField authorField;
    @FXML private TextField genreField;
    @FXML private TextField isbnField;
    @FXML private TextField priceField;
    @FXML private TextField titleField;
    @FXML private TextField yearField;

    @FXML
    void handleSaveInfo(ActionEvent event) {
        String title = titleField.getText();
        String author = authorField.getText();
        String genre = genreField.getText();
        String year = yearField.getText();
        String isbn = isbnField.getText();
        String priceText = priceField.getText();

        try {
            double price = Double.parseDouble(priceText);

            // Create a Book object (you can include year as quantity or add a new quantity field if needed)
            Book book = new Book(isbn, title, author, genre, price, 1); // Quantity is set to 1

            // Call method to save to file
            saveBookToFile(book);

            System.out.println("Book saved to file.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid price format.");
        } catch (IOException e) {
            System.out.println("Error saving book: " + e.getMessage());
        }
    }

    private void saveBookToFile(Book book) throws IOException {
        try (FileWriter writer = new FileWriter("books.txt", true)) { // true means append mode
            writer.write(book.toString() + System.lineSeparator()); // Save book info in one line
        }
    }

}
