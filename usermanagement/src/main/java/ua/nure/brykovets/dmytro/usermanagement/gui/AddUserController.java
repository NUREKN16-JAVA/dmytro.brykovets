package ua.nure.brykovets.dmytro.usermanagement.gui;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddUserController {

    public GridPane addUserPane;
    public TextField firstNameField;
    public TextField lastNameField;
    public DatePicker dateOfBirthPicker;
    public Button addButton;
    public Button cancelButton;

    public AddUserController() {

    }
}
