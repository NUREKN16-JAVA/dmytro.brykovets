package ua.nure.brykovets.dmytro.usermanagement.gui.controller;

import javafx.scene.control.Label;
import ua.nure.brykovets.dmytro.usermanagement.User;

public class UserDetailsController extends UserController {

    public Label firstNameLabel;
    public Label lastNameLabel;
    public Label dateOfBirthLabel;

    public UserDetailsController() {
    }

    public void setUserData(User user) {
        firstNameLabel.setText(user.getFirstName());
        lastNameLabel.setText(user.getLastName());
        dateOfBirthLabel.setText(user.getDateOfBirth().toString());
    }
}
