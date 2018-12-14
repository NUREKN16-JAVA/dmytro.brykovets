package ua.nure.brykovets.dmytro.usermanagement.gui.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import ua.nure.brykovets.dmytro.usermanagement.User;
import ua.nure.brykovets.dmytro.usermanagement.db.*;

import java.io.IOException;

public class BrowseController {

    public GridPane mainPane;
    public TableView<User> usersTable;
    public Button addButton;
    public Button editButton;
    public Button deleteButton;
    public Button detailsButton;

    public BrowseController() {
        Platform.runLater(() -> {
            initUsersTable();

            addButton.requestFocus();
        });
    }

    private void initUsersTable() {
        try {
            UserDao dao = DaoFactory.getInstance().getUserDao();
            ObservableList<User> users = FXCollections.observableArrayList(dao.findAll());
            usersTable.setItems(users);
        } catch (DatabaseException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void showAddUserPane() throws IOException {
        Parent addUserPane = FXMLLoader.load(getClass().getResource("/view/add_user.fxml"));
        Platform.runLater(() -> {
            Stage window = (Stage) mainPane.getScene().getWindow();
            window.setScene(new Scene(addUserPane));
        });
    }

}
