package ua.nure.brykovets.dmytro.usermanagement.gui;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class MainController {

    public GridPane mainGridPane;
    public TableView usersTable;
    public Button addButton;
    public Button editButton;
    public Button deleteButton;
    public Button detailsButton;

    public MainController() {
        Platform.runLater(() -> addButton.requestFocus());
    }

}
