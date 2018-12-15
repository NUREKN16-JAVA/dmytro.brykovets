package ua.nure.brykovets.dmytro.usermanagement.gui.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import ua.nure.brykovets.dmytro.usermanagement.User;
import ua.nure.brykovets.dmytro.usermanagement.db.*;
import ua.nure.brykovets.dmytro.usermanagement.util.UTF8Control;

import java.io.IOException;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class BrowseController {

    public GridPane mainPane;
    public TableView<User> usersTable;
    public Button addButton;
    public Button editButton;
    public Button deleteButton;
    public Button detailsButton;

    private ResourceBundle bundle = ResourceBundle.getBundle("strings", Locale.getDefault(), new UTF8Control());
    private UserDao dao = DaoFactory.getInstance().getUserDao();

    public BrowseController() {
        Platform.runLater(() -> {
            initUsersTable();

            addButton.requestFocus();
        });
    }

    public void initUsersTable() {
        try {
            ObservableList<User> users = FXCollections.observableArrayList(dao.findAll());
            usersTable.setItems(users);
        } catch (DatabaseException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.showAndWait();
        }
    }

    private User getSelectedUser() {
         return usersTable.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void showAddUserPane() throws IOException {
        Parent addUserPane = FXMLLoader.load(getClass().getResource("/view/add_user.fxml"), bundle);
        Platform.runLater(() -> {
            Stage window = (Stage) mainPane.getScene().getWindow();
            window.setScene(new Scene(addUserPane));
        });
    }

    @FXML
    private void showEditUserPane() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/edit_user.fxml"), bundle);
        Parent editUserPane = loader.load();
        EditUserController controller = loader.getController();

        User selectedUser = getSelectedUser();
        if (selectedUser != null) {
            controller.setUserData(selectedUser);
            Platform.runLater(() -> {
                Stage window = (Stage) mainPane.getScene().getWindow();
                window.setScene(new Scene(editUserPane));
            });
        }
    }

    @FXML
    private void showUserDetailsPane() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/user_details.fxml"), bundle);
        Parent userDetailsPane = loader.load();
        UserDetailsController controller = loader.getController();

        User selectedUser = getSelectedUser();
        if (selectedUser != null) {
            controller.setUserData(selectedUser);
            Platform.runLater(() -> {
                Stage window = (Stage) mainPane.getScene().getWindow();
                window.setScene(new Scene(userDetailsPane));
            });
        }
    }

    @FXML
    private void deleteUser() {
        User selectedUser = getSelectedUser();
        if (selectedUser != null) {
            Alert warningAlert = new Alert(Alert.AlertType.CONFIRMATION, bundle.getString("browse.alert.deleteUser"));
            Optional<ButtonType> result = warningAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    dao.delete(selectedUser);
                    initUsersTable();
                } catch (DatabaseException e) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR, e.getMessage());
                    errorAlert.showAndWait();
                }
            }
        }
    }
}
