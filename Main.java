import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class Main extends Application {

    @FXML
    private Button btnAddBook, btnDeleteBook, btnProcessSale,
            btnRevenueSummary, btnSaleRecords,
            btnSearchBook, btnViewInventory;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Bookworm Management System");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
