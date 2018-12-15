package ua.nure.brykovets.dmytro.usermanagement.gui.controller;

import javafx.scene.control.Alert;
import ua.nure.brykovets.dmytro.usermanagement.User;
import ua.nure.brykovets.dmytro.usermanagement.db.DaoFactory;
import ua.nure.brykovets.dmytro.usermanagement.db.DatabaseException;
import ua.nure.brykovets.dmytro.usermanagement.db.UserDao;

import java.io.IOException;
import java.time.LocalDate;

public class AddUserController extends UserController {

    public AddUserController() {
        initDatePicker();
    }

    public void addUser() throws IOException {

        if (validateFields()) {

            UserDao dao = DaoFactory.getInstance().getUserDao();
            User user = new User();

            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            LocalDate dateOfBirth = dateOfBirthPicker.getValue();

            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setDateOfBirth(dateOfBirth);

            try {
                dao.create(user);
            } catch (DatabaseException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
                alert.showAndWait();
            }

            showBrowsePane();
        }
    }
}
