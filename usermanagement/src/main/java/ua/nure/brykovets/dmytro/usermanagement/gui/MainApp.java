package ua.nure.brykovets.dmytro.usermanagement.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ua.nure.brykovets.dmytro.usermanagement.util.UTF8Control;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ResourceBundle bundle = ResourceBundle.getBundle("strings", Locale.getDefault(), new UTF8Control());

        Parent root = FXMLLoader.load(getClass().getResource("/view/browse.fxml"), bundle);

        primaryStage.setTitle(bundle.getString("browse.title"));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
