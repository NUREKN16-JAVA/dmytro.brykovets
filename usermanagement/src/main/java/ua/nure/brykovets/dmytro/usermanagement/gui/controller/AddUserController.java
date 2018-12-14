package ua.nure.brykovets.dmytro.usermanagement.gui.controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import ua.nure.brykovets.dmytro.usermanagement.User;
import ua.nure.brykovets.dmytro.usermanagement.db.DaoFactory;
import ua.nure.brykovets.dmytro.usermanagement.db.DatabaseException;
import ua.nure.brykovets.dmytro.usermanagement.db.UserDao;
import ua.nure.brykovets.dmytro.usermanagement.util.UTF8Control;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class AddUserController {

    public GridPane addUserPane;
    public TextField firstNameField;
    public TextField lastNameField;
    public DatePicker dateOfBirthPicker;
    public Button addButton;
    public Button cancelButton;

    public AddUserController() {}

    public void addUser() throws IOException {
        UserDao dao = DaoFactory.getInstance().getUserDao();
        User user = new User();

        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();

        try {
            java.sql.Date sqlDate = java.sql.Date.valueOf(dateOfBirthPicker.getValue());
            Date dateOfBirth = new Date(sqlDate.getTime());
            user.setDateOfBirth(dateOfBirth);

            resetHighlight(dateOfBirthPicker);
        } catch (Exception e) {
            highlightError(dateOfBirthPicker);
        }

        if (validateUserData(firstName, lastName)) {

            user.setFirstName(firstName);
            user.setLastName(lastName);

            try {
                dao.create(user);
            } catch (DatabaseException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
                alert.showAndWait();
            }

            showBrowsePane();
        }
    }

    public void showBrowsePane() throws IOException {
        ResourceBundle bundle = ResourceBundle.getBundle("strings", Locale.getDefault(), new UTF8Control());
        Parent browsePane = FXMLLoader.load(getClass().getResource("/view/browse.fxml"), bundle);
        Platform.runLater(() -> {
            Stage window = (Stage) addUserPane.getScene().getWindow();
            window.setScene(new Scene(browsePane));
        });
    }

    private boolean validateUserData(String firstName, String lastName) {
        boolean isValid = true;
        if (firstName.isEmpty()) {
            highlightError(firstNameField);
            isValid = false;
        } else {
            resetHighlight(firstNameField);
        }
        if (lastName.isEmpty()) {
            highlightError(lastNameField);
            isValid = false;
        } else {
            resetHighlight(lastNameField);
        }
        return isValid;
    }

    private void highlightError(Control field) {
        field.setStyle("-fx-border-color: red;  -fx-border-width: 2px");
    }

    private void resetHighlight(Control field) {
        field.setStyle("-fx-border-color: default;  -fx-border-width: default");
    }
}
